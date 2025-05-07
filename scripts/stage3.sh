#!/bin/bash

echo 'Construct pipeline and encoe data'
spark-submit --master yarn ./scripts/pipeline.py
echo 'Train model 1'
spark-submit --master yarn ./scripts/model1_train.py
echo 'Train model 2'
spark-submit --master yarn ./scripts/model2_train.py

echo 'Get train.json from hdfs'
hdfs dfs -getmerge project/data/train ./data/train.json
echo 'Get test.json from hdfs'
hdfs dfs -getmerge project/data/test ./data/test.json

hdfs dfs -get project/models ./models

hdfs dfs -getmerge project/output/evaluation output/evaluation.csv
hdfs dfs -getmerge project/output/model1_predictions output/model1_predictions.csv
hdfs dfs -getmerge project/output/model2_predictions output/model2_predictions.csv
