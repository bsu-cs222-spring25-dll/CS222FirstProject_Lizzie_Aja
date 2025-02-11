package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class wikiRevisionParser {
    public String parseTimeStamp(InputStream testDataStream) throws IOException {
        JSONArray wikiTimeStamp = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        return wikiTimeStamp.getFirst().toString();
    }
    public String parseWikiUser(InputStream testDataStream) throws IOException {
        JSONArray wikiUserName = (JSONArray) JsonPath.read(testDataStream, "$..user");
        return wikiUserName.getFirst().toString();
    }

    //inspired by Dominick Smith and Christopher Vojkufka
    public static JSONArray extractRevisions(String jsonData){
        if (jsonData.contains("redirects")){
            String redirectedWikiArticle = JsonPath.read(jsonData, "$.query.redirects[0].to").toString();
            System.out.println("Redirected to " + redirectedWikiArticle);
        }
        return JsonPath.read(jsonData, "$..revisions[*]");
    }
}
