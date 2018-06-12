# Instructions to check the starters

The goal of this project is to resolve the transitive dependencies of a Maven coordinate (gav) using as input, a file containing a list of Maven coordinates to check `G:A:V`.
All the Coordinates resolved will be next saved into an output file `generated/gavs.txt` and if the coordinate matches one of the keywords, the prefix `MATCHING : ` will be added.
The list of the keywoards is passed as parameter too and is defined as a comma separated values list. 


Before to run the `mvn exec:java` command, verify the content of the file `examples/starters-list.txt` to check if it contains the Spring Boot starters to be scanned
for a specific version like also the non supported frameworks such as: EclipseLink, ElasticSearch, MongoDB within the file `examples/keywords-to-verify.txt`

Next, run this command `mvn exec:java` 

  ```
  [INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ check-starter ---
  Keywords : [eclipselink, elasticsearch, mongodb]
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  ```
  
  and control that this file has been generated locally `./generated/gavs.txt`
  and that it includes GAVs not supported
  
  e.g
  
  ```
  ====================================================================================================
  Spring Artifact : org.springframework.boot:spring-boot-starter-data-mongodb:1.5.13.RELEASE
  ====================================================================================================
  NOT_SUPPORTED : org.springframework.boot:spring-boot-starter-data-mongodb:1.5.13.RELEASE
  org.springframework.boot:spring-boot-starter:1.5.13.RELEASE
  org.springframework.boot:spring-boot:1.5.13.RELEASE
  org.springframework.boot:spring-boot-autoconfigure:1.5.13.RELEASE
  org.springframework.boot:spring-boot-starter-logging:1.5.13.RELEASE
  ch.qos.logback:logback-classic:1.1.11
  ch.qos.logback:logback-core:1.1.11
  org.slf4j:jul-to-slf4j:1.7.25
  org.slf4j:log4j-over-slf4j:1.7.25
  org.springframework:spring-core:4.3.17.RELEASE
  org.yaml:snakeyaml:1.17
  NOT_SUPPORTED : org.mongodb:mongodb-driver:3.4.3
  NOT_SUPPORTED : org.mongodb:mongodb-driver-core:3.4.3
  NOT_SUPPORTED : org.mongodb:bson:3.4.3
  NOT_SUPPORTED : org.springframework.data:spring-data-mongodb:1.10.12.RELEASE
  org.springframework:spring-tx:4.3.17.RELEASE
  org.springframework:spring-context:4.3.17.RELEASE
  org.springframework:spring-aop:4.3.17.RELEASE
  ...
  ```
  
You can also pass as parameters files containing the list of the GAVS to resolve the dependencies and the keywords to be matched

  ```bash
  mvn exec:java -Dexec.args="my-starters.txt my-keywords.txt"
  ```

