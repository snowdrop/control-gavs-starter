# Instructions to check the starters

- Before to run the `mvn exec:java` command, verify the content of the file `src/main/resources/starters-list.txt` to check if it contains the Spring Boot starters to be scanned
  for a specific version like also the non supported frameworks such as: EclipseLink, ElasticSearch, MongoDB within the file `src/main/resources/keywords-to-verify.txt`

- Next, run this command `mvn exec:java` 

  ```
  [INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ check-starter ---
  Keywords : [eclipselink, elasticsearch, mongodb]
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  ```
  
  and control that this file has been generated locally under the following folder `./generated/gavs.txt`
  and if it includes GAVs to be excluded
  
  e.g
  
  ```
  ====================================================================================================
  Spring Artifact : org.springframework.boot:spring-boot-starter-data-mongodb:1.5.13.RELEASE
  ====================================================================================================
  TO_BE_EXCLUDED : org.springframework.boot:spring-boot-starter-data-mongodb:1.5.13.RELEASE
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
  TO_BE_EXCLUDED : org.mongodb:mongodb-driver:3.4.3
  TO_BE_EXCLUDED : org.mongodb:mongodb-driver-core:3.4.3
  TO_BE_EXCLUDED : org.mongodb:bson:3.4.3
  TO_BE_EXCLUDED : org.springframework.data:spring-data-mongodb:1.10.12.RELEASE
  org.springframework:spring-tx:4.3.17.RELEASE
  org.springframework:spring-context:4.3.17.RELEASE
  org.springframework:spring-aop:4.3.17.RELEASE
  ...
  ```

