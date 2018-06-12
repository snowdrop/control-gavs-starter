# Instructions to check the starters

The goal of this project is to resolve the transitive dependencies of a Maven coordinate (gav) using as input, a file containing a list of Maven coordinates to check `G:A:V`.
All the Coordinates resolved will be next saved into an output file `generated/gavs.txt` and if the coordinate matches one of the keywords, the prefix `MATCHING : ` will be added.
The list of the keywords is passed as an argument to the java application and is defined as a comma separated values list. 

Create first your `my-starters-list.txt` file containing the Maven coordinates of the Spring Boot starters or Boot projects to resolve using the following convention 

 ```
 groupId:artifactId:version
 groupId:artifactId:version
 ```  

Next, define your `my-keywords.txt` file with the keywords to be controlled

  ```
  key1,key2,key3,key4,....,keyN
  ```

**REMARK** : An example of the starters and keywords files are available under the `examples` directory.

You can now execute this maven command and pass as arguments the files

```bash
  mvn exec:java -Dexec.args="my-starters.txt my-keywords.txt"
```

If the maven goal succeeds, then you will see the following message within yoour terminal like the keywords processed

  ```
  [INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ check-starter ---
  Keywords : [eclipselink, elasticsearch, mongodb]
  [INFO] ------------------------------------------------------------------------
  [INFO] BUILD SUCCESS
  [INFO] ------------------------------------------------------------------------
  ```
  
You can control that this file `./generated/gavs.txt` has been generated locally
and that it includes GAVs.
  
  
  ```
  ====================================================================================================
  Spring Artifact : org.springframework.boot:spring-boot-starter-data-mongodb:1.5.13.RELEASE
  ====================================================================================================
  MATCHING [mongodb ] --> org.springframework.boot:spring-boot-starter-data-mongodb:1.5.13.RELEASE!org.springframework.boot:spring-boot-starter-data-mongodb:1.5.13.RELEASE
  org.springframework.boot:spring-boot-starter:1.5.13.RELEASE
  org.springframework.boot:spring-boot:1.5.13.RELEASE
  org.springframework.boot:spring-boot-autoconfigure:1.5.13.RELEASE
  org.springframework.boot:spring-boot-starter-logging:1.5.13.RELEASE
  ...
  ````

