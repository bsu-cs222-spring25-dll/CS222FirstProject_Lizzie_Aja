package edu.bsu.cs.wikipedia;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import static edu.bsu.cs.wikipedia.wikiRevisionParser.extractRevisions;

public class wikiWebsiteConnection {

    //inspired by Dominick Smith and Christopher Vojkufka
    public JSONArray fetchWikiRevisions(String wikiName) throws IOException{
        URLConnection connection = connectToWikipedia(wikiName);
        String jsonData = readJsonAsStringFrom(connection);
        return extractRevisions(jsonData);
    }

    public static String getEncodedURL(String wikiName){
        return "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
        URLEncoder.encode(wikiName, Charset.defaultCharset()) + "&rvprop=timestamp|user&rvlimit=21&redirects";
    }
    private static URLConnection connectToWikipedia(String wikiName) throws IOException {
        String encodedUrlString = getEncodedURL(wikiName);
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "CS222FirstProject/0.1 (elizabeth.collin2@bsu.edu)");
        connection.connect();
        return connection;
    }
    public static String readJsonAsStringFrom(URLConnection urlConnection) throws IOException{
        return new String(urlConnection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }


    private static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }

}