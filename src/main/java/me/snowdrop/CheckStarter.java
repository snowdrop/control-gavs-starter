package me.snowdrop;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.coordinate.MavenCoordinate;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CheckStarter {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String STARTERS_FILE = "/starters-list.txt";
        String SEPARATOR_LINE = new String(new char[100]).replace("\0", "=");
        String NEW_LINE = System.getProperty("line.separator");

        Files.createDirectories(Paths.get("./generated"));
        FileWriter fw = new FileWriter("./generated/gavs.txt",true);

        List<String> lines = Files.readAllLines(Paths.get(CheckStarter.class.getResource(STARTERS_FILE).toURI()), StandardCharsets.UTF_8);

        StringBuilder bw = new StringBuilder();
        for (String line : lines) {
            if (!line.isEmpty()) {
                bw.append(SEPARATOR_LINE).append(NEW_LINE);
                bw.append("Spring Boot Starter : " + line).append(NEW_LINE);
                bw.append(SEPARATOR_LINE).append(NEW_LINE);

                for (MavenCoordinate gav : collectGAVs(line)) {
                    bw.append(gav.getGroupId() + ':' + gav.getArtifactId() + ":" + gav.getVersion()).append(NEW_LINE);
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

}
