because some of our code have same names, it would be wise to delete them after using them on hdfs to pervent renaming. 

example:

hdfs dfs -rm -r -f clean.jar/class/mapper....
hdfs dfs -rm -r -f output7...
hdfs dfs -rm -r -f hw/input...
hdfs dfs -mkdir hw hdfs dfs -mkdir hw/input
hdfs dfs -put bus./2021/crime...csv hw/input


