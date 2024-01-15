# BOM (Bill of Materials)
---

See the explanation about BOM in [Maven documenation](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)

It works like this: we have the BOM project, which is the top-level project. The BOM project contains no source code, it is just used to declare the mix of versions of the submodules.

Next, there's the `parent` project, which is the only submodule of the BOM project. This is also a project with no source code, it's just used as another level between the BOM project and the actual code projects. Why do we need it?
1. The code projects declare a parent. If this parent is the BOM project, we'll need to change it in all those code projects each time we want to change the version of the BOM project.
2. If we need extra dependency management information which we don't want the consuming project to import.

Next, there are the code projects (`foo` and `bar`). The code projects inherit from the parent project, and therefore
inherits the `fooVersion` and `barVersion` properties, and uses those to define their versions.

Finally, we get to the consuming project. The consuming project declares the BOM project as a dependency management of scope `import`. This way, the consuming project has the versions of all the code projects by merely specifying the version of the BOM project. The consuming project can now declare whatever artifacts from the code projects it wants (either `bar`, `foo` or both) without specifying the versions, and it will get a set of versions that play well together.
