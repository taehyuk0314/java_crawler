package com.crawler.web;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Crawler3 {
	public static void main(String[] args) throws Exception{
		int numberOfCrawlers = 1;
		CrawlConfig config = new CrawlConfig();
		config.setMaxDepthOfCrawling(1);
		config.setCrawlStorageFolder("./data/crawl/root");
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
		controller.addSeed("http://takezoe.hatenablog.com/");
		controller.start(Crawler2.class, numberOfCrawlers);
		System.out.println("나온 값은 "+numberOfCrawlers);
		
	}
}
