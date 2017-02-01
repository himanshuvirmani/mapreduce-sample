# mapreduce-sample
A sample map reduce job to replicate and play with..

To Build : -  ./gradlew jar

To Run : - hadoop jar build/libs/mapreduce-1.0-SNAPSHOT.jar -Dinput.path=hdfs://localhost:9000/tmp/input.txt -Doutput.path=hdfs://localhost:9000/out/run3

NOTE :
Here com.sample.WordCount is added as Main Class Name while creating executable jar. If we give class name, toolrunner does not pick the configuration args. So if you want to give a seperate class name make sure you are not relying on tool runner to get he configs from run time args.


Nice Doc for understanding

http://bradhedlund.com/2011/09/10/understanding-hadoop-clusters-and-the-network/


Links to setup hadoop locally.

https://amodernstory.com/2014/09/23/installing-hadoop-on-mac-osx-yosemite/

http://zhongyaonan.com/hadoop-tutorial/setting-up-hadoop-2-6-on-mac-osx-yosemite.html


