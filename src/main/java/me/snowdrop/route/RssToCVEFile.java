package me.snowdrop.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RssToCVEFile extends RouteBuilder {

    private final String rssURL = "https://pivotal.io/security/rss?splitEntries=true&delay=1h";

    @Override
    public void configure() {
        from("rss:" + rssURL)
          .bean(FeedBean.class,"outputResult")
            .log(LoggingLevel.DEBUG,"File name : ${header.CamelfileName}")
          .to("file://generated/cve");
    }
}


