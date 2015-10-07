Found a weird bug in spring boot (or is it JAVA 8?). The precedence of loading the profiles is reversed when I switch between JAVA 7 and JAVA 8.

Steps to reproduce
------------------
* set JAVA_HOME to java 1.7 (I'm using 1.7.0_67)
* run mvn clean install. Tests pass.
* set JAVA_HOME to java 1.8 (I'm using 1.8.0_60)
* run mvn clean install. Tests fail.

Description of Issue
------------------
There are two profiles that are loaded - default and dev.

Here is the application.yml file
```
spring:
  profiles: default

rest:
  connectionTimeoutMillis: 20000
  readTimeoutMillis: 60000
  maxConnectionsPerHost: 25
  maxTotalConnections: 25
  httpProxyEnabled: false
  httpProxyHost: localhost
  httpProxyPort: 8888
---
spring:
  profiles: test

rest:
  connectionTimeoutMillis: 30000
```

Followed by an override file application-test.properties
```
rest.connectionTimeoutMillis: 40000
```

While running JAVA 7, the value for rest.connectionTimeoutMillis comes as 40000. When you switch to JAVA 8, the value comes out as 30000.
