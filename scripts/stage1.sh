#!/bin/bash
# Whole script executes 50seconds

cd /home/team24/BigData

source ./venv/bin/activate

pip install -r requirements.txt

password=$(head -n 1 secrets/.psql.pass)

python3 ./scripts/preprocess.py

# build sql on master node
python3 ./scripts/build_projectdb.py

hdfs dfs -rm -r -skipTrash ./project

# import data to hdfs for further distributed query via HQL
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team24_projectdb --username team24 --password $password --compression-codec=snappy --compress --as-parquetfile --warehouse-dir=./project/warehouse --m 1

# print data space usage
hdfs dfs -du -h