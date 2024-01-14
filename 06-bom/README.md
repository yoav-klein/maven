# BOM (Bill of Materials)
---

BOM is a Maven project which includes no source code, but rather just a POM which declares <dependencyManagement>, in which
you specify a set of dependencies and their versions.

So it works like this:
* We have the `my-lib` project, which is a simple library. Go on and publish this with various versions (1.2, 1.3, 1.4 for the manner of sake).
* We have the `bom-project` project. Take a look at the `pom.xml` - it declares a specific version of the foo library, you can play with it as you like. Go on and publish this package to your repository.
* We have the `consuming-project`. This declares the pom project as a `dependencyManagement` item. Then, it declares
the `foo` library as a dependency, with no version.

Now run the `consuming-project` with `mvn package` - and see that it consumes the correct version of `foo` as defined in the BOM.