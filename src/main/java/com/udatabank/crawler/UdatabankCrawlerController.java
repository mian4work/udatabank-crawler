package com.udatabank.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.stereotype.Component;

/**
 * Created by miazhang on 4/21/16.
 */
@Component
public class UdatabankCrawlerController {

    public void start() throws Exception {

        CrawlConfig config = new CrawlConfig();

        config.setPolitenessDelay(1000);
        config.setMaxPagesToFetch(1000);
        config.setIncludeHttpsPages(false);
        config.setResumableCrawling(false);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed("http://http://www.udatabank.com/");

        controller.start(UdatabankCrawler.class, 5);
    }
}
