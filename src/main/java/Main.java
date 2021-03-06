import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

public class Main {
  public static void main(String[] args) throws Exception {
    String crawlerStorageFolder = "./Results/";
    int CRAWLER_NUMBER = 7;
    int MAX_DEPTH = 7;
    int POLITENESS_DELAY = 200;

    CrawlConfig crawlConfig = new CrawlConfig();
    crawlConfig.setCrawlStorageFolder(crawlerStorageFolder);
    crawlConfig.setMaxDepthOfCrawling(MAX_DEPTH);
    crawlConfig.setPolitenessDelay(POLITENESS_DELAY);
    PageFetcher pageFetcher = new PageFetcher(crawlConfig);
    RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
    CrawlController crawlController = new CrawlController(crawlConfig, pageFetcher, robotstxtServer);

    String seedHost = "vnexpress";
    crawlController.addSeed("https://" + seedHost + ".net/");
    crawlerStorageFolder += seedHost + "/";
    crawlController.start(MyCrawler.class, CRAWLER_NUMBER);

  }
}
