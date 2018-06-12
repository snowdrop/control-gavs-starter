package me.snowdrop.route;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import org.apache.camel.Body;
import org.apache.camel.Headers;

import java.util.Map;

public class FeedBean {

    static public String newLine() {
        return System.getProperty("line.separator");
    }

    static public String lineSeparator() {
        return new String(new char[50]).replace("\0", "=");
    }

    public boolean titleContainsSpringProject(@Body SyndFeed feed) {
        SyndEntry firstEntry = (SyndEntry) feed.getEntries().get(0);
        return firstEntry.getTitle().contains("spring-");
    }

    public String outputResult(@Body SyndFeed feed, @Headers Map<Object, Object> headers) {
        StringBuffer sbf = new StringBuffer();
        SyndEntry entry = (SyndEntry) feed.getEntries().get(0);
        sbf.append(lineSeparator()).append(newLine());
        sbf.append("CVE id : " + entry.getTitle()).append(newLine());
        sbf.append("Link : " + entry.getLink()).append(newLine());
        sbf.append("Date : " + entry.getPublishedDate()).append(newLine());
        sbf.append("Description : " + entry.getDescription()).append(newLine());
        sbf.append(lineSeparator()).append(newLine());

        headers.put("CamelfileName",entry.getTitle());

        return sbf.toString();
    }
}
