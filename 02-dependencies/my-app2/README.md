# Simple
---

This project was created out of:
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

which creates a simple Maven project.

## Build the project
---
```
$ mvn package
```
this creates the build directory, which is `target`.
The default <packaging> type in Maven is `jar`, so that your application
is in a JAR.


## Run the application
---
In order to run the application, you need to define the jar as the CLASSPATH,
and specify the name of the main class.

Since the `package` of the source file is `com.mycompany.app`

```
$ java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```
