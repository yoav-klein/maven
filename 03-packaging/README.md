# Packaging
---

This example builds on the `my-app2` project of the previous example.

So we have our application that depends on the `dog` project, and we've configured
our project with the `copy-dependencies` goal so that the dependencies will be copied to 
our build directory.

Now we want to pack our application in a runnable jar, so we can run it easily.

This is done by configuring the `maven-jar-plugin`, see in the `pom.xml`

## Build and run
---
Build the application:
```
$ mvn clean package
```

Run the application:
```
$ java -jar target/my-app-1.0-SNAPSHOT.jar
```

## Port the application
You can now copy the `my-app-1.0-SNAPSHOT.jar`, along with the `libs` directory
to wherever you like, and it will run.
