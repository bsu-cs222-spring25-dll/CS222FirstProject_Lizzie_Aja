package edu.bsu.cs.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.InputStream;

public class revisionParserTest {

    @Test
    public void testParse(){
        wikiRevisionParser parserTest = new wikiRevisionParser();
        InputStream textDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("wikiTest.json");
        String timeStamp = parserTest.parse(textDataStream);
        Assertions.assertEquals("2025-01-28T09:09:51Z", timeStamp);
    }


}