package me.snowdrop.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileWriter;

@Component
public class RssToCVE extends RouteBuilder {

    String rssURL = "https://pivotal.io/security/rss?splitEntries=true";

    FilterBean filterBean;

    @Override
    public void configure() throws Exception {
        from("rss:" + rssURL)
          .filter()
            .method(FilterBean.class,"titleContainsSpringProject")
          .bean(FilterBean.class,"outputResult")
          .to("file://generated/cve");
    }
}


