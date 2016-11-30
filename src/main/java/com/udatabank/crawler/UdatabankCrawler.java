package com.udatabank.crawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by miazhang on 4/21/16.
 */
public class UdatabankCrawler extends WebCrawler {

    private static final String path = "." + File.separator + "src" + File.separator
                + "main" + File.separator + "webapp" + File.separator + "WEB-INF" + File.separator
                + "views" + File.separator;
    private static final String tempFile = path+ "links.temp";
    private static final String links = path+ "links.jsp";
    private BufferedWriter writer = null;
    private List<String> keyWords = Arrays.asList("news",
                                            "stock",
                                            "opinion",
                                            "funds",
                                            "money",
                                            "trust"
                                    );

    public UdatabankCrawler() {

        super();

        try {

            FileCopyUtils.copy(new File(tempFile), new File(links));
            writer = new BufferedWriter(new FileWriter(links, true));
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public boolean shouldVisit(Page page, WebURL webURL) {

        String href = webURL.getURL();
        return href.contains("hexun");
    }

    @Override
    public void visit(Page page) {

        final String url = page.getWebURL().getURL();
        final String anchor = page.getWebURL().getAnchor();
        final String subDomain = page.getWebURL().getSubDomain();
        String aLink = "";

        if (anchor != null && keyWords.contains(subDomain)) {

            try {

                aLink = "<tr><a href='" + url + "'>" + anchor + "</a>" + "</tr><br/>";
                writer.write(aLink);
                System.out.println(aLink);
            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onBeforeExit() {

        try {
            writer.write("</table></body></html>");
            writer.close();
            System.out.println("Crawling is done!");
        }
        catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}
