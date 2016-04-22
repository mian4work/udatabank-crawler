package com.udatabank.crawler;

import com.udatabank.database.MemoryDatabase;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Created by miazhang on 4/21/16.
 */
public class UdatabankCrawler extends WebCrawler{

    @Override
    public boolean shouldVisit(Page page, WebURL webURL) {

        String href = webURL.getURL().toLowerCase();

        return href.contains("http://www.udatabank.com/");
    }

    @Override
    public void visit(Page page) {

        final String url = page.getWebURL().getURL();

        MemoryDatabase.saveLink(url);
    }
}
