package com.udatabank.linkretriever;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.udatabank.linkretriever.json.JSONArray;

import com.udatabank.linkretriever.json.JSONObject;

import com.google.gson.Gson;

/**
 * Created by miazhang on 6/7/16.
 */
public class LinkRetrieversh {

//    public static Gson getAnnouncements() throws Exception {
	@SuppressWarnings("null")
	public static String[][] getAnnouncements() throws Exception {
        String json = JsonRetrieversh.getJson();
        saveFiles(json.toString());
 //       System.out.print(json.toString());
        Gson gson = new Gson();
        //TODO: you will have to create mapping objects. The format is in the announcements.json. Than map it like this:
        //TODO: MappingClass result = gson.fromJson(MappingClass.class);
        JSONObject resp = new JSONObject(json);
//
		JSONObject	obj = (JSONObject) resp.opt("pageHelp");
		JSONArray	jarray = (JSONArray) obj.opt("data");
		String[][] announcements = null;
		if(jarray!=null&&jarray.length()!=0){
			int lengthItem = jarray.length();
			announcements = new String[lengthItem][3];
			for (int j = 0; j < lengthItem; j++){
				JSONObject objItem = jarray.getJSONObject(j);
				announcements[j][0]=objItem.optString("security_Code");
				announcements[j][1]=objItem.optString("URL");
				announcements[j][2]=objItem.optString("title");
			}
		}
		
 //       return gson;
        return announcements;
    }

    public static void main(String[] args) {

        try {

 //           Gson announcements = LinkRetrieversh.getAnnouncements();
        	String[][] announcements = LinkRetrieversh.getAnnouncements();
            System.out.print("done!"+"\r\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
public static void saveFiles(String announcements){
		
		OutputStreamWriter bw = null;
//		BufferedReader br = null;
		File writefile = null;
		BufferedReader  br = null;
		try {
			
			writefile = new File("d:\\annoucement.txt");
				if(writefile.exists()==false){
				writefile.createNewFile();
				writefile = new File("d:\\annoucement.txt");
				}
			
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(writefile), "UTF-8"));   
			bw=new OutputStreamWriter(new FileOutputStream(writefile,false) ,"UTF-8");
			
	                	bw.write(announcements);			
	    				bw.write("\r\n");
	
	         
	         
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (bw != null){
				try {
					bw.flush();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
