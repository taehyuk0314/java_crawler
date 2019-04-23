package com.crawler.web;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	public static void main(String[] args) throws Exception{
		String url ="http://wikibook.co.kr/";
		Document doc = Jsoup.connect(url).get();
		Elements elements =doc.select("li.book-in-front a");
		for(Element element: elements) {
			String title = element.ownText().trim();
			String nextUrl = element.attr("href");
			Document nextDoc = Jsoup.connect(nextUrl).get();
			String content = nextDoc.select("div.tab-content").html();
			Files.write(Paths.get(title + ".html"), content.getBytes("UTF-8"));
		}
	}
}
