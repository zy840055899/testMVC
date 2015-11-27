package com.test.test.spider;


import java.util.Set;

/**
 * 2015-11-27 16:57:40
 * 网络爬虫案例
 */
public class MainCrawler {

    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++) {
            LinkQueue.addUnvisitedUrl(seeds[i]);
        }
    }

    public void crawling(String[] seeds) {
        LinkFilter filter = new LinkFilter() {
            public boolean accept(String url) {
                if (url.startsWith("http://www.baidu.com")) {
                    return true;
                }
                return false;
            }
        };

        initCrawlerWithSeeds(seeds);

        while (!LinkQueue.unVisitedUrlsEmpty()
                && LinkQueue.getVisitedUrlNum() <= 1000) {
            String visitUrl = (String) LinkQueue.unVisitedUrlDeQueue();
            if (visitUrl == null) {
                continue;
            }
            DownloadFile downLoader = new DownloadFile();
            downLoader.downLoadFile(visitUrl);
            LinkQueue.addVisitedUrl(visitUrl);

            Set<String> links =
                    HtmlParserTool.extracLinks(visitUrl, filter);
            for (String link : links) {
                LinkQueue.addUnvisitedUrl(link);
            }
        }
    }

    public static void main(String[] args) {
        MainCrawler crawler = new MainCrawler();
        crawler.crawling(new String[]{"http://www.baidu.com"});
    }
}
