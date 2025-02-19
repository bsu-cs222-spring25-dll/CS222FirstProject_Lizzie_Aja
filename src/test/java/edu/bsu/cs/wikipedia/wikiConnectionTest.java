package edu.bsu.cs.wikipedia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class wikiConnectionTest {
    @Test
    public void createUrlRequestTest(){
        wikiConnection wikiConnection = new wikiConnection();
        assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Frank%20Zappa&rvprop=timestamp|user&rvlimit=21&redirects",wikiConnection.createRequestUrl("Frank Zappa"));
    }
}
