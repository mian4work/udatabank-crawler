package com.udatabank.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miazhang on 4/21/16.
 */
public class MemoryDatabase {

    private final static List<String> links = new ArrayList<String>();

    public static List<String> getLinks() {

        return links;
    }

    public static void saveLink(String link) {

        links.add(link);
    }
}
