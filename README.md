# udatabank-crawler
the udatabank crawler demo project

##requires:

  jdk 1.8, maven 3.3.3 and up

##run:

  in udatabankcrawler folder:

    mvn clean install
    mvn jetty:run
  
  from browser:

    http://localhost:8080/start (you can see all crawling process from your console)
    http://localhost:8080/links (once the crawling is done. you can view the results)
    
##code to read:

  UdatabankCrawler.java  -- add/edit the keywords. so you can get to different hexun pages
  CrawlerDemoController.java -- entry point for the demo. the seed is hardcoded here.
