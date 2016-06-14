package com.udatabank.linkretriever.sh;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by miazhang on 6/7/16.
 */
public class JsonRetriever {

    private static final String SH_JSON_ENDPOINT = "http://query.sse.com.cn/infodisplay/queryLatestBulletinNew.do?isPagination=false&reportType=All";
    private static final String SH_HEADER = "Referer";
    private static final String SH_HEADER_CONTENT = "http://2016.sse.com.cn/disclosure/listedinfo/announcement/";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static String getJson() throws Exception {

        final DateTime today = new DateTime();
        final String todayString = today.toLocalDate().toString(DATE_FORMAT);
        final DateTime yesterday = today.minusDays(1);
        final String yesterdayString = yesterday.toLocalDate().toString(DATE_FORMAT);
        final String dateParameter = "&beginDate=" + yesterdayString + "&endDate=" + todayString;


        final URL url = new URL(SH_JSON_ENDPOINT + dateParameter);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty(SH_HEADER, SH_HEADER_CONTENT);

        final Scanner scanner = new Scanner(connection.getInputStream(), "UTF-8");

        final StringBuilder builder = new StringBuilder();

        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());
        }

        scanner.close();

        String jsonString = builder.toString();

        return jsonString;
    }
}
