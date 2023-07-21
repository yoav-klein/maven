# Packaging
---

This example builds on the `my-app2` project of the previous example.

So we have our application that depends on the `dog` project, and we've configured
our project with the `copy-dependencies` goal so that the dependencies will be copied to 
our build directory.

Now we want to pack our application in a runnable jar, so we can run it easily.

## Without dependencies
---
In this example, we don't include the dependencies inside the jar. We use the `copy-dependencies`
goal to create the `libs` directory, and create a runnable jar which is configured to 
include the `libs` directory in its CLASSPATH.

This is done by configuring the `maven-jar-plugin`, see in the `pom.xml`


### Build and run
---
Build the application:
```
$ mvn clean package
```

Run the application:
```
$ java -jar target/my-app-1.0-SNAPSHOT.jar
```

### Port the application
You can now copy the `my-app-1.0-SNAPSHOT.jar`, along with the `libs` directory
to wherever you like, and it will run.

## With dependencies
---
It's more convenient to have a runnable JAR with all the dependencies inside.

This can be done in various ways, see: https://www.baeldung.com/executable-jar-with-maven

We'll use the Maven Assembly plugin. Take a look at the `pom.xml` to see how it's done.

### Build and run
---
Build the application:
```
$ mvn clean package
```
This will create both a `my-app-1.0-SNAPSHOT.jar` and  a `my-app-1.0-SNAPSHOT-jar-with-dependencies.jar`

Run the application:
```
$ java -jar target/my-app-1.0-SNAPHOST-jar-with-dependencies.jar
```

