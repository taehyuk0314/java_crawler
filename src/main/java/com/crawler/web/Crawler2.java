package com.crawler.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class Crawler2 extends WebCrawler{
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL();
		return href.startsWith("http://wikibook.co.kr/");
	}
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		try {
			HtmlParseData data = (HtmlParseData) page.getParseData();
			Document doc = Jsoup.parse(data.getHtml());
			String title = doc.select("#main-title").text();
			String content = doc.select("div.tab-content").html();
			System.out.println(title + "-"+url);
			System.out.println(content);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
