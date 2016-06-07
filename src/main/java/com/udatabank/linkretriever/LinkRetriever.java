package com.udatabank.linkretriever;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by miazhang on 6/7/16.
 */
public class LinkRetriever {

    public static List<CompanyAnnouncement> getAnnouncements() throws Exception {

        String json = JsonRetriever.getJson();

        Gson gson = new Gson();
        final List<CompanyAnnouncement> announcements = gson.fromJson(json, new TypeToken<List<CompanyAnnouncement>>(){}.getType());

        return announcements;
    }
}
