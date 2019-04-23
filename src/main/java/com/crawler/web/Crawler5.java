package com.crawler.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Crawler5 {
	public static void main(String[] args) throws Exception{
		URL url = new URL("https://finance.naver.com/");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "euc-kr"));
		String line; 
		int check_line = 0;
		while((line = reader.readLine()) != null) {
			if(line.contains("<a href=\"/marketindex/worldExchangeDetail.nhn?marketindexCd"))
				check_line =1;
			if(line.contains("<a href=\"/marketindex/?tabSel=worldExchange#tab_section\""))
				check_line =0;
			if(check_line ==1) {
				if(line.contains("<a href=\"/marketindex/worldExchangeDetail.nhn?marketindexCd=")) {
					String temp = line.split(">")[2].split("<")[0];
					temp = temp.trim();
					System.out.println(temp);
				}
				if(line.contains("<td>")&& !line.contains("em")) {
					String temp = line.split(">")[1].split("<")[0];
					System.out.println(temp);
				}
				if(line.contains("<td>")&& line.contains("em")) {
					String temp = line.split(">")[3].split("<")[0];
					System.out.println(temp);
					String temp2 = line.split(">")[5].split("<")[0];
					System.out.println(temp2);
					System.out.println();
				} 
			} 
		}
		reader.close();
	}
}

	