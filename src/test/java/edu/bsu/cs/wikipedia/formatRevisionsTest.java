package edu.bsu.cs.wikipedia;
import edu.bsu.cs.Execeptions.noArticleException;
import edu.bsu.cs.Execeptions.openInputStreamException;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class formatRevisionsTest {
    //inspired by Nolan Meyer and Dakota Coughlin
    @Test
    public void formatOutputTest(){
        wikiFormatRevisions revisionFormatter = new wikiFormatRevisions ();
        Revision revisionTest = new Revision("Miklogfeather","2023-09-07T18:34:43Z");
        String formattedOutput = revisionFormatter.formatOutput(revisionTest);
        assertEquals("2023-09-07T18:34:43Z  Miklogfeather\n",formattedOutput);
    }

    @Test
    public void printRevisionListTest() throws noArticleException, openInputStreamException {
        InputStream sampleFile = Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.json");
        wikiRevisionParser parser = new wikiRevisionParser(new revisionInputStream(sampleFile));
        List<Revision> revisionList = parser.parse();
        wikiFormatRevisions  formatter = new wikiFormatRevisions ();
        assertEquals("""
                1  2023-09-07T18:34:43Z  Miklogfeather
                2  2023-09-07T17:21:48Z  ModernDayTrilobite
                3  2023-09-02T15:06:03Z  Freefry
                4  2023-09-02T15:05:04Z  Freefry
                """,formatter.printRevisionList(revisionList));
    }
}
