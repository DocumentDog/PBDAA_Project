# PBDAA_Project
sourse of data:
bike:https://www.nyc.gov/html/dot/html/bicyclists/bikestats.shtml (2020, january,rename it as 2021 by mistake )
crime:https://data.cityofnewyork.us/Public-Safety/NYPD-Complaint-Data-Historic/qgea-i56i?category=Public-Safety&view_name=NYPD-Complaint-Data-Historic
real time passanger (bus):https://data.cityofnewyork.us/Transportation/Real-Time-Passenger-Information-Sign-Locations-Map/2haw-rqv4




brief explaination on how our data are modified: 

Bike Data: 202001-citibike-tripdata.csv-rename=>2021.cvs-cleaning data via mapreudce-> clean_data.txt -analyze nearby bike with scala ->bikesortbylatitude.cvs-combined with crimesortbylatitude.cvs-> bikecrimeratio.csv

crime Data: crime_data.cvs->mapredudue->output1000line.cvs->profiling nearby crime->bikecrimesortbylatitude.cvs/ bussortbylatitude.cvs

Bus Data: Real_Time_Passenger_Information_Sign_Locations.csv->rename->bus-clean by mapreduce->bussortbylatitude=analyize by scala->buscrimeratio.cvs.

trendline: bikecrimeratio.cvs /buscrimeration.cvs -anayize for trendline-> vistiulized via csv



introduction to our projects:
we want to study the correlation between bike/bus density vs crime amount near by. we define density of bus/bike as how many other bus/bike station are nearby each bus/bike stations. In order to do that we first use mapreduce to clean our source data, only keeping the latitude and longitude. Then we use linear regression by using scala module to find the density of each coordinates. we define the range of nearby as stations within a circle of raduis of 0.025. 
Lastly we use scala to find the trendline and visualize it with csv.   



In order of rerunning our project, you should follow the instructions:

1: download source file from website above/or you can see them already downloaded in directory data_ingest/source_data\n 
2:cleaning the sourcefile via mapreduce, the crime cvs should be shrunk down to the first 1000 line only.(check etl directory)
3:using mapreduce to do the profiling counting the length of files before and after cleaning.(check profile code directory) after running mapreduce, using replace function of txt
(clrt f)to remove the extra zero at the end if there are one.
4:using scala to do the first analytical, to get bike/bus sortbylatitude.cvs (check ana_code/first_analysis directory) 
5:using scala to do the second anayltical, to get bike/bus crimeratio.cvs(check ana_code/second_analysis directory) be aware that header needs to be ignored in scala or deleted from sourse files.
6:using scala to do the second analytical, to get trendline for bus/bike denstity as x axis and crime amounts as y axis(check ana_code/second_analysis directory)




ps:because we only use first 1000 crime , our data might be biased; also the data I used for project is in data_souce on hdfs, which I have already shared the access.
