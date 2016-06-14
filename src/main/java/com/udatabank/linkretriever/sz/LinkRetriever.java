package com.udatabank.linkretriever.sz;


import com.google.gson.Gson;

/**
 * Created by miazhang on 6/7/16.
 */
public class LinkRetriever {

    public static String[][] getAnnouncements() throws Exception {

        String json = JsonRetriever.getJson();

        Gson gson = new Gson();
//        final List<CompanyAnnouncement> announcements = gson.fromJson(json, new TypeToken<List<CompanyAnnouncement>>(){}.getType());
        final String[][] announcements = gson.fromJson(json, String[][].class);

        return announcements;
    }

    public static void main(String[] args) {

        try {

            String[][] announcements = LinkRetriever.getAnnouncements();

             for (int row = 0; row < announcements.length; row++) {
                for (int col = 0; col < announcements[row].length; col++) {
                    System.out.println(announcements[row][col]);
                }
            }

//            for(CompanyAnnouncement announcement : announcements) {
//
//                System.out.println(announcement.getTitle());
//                System.out.println(announcement.getUrl());
//            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
