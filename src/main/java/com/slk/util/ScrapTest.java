package com.slk.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.host.html.HTMLElement;

public class ScrapTest {

	public static void main(String[] args) throws Exception {

		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		String searchUrl = "https://dhan.co/stocks/reliance-industries-ltd-technical-analysis/";
		HtmlPage page = client.getPage(searchUrl);

//		List<HTMLElement> list = page
//				.getByXPath("/html/body/div[4]/div/div/div[1]/div[4]/div[3]/div[1]/div[2]/div/table/tbody/tr[1]/td[2]");

		List<HtmlElement> list = page.getByXPath("/html/body/div[4]/div/div/div[1]/div[4]/div[3]/div[1]/div[2]/div/table/tbody/tr[1]");
		System.out.println(list.size());

//		HTMLElement el = list.get(0);
		System.out.println(list.get(0).getChildElementCount());
		list.get(0).getChildren().forEach(x->System.out.println(x.asNormalizedText()));
		
		List<HtmlElement> list2 = page.getByXPath("/html/body/div[4]/div/div/div[1]/div[4]/div[3]/div[1]/div[2]/div/table/tbody/tr[4]");
		list2.get(0).getChildren().forEach(x->System.out.println(x.asNormalizedText()));
		
//		System.out.println(list.get(0).getInnerText());

	}
}
