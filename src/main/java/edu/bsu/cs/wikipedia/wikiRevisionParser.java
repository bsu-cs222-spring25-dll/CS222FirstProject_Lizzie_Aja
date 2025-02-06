package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class wikiRevisionParser {
    public String parse(InputStream testDataStream) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        return result.get(0).toString();
    }
}
