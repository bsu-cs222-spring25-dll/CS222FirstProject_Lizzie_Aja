package edu.bsu.cs.wikipedia;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class wikiWebsiteConnectionTest {
    //inspired by Dominick Smith and Christopher Vojkufka
    @Test
    void testWikiReach() throws Exception{
        URL url = new URL("https://en.wikipedia.org/w/api.php");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        assertEquals(200,responseCode, "Wiki not reachable");
    }

    @Test
    void testFetchWikiRevisions() throws Exception{
        wikiWebsiteConnection websiteConnection = new wikiWebsiteConnection();
        JSONArray jsonData = websiteConnection.fetchWikiRevisions("Santa Claus");
        assertNotNull(jsonData, "Website should return JSON Data");
        assertFalse(jsonData.isEmpty(), "JSON should have revision data");
    }
}
