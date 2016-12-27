# mapreduce-sample
A sample map reduce job to replicate and play with..

To Build : -  ./gradlew jar

To Run : - hadoop jar build/libs/mapreduce-1.0-SNAPSHOT.jar com.sample.WordCount -Dinput.path=hdfs://localhost:9000/tmp/input.txt -Doutput.path=hdfs://localhost:9000/out/run3


Nice Doc for understanding

http://bradhedlund.com/2011/09/10/understanding-hadoop-clusters-and-the-network/


Links to setup hadoop locally.

https://amodernstory.com/2014/09/23/installing-hadoop-on-mac-osx-yosemite/

http://zhongyaonan.com/hadoop-tutorial/setting-up-hadoop-2-6-on-mac-osx-yosemite.html


