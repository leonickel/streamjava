# Stream Java
This system was developed following the premises below received by email:
```console
Write a stream sampler that picks a random (representative) sample of size k from a stream of values with unknown and possibly very large length.
As for receiving the data the sampler should work with two kinds of inputs:
• Values piped directly into the process (stdin)
• Values generated used a good random source provided by your programming language
```

## Technologies
At this section I'll list and explain which technologies I've chosen to work on:
* Java 8 - the required language for this application
* Google Guice - This library manages object creation and instantiation and it's very lightweight in order to avoid heavy  footprints during bootstrap application [https://github.com/google/guice]
* Logback - Async logging library [http://logback.qos.ch/]
* JUnit - unit tests framework to test each class and method individually [http://junit.org/junit4/]

## Motivations
The system was designed to be simple but at the same time using approaches to help easy understanding, maintain and improve the system like some other production should have. Below there's a list of mindsets that guided implementation:
* Stream Java 8 feature - I've used this feature from Java 8 in order to create a clean code with good understanding. I've also put ".paralel()" clause to get performance improvement using as many processor as needed and ".limit()" to limit values according with provided sample_size. And for collecting the results I've implemented a lambda expression to get each character and append on a StringBuilder object. I've decided not using Collector or Maps or Filters to avoid doing objects conversions because doing that will increase memory consumption.
* Logging - every production application must have logging for troubleshooting and to know used parameters on each flow and so on.
* IoC - Using IoC (Inversion of Control) mechanism helps to not creating a lot of objects in memory and avoiding large footprints besides code gets simpler as well. 
* Unit tests - To make sure all the corner cases were coverage including code coverage.

## How to run
The system produces a fat jar at the end of 'package' step. To generate it, it's mandatory to have Maven and Java 8 installed on machine. After setting up these mandatories, just run the following command:
> `mvn clean package`

The fat jar called 'StreamJava.jar' should be generated at target/ folder. To run the application, just execute the command below:
> `java -jar target/StreamJava.jar [SAMPLE_SIZE]`

where [SAMPLE_SIZE] parameter it's the sample size to be generated. Providing only sample_size will let the system generate a random stream using UUID mechanism. If you want to provide a sample, you just need to pass it as second parameter as described below:
> `java -jar target/StreamJava.jar [SAMPLE_SIZE] [STREAM_VALUE]`

Below you can see logging after an executing providing just sample_size = 5:
> `java -jar target/StreamJava.jar 5`
```console
2016-09-11 22:12:40,268 [INFO] [main] [application] sample size: [5]
2016-09-11 22:12:40,543 [INFO] [main] [application] generated sample: [5bca6] from stream: [a6bc5647-0f30-4448-8a20-87d972286832]
```

Note: in case [STREAM_VALUE] it's a compound word like ABC DEF, you should wrap like this: "ABC DEF". See command line example below:
> `java -jar target/StreamJava.jar 5 "ABC DEF"`


## FAQ and Troubleshooting
* Running application without providing any parameter 

> `java -jar target/StreamJava.jar`

The system will print error message like this:

```console
2016-09-11 22:14:28,256 [ERROR] [main] [application] >>>>>>>>>>>>>>>>>>>>> HOW TO RUN <<<<<<<<<<<<<<<<<<<<<<
2016-09-11 22:14:28,258 [ERROR] [main] [application] First parameter must be size sample (int) 
2016-09-11 22:14:28,258 [ERROR] [main] [application] Second parameter (optional) must be stream value 
2016-09-11 22:14:28,258 [ERROR] [main] [application] Example: java -jar target/StreamJava.jar 5 ABCDEFGHIJKL
2016-09-11 22:14:28,258 [ERROR] [main] [application] >>>>>>>>>>>>>>>>>>>>>> EXITTING <<<<<<<<<<<<<<<<<<<<<<<
```
and will exit. [SAMPLE_SIZE] is mandatory and should be passed by at startup.

* Running application providing invalid [SAMPLE_SIZE]

> `java -jar target/StreamJava.jar a`

The system will print error message like this:

```console
2016-09-11 22:27:18,921 [ERROR] [main] [application] the sample size must be a positive number, exitting...
```
and will exit. [SAMPLE_SIZE] must be a positive number.