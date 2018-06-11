package me.snowdrop;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.coordinate.MavenCoordinate;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CheckStarter {

    static List<String> excludes;
    static List<String> gavs;
    static List<String> keywords;

    public static void main(String[] args) throws IOException, URISyntaxException {
        String STARTERS_FILE = "/starters-list.txt";
        String KEYWORDS_FILE = "/keywords-to-verify.txt";

        String SEPARATOR_LINE = new String(new char[100]).replace("\0", "=");
        String NEW_LINE = System.getProperty("line.separator");

        Files.createDirectories(Paths.get("./generated"));
        FileWriter fw = new FileWriter("./generated/gavs.txt",true);

        gavs = Files.readAllLines(Paths.get(CheckStarter.class.getResource(STARTERS_FILE).toURI()), StandardCharsets.UTF_8);
        excludes = Files.readAllLines(Paths.get(CheckStarter.class.getResource(KEYWORDS_FILE).toURI()), StandardCharsets.UTF_8);

        keywords = Arrays.asList(excludes.get(0).split(","));
        System.out.println("Keywords : " + keywords);

        StringBuilder bw = new StringBuilder();
        for (String gav : gavs) {
            if (!gav.isEmpty() && !gav.startsWith("#")) {
                bw.append(SEPARATOR_LINE).append(NEW_LINE);
                bw.append("Spring Artifact : " + gav).append(NEW_LINE);
                bw.append(SEPARATOR_LINE).append(NEW_LINE);

                for (MavenCoordinate coord : collectGAVs(gav)) {
                    String gavOfTheStarter = coord.getGroupId() + ':' + coord.getArtifactId() + ":" + coord.getVersion();

                    // Check if the GAV contains a non supported framework
                    if (includeKeyword(gavOfTheStarter)) {
                        bw.append("TO_BE_EXCLUDED : " + gavOfTheStarter).append(NEW_LINE);
                    } else {
                        bw.append(gavOfTheStarter).append(NEW_LINE);
                    }
                }
                bw.append(NEW_LINE);
            }
        }
        fw.write(bw.toString());
        fw.close();
    }

    static List<MavenCoordinate> collectGAVs(String gav) {
        return Maven.resolver()
                .resolve(gav)
                .withTransitivity()
                .asList(MavenCoordinate.class);
    }

    static boolean includeKeyword(String gav) {
        return keywords.stream().anyMatch(str -> gav.contains(str.trim()));
    }

}
