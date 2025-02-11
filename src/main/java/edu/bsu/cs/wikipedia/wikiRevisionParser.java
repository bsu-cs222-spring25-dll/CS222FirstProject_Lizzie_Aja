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
        JSONArray wikiUserName = (JSONArray) JsonPath.read(testDataStream, "$.. user");
        return wikiUserName.getFirst().toString();
    }
}
