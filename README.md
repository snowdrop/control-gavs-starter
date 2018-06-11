# Instructions to check the starters

- Before to run the `mvn exec:java` command, verify the content of the file `src/main/resources/starters-list.txt` to verify if it contains the Spring Boot startwrs to be scanned

- Next, run this command `mvn exec:java` and check the file generated locally under `./generated/gavs.txt`

- You can now read the content of file, check if contains non supported frameworks such as: EclipseLink, ElasticSearch, MongoDB