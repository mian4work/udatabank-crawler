package com.udatabank.crawler;

import com.udatabank.database.MemoryDatabase;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by miazhang on 4/21/16.
 */
public class UdatabankCrawler extends WebCrawler {

    private static final String fileName = "." + File.separator + "src" + File.separator
                + "main" + File.separator + "webapp" + File.separator + "WEB-INF" + File.separator
                + "views" + File.separator + "links.jsp";

    private BufferedWriter writer = null;

    public UdatabankCrawler() {

        super();

        try {

            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public boolean shouldVisit(Page page, WebURL webURL) {

        String href = webURL.getURL().toLowerCase();

//        return href.contains("udatabank");
        return true;
    }

    @Override
    public void visit(Page page) {

        final String url = page.getWebURL().getURL();

        try {
            writer.write("<tr><a href='" + url + "'>" + url + "</a>" + "</tr><br/>");
        }
        catch (Exception ex) {

            ex.printStackTrace();
        }

        System.out.println(url);
    }

    @Override
    public void onBeforeExit() {

        try {
            writer.close();
        }
        catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}
