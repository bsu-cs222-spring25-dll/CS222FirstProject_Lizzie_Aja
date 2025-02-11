package edu.bsu.cs.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class revisionParserTest {

    @Test
    public void testTimeStampParse() throws IOException {
        wikiRevisionParser parserTest = new wikiRevisionParser();
        InputStream textDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("wikiTest.json");
        String timeStamp = parserTest.parseTimeStamp(textDataStream);
        Assertions.assertEquals("2025-01-28T09:09:51Z", timeStamp);
    }

    @Test
    public void testUserParse() throws IOException {
        wikiRevisionParser parserTest = new wikiRevisionParser();
        InputStream textDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("wikiTest.json");
        String user = parserTest.parseWikiUser(textDataStream);
        Assertions.assertEquals("Steel1943", user);
    }
}