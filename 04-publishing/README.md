# Publishing and consuming packages
---

In this example we demonstrate how to deploy a package and consume it from a custom repository.

We have the `foo` library in the `my-lib` directory, which is a simple demo library. The `my-app` project
consumes the foo library and uses it.

We use a local filesystem path as our repository, but the concept is the same for binary repositories
like Artifactory, Nexus, or what have you.

The `my-lib` project uses the `<distributionManagement/>` section to define to where to deploy 
the packages.
On the contrary, the `my-app` project uses the `<repositories/>` section to define where to look for dependencies.