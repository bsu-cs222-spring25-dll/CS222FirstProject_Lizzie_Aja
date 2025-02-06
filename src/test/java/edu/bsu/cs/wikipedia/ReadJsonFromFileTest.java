package edu.bsu.cs.wikipedia;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReadJsonFromFileTest {

    @Test
    public void testAccessToJsonFile() throws IOException {
        String jsonData = readwikiTestFileAsString();
        Assertions.assertNotNull(jsonData);
    }

    @Test
    public void testCountRevisionsWithJsonPath() throws IOException {
        String jsonData = readwikiTestFileAsString();
        JSONArray wikiRevisions = getRevisionsFromJson(jsonData);
        Assertions.assertEquals(4, wikiRevisions.size());
    }

    private String readwikiTestFileAsString() throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("wikiTest.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        } catch (IOException e) {
            System.err.print("Input not Found");
        } catch (NullPointerException e){
            System.err.println("File Not Found");
        }
        return null;
    }

    private JSONArray getRevisionsFromJson(String jsonData) {
        return JsonPath.read(jsonData, "$..revisions[*]");
    }

}
