package com.udatabank.linkretriever.sh;


import com.google.gson.Gson;

/**
 * Created by miazhang on 6/7/16.
 */
public class LinkRetriever {

    public static Gson getAnnouncements() throws Exception {

        String json = JsonRetriever.getJson();

        Gson gson = new Gson();
        //TODO: you will have to create mapping objects. The format is in the announcements.json. Than map it like this:
        //TODO: MappingClass result = gson.fromJson(MappingClass.class);

        return gson;
    }

    public static void main(String[] args) {

        try {

            Gson announcements = LinkRetriever.getAnnouncements();

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
