README

Sourse to data:
January 2020.
https://www.nyc.gov/html/dot/html/bicyclists/bikestats.shtml

i accidently name the file as 2021 and go with it. 

$ hdfs dfs -setfacl -m user:cr3152:r-x /user/hy2156_nyu_edu
$ hdfs dfs -setfacl -m user:cl6405:rw- /user/hy2156_nyu_edu
$ hdfs dfs -setfacl -m user:adm209:rwx /user/hy2156_nyu_edu
hdfs dfs -getfacl /user/hy2156_nyu_edu

	
The reason why there are a big differerntce of line before and after clean is because i want to preserve unique coordinates
i do not need how many time each instance of bike station show up. 
====

big data homework 7 command:

vi...sh

chmod:chmod +x blcp.sh

download:hdfs dfs -get /user/hy2156_nyu_edu/CountRecs.jar

complie:


javac -classpath `yarn classpath` -d . CountRecsMapper.java

javac -classpath `yarn classpath` -d . CountRecsReducer.java

javac -classpath `yarn classpath`:. -d . CountRecs.java

jar -cvf CountRecs.jar *.class

chmod:
chmod +x crrm.sh
remove:
rm CountRecsMapper.java
rm CountRecsReducer.java
rm CountRecs.java

hdfs dfs -rm CountRecsMapper.java
hdfs dfs -rm CountRecsReducer.java
hdfs dfs -rm CountRecs.java

upload to hdfs:
hdfs dfs -put CountRecsMapper.java
hdfs dfs -put CountRecsReducer.java
hdfs dfs -put CountRecs.java

hdfs dfs -put hw3.txt


run command:
hadoop jar CountRecs.jar CountRecs /user/hy2156_nyu_edu/2021.csv /user/hy2156_nyu_edu/hw7cr

see output:
hdfs dfs -cat badlong2/part-r-00000


Compile

javac -classpath `yarn classpath` -d . CleanMapper.java

javac -classpath `yarn classpath` -d . CleanReducer.java

javac -classpath `yarn classpath`:. -d . Clean.java

jar -cvf Clean.jar *.class


remove:
rm CleanMapper.java
rm CleanReducer.java
rm Clean.java

hdfs dfs -rm CleanMapper.java
hdfs dfs -rm CleanReducer.java
hdfs dfs -rm Clean.java

upload to hdfs:
hdfs dfs -put CleanMapper.java
hdfs dfs -put CleanReducer.java
hdfs dfs -put Clean.java
vi
hdfs dfs -put 2021.csv


run command:
hadoop jar Clean.jar Clean /user/hy2156_nyu_edu/2021.csv /user/hy2156_nyu_edu/hw7cl2

see output:
hdfs dfs -cat hw7cl2/part-r-00000


Compile

javac -classpath `yarn classpath` -d . CleanMapper.java

javac -classpath `yarn classpath` -d . CleanReducer.java

javac -classpath `yarn classpath`:. -d . Clean.java

jar -cvf Clean.jar *.class


remove:
rm CleanMapper.java
rm CleanReducer.java
rm Clean.java

hdfs dfs -rm CleanMapper.java
hdfs dfs -rm CleanReducer.java
hdfs dfs -rm Clean.java

upload to hdfs:
hdfs dfs -put CleanMapper.java
hdfs dfs -put CleanReducer.java
hdfs dfs -put Clean.java

hdfs dfs -put 2021.csv
hdfs dfs -put clean_data.txt


run command:
hadoop jar Clean.jar Clean /user/hy2156_nyu_edu/2021.csv/user/hy2156_nyu_edu/hw7cl1

hadoop jar CountRecs.jar CountRecs /user/hy2156_nyu_edu/clean_data.txt /user/hy2156_nyu_edu/hw7cr_after

see output:
hdfs dfs -cat hw7cl1/part-r-00000


/home/hy2156_nyu_edu/Clean.class
/home/hy2156_nyu_edu/CleanReducer.class
/home/hy2156_nyu_edu/CleanMapper.class
/home/hy2156_nyu_edu/CountRecs.class
/home/hy2156_nyu_edu/CountRecsReducer.class
/home/hy2156_nyu_edu/CountRecsMapper.class





give permission:?
For full credit, provide the classes, jars, data and source files for each job and ways to access the datasource//
link to data sourse

hdfs dfs -chmod -R 777 /cr3152 /cl6405 /adm209