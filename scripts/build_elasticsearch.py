import pandas as pd
from elasticsearch import Elasticsearch
from elasticsearch.helpers import bulk
from tqdm import tqdm
es = Elasticsearch("http://localhost:9200")

# specifying schema with datatypes
settings={
    "settings":{
        "number_of_shards": 4,   # split table into shards, those shards are saved on 2 nodes
        "number_of_replicas": 1, # in total, we will have original+1replica
        "refresh_interval": "30s" # How often new data becomes searchable (30 seconds here)
    },
    "mappings": {
        "properties": {
            "ID": {"type": "integer"},
            "name": {"type": "text"},
            "neighborhood_overview": {"type": "text"},
            "transit": {"type": "text"},
            "neighbourhood": {"type": "text"},
            "city": {"type": "text"},
            "state": {"type": "text"},
            "country": {"type": "text"},
            "zipcode": {"type": "keyword"},
            "summary": {"type": "text"},
            "property_type": {"type": "keyword"},
            "room_type": {"type": "keyword"},
            "accommodates": {"type": "float"},
            "bathrooms": {"type": "float"},
            "bedrooms": {"type": "float"},
            "beds": {"type": "float"},
            "bed_type": {"type": "keyword"},
            "square_feet": {"type": "float"},
            "price": {"type": "float"},
            "number_of_reviews": {"type": "float"},
            "review_scores_rating": {"type": "float"},
            "review_scores_cleanliness": {"type": "float"},
            "review_scores_location": {"type": "float"},
            "latitude": {"type": "float"},
            "longitude": {"type": "float"},
            "location": {"type": "geo_point"}
        }
    }
}

# if exists, recreate
index_name='airbnb'
if es.indices.exists(index=index_name):
    es.indices.delete(index=index_name)
es.indices.create(index=index_name, body=settings)

# documents filling
def prepare_document(row):
    doc = {
        "ID": row["ID"],
        "name": row.get("Name") if pd.notna(row.get("Name")) else None,
        "neighborhood_overview": row.get("Neighborhood Overview") if pd.notna(row.get("Neighborhood Overview")) else None,
        "transit": row.get("Transit") if pd.notna(row.get("Transit")) else None,
        "neighbourhood": row.get("Neighbourhood") if pd.notna(row.get("Neighbourhood")) else None,
        "city": row.get("City") if pd.notna(row.get("City")) else None,
        "state": row.get("State") if pd.notna(row.get("State")) else None,
        "country": row.get("Country") if pd.notna(row.get("Country")) else None,
        "zipcode": row.get("Zipcode") if pd.notna(row.get("Zipcode")) else None,
        "summary": row.get("Summary") if pd.notna(row.get("Summary")) else None,
        "property_type": row.get("Property Type") if pd.notna(row.get("Property Type")) else None,
        "room_type": row.get("Room Type") if pd.notna(row.get("Room Type")) else None,
        "accommodates": float(row.get("Accommodates")) if pd.notna(row.get("Accommodates")) else None,
        "bathrooms": float(row.get("Bathrooms")) if pd.notna(row.get("Bathrooms")) else None,
        "bedrooms": float(row.get("Bedrooms")) if pd.notna(row.get("Bedrooms")) else None,
        "beds": float(row.get("Beds")) if pd.notna(row.get("Beds")) else None,
        "bed_type": row.get("Bed Type") if pd.notna(row.get("Bed Type")) else None,
        "square_feet": float(row.get("Square Feet")) if pd.notna(row.get("Square Feet")) else None,
        "price": float(row.get("Price")) if pd.notna(row.get("Price")) else None,
        "number_of_reviews": float(row.get("Number of Reviews")) if pd.notna(row.get("Number of Reviews")) else None,
        "review_scores_rating": float(row.get("Review Scores Rating")) if pd.notna(row.get("Review Scores Rating")) else None,
        "review_scores_cleanliness": float(row.get("Review Scores Cleanliness")) if pd.notna(row.get("Review Scores Cleanliness")) else None,
        "review_scores_location": float(row.get("Review Scores Location")) if pd.notna(row.get("Review Scores Location")) else None,
        "latitude": float(row.get("Latitude")) if pd.notna(row.get("Latitude")) else None,
        "longitude": float(row.get("Longitude")) if pd.notna(row.get("Longitude")) else None,
        "location": f"{row.get('Latitude')},{row.get('Longitude')}" 
            if pd.notna(row.get('Latitude')) and pd.notna(row.get('Longitude')) 
            else None
    }
    return doc

df=pd.read_csv('./data/airbnb_24_preprocessed.csv')
# suxxess_count=0
# batch_size=500
# # Process in batches to avoid memory issues
# for i in range(0, len(df), batch_size):
#     batch = df.iloc[i:i+batch_size]
#     actions = [prepare_document(row) for _, row in batch.iterrows()]
#     suxxess,_=bulk(es, actions)
#     suxxess_count+=suxxess
#     if not suxxess:
#       print("Error processing batch")
    
def index_data_to_elasticsearch(es_client, index_name, df):
    """Index data to Elasticsearch using bulk operations."""
    try:
        total_docs = 0
        failed_docs = 0
        
        # Process in batches of 500
        batch_size = 500
        for i in tqdm(range(0, len(df), batch_size), desc="Indexing batches"):
            batch = df.iloc[i:i + batch_size]
            actions = []
            
            for _, row in batch.iterrows():
                try:
                    doc = prepare_document(row)
                    if doc:  # Only add valid documents
                        actions.append({"index": {"_index": index_name}})
                        actions.append(doc)
                except Exception as e:
                    print(f"Error preparing document: {e}")
                    failed_docs += 1
                    continue
            
            if actions:  # Only perform bulk operation if there are valid actions
                try:
                    response = es_client.bulk(operations=actions, refresh=True)
                    if response["errors"]:
                        failed_items = [item for item in response["items"] if "error" in item["index"]]
                        for item in failed_items:
                            print(f"Failed to index document: {item['index']['error']}")
                            failed_docs += 1
                    total_docs += len(actions) // 2  # Divide by 2 because each doc has 2 actions
                except Exception as e:
                    print(f"Bulk indexing error: {e}")
                    failed_docs += len(actions) // 2
        
        print(f"Indexed {total_docs} documents, {failed_docs} failed")
        
        # Force a refresh to ensure all documents are searchable
        es_client.indices.refresh(index=index_name)
        
        # Verify document count
        count = es_client.count(index=index_name)
        print(f"Total documents in index: {count['count']}")
        
        if total_docs - failed_docs != count['count']:
            print(f"Document count mismatch. Expected {total_docs - failed_docs}, got {count['count']}")
        
    except Exception as e:
        print(f"Error in bulk indexing: {e}")

index_data_to_elasticsearch(es,index_name,df)