# Dependencies
---

In this example, we have 2 projects. The `Dog` project is a library
which we'll consume in the `my-app` project.

## Creating the Dog library
---

cd into the dog directory. Now let's build and install the project to the
local Mavaen repository.

```
$ mvn clean install
```
Now, you have the dog project installed in your local maven repository, so that
you can consume it from other projects in the machine.

## Consuming the dog project
---
cd into the my-app directory.

In the pom.xml, we have the dog project configured as a dependency.
Compile and package:

```
$ mvn clean package
```

If you now run:
```
$ java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```
You'll get a:
```
Exception in thread "main" java.lang.NoClassDefFoundError: com/mycompany/animals/Dog
        at com.mycompany.app.App.main(App.java:12)
Caused by: java.lang.ClassNotFoundException: com.mycompany.animals.Dog
        at java.net.URLClassLoader.findClass(URLClassLoader.java:387)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:352)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
        ... 1 more
```

That's because the Dog class in not in your classpath.


### How to handle this

#### First option - Retrieve the CLASSPATH you need
```
$ mvn dependency:build-classpath
...
C:\Users\yoavk\.m2\repository\junit\junit\4.11\junit-4.11.jar;C:\Users\yoavk\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;C:\Users\yoavk\.m2\repository\com\mycompany\animals\dog\1.0-SNAPSHOT\dog-1.0-SNAPSHOT.jar
```

You can now take this string and define it with the `-cp` option

Go ahead and try it.

#### Second option - copy dependencies
You can use the `copy-dependencies` goal from the `dependencies` plugin.
This will copy the necessary dependency artifacts to the build directory, 
so that you can specify your classpath to this directory and run.

This is demonstrated in `my-app2`. cd into this directory and run

```
$ mvn clean package
```
You'll see that the `target/libs` directory contains all the dependencies that your project needs in order to run.
Now we can run our application as such:
```
java -cp ".\target\my-app-1.0-SNAPSHOT.jar;target/libs/*" com.mycompany.app.App
```