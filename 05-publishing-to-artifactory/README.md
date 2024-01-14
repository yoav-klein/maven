# Publishing to Artifactory server
---
Same as 04-publishing, only working with Artifactory server.
In order to publish to snapshots and release repositories, you need to have
the username and password of the user that can publish to the repository
configured in the `~/.m2/settings.xml` file, as such:
```
  <servers>
    <server>
      <username>admin</username>
      <password>YoavKlein3</password>
      <id>central</id>
    </server>
  </servers>

```

The `id` tag value should correspond to the `id` in the pom.xml.