from elasticsearch import Elasticsearch
import pandas as pd

# Connect to Elasticsearch
es = Elasticsearch("http://localhost:9200")

def get_shard_info(index_name=None):
    """Fetch and display shard information in a structured way."""
    
    # 1. Get shard allocation (with storage details)
    shards = es.cat.shards(index=index_name, format="json", bytes="mb", v=True)
    df_shards = pd.DataFrame(shards)
    
    # 2. Get disk allocation per node
    allocation = es.cat.allocation(format="json", bytes="mb", v=True)
    df_allocation = pd.DataFrame(allocation)
    
    # 3. Get index storage stats
    indices = es.cat.indices(index=index_name, format="json", bytes="mb", h="index,store.size,pri.store.size")
    df_indices = pd.DataFrame(indices)
    
    # 4. Cluster health (shard summary)
    health = es.cluster.health()
    
    # --- Print Results ---
    print("\n=== Cluster Health ===")
    print(f"Status: {health['status']} (Primary/Replica Shards: {health['active_shards']}/{health['active_shards'] - health['active_primary_shards']})")
    print(f"Unassigned Shards: {health['unassigned_shards']}")
    
    print("\n=== Shard Distribution ===")
    print(df_shards)
    
    print("\n=== Node Disk Usage ===")
    print(df_allocation)
    
    print("\n=== Index Storage Summary ===")
    print(df_indices)

# Example usage
get_shard_info("airbnb")  # Replace with your index name or None for all indices