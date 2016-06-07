package com.udatabank.linkretriever;

import java.net.URL;
import java.util.Scanner;

/**
 * Created by miazhang on 6/7/16.
 */
public class JsonRetriever {

    private static final String SZ_JSON_ENDPOINT = "http://disclosure.szse.cn/disclosure/fulltext/plate/szlatest_24h.js?ver=201606070925";

    public static String getJson() throws Exception {

        final URL url = new URL(SZ_JSON_ENDPOINT);
        final Scanner scanner = new Scanner(url.openStream());

        final StringBuilder builder = new StringBuilder();

        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());
        }

        scanner.close();

        String jsonString = builder.toString();

        //remove the javascript code
        if(jsonString.startsWith("var szzbAffiches=")) {

            jsonString = jsonString.replaceFirst("var szzbAffiches=", "");
        }

        if(jsonString.endsWith(";")) {

            jsonString = jsonString.substring(0, jsonString.length() - 1);
        }

        return jsonString;
    }
}
