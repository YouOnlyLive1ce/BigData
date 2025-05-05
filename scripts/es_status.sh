curl 'localhost:9200/_cat/shards/airbnb?v'
curl 'localhost:9200/_cat/indices/airbnb?v&h=index,store.size,pri.store.size'
curl 'localhost:9200/_cat/nodes?v&h=name,shards,disk.used,disk.avail'
curl 'localhost:9200/airbnb/_stats?pretty'