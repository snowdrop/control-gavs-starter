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
  TO_BE_EXCLUDED :org.springframework.boot:spring-boot-starter-data-mongodb:1.5.13.RELEASE
  TO_BE_EXCLUDED :org.springframework.boot:spring-boot-starter:1.5.13.RELEASE
  TO_BE_EXCLUDED :org.springframework.boot:spring-boot:1.5.13.RELEASE
  ```

