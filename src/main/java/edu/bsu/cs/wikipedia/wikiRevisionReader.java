package edu.bsu.cs.wikipedia;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

public class wikiRevisionReader {
    public static void main(String[] args){
        wikiRevisionReader revisionReader = new wikiRevisionReader();
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        try {
            String timeStamp = revisionReader.getLatestRevisionOf(line);
            System.out.println(timeStamp);
        } catch (IOException ioException) {
            System.err.println("Network Connection Problems: " + ioException.getMessage());
        }
    }

    private String getLatestRevisionOf(String articleTitle) throws IOException {
        String urlString = String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp&rvlimit=1", articleTitle);
        String encodedURLString = URLEncoder.encode(urlString, Charset.defaultCharset());
        try {
            URL url = new URL(encodedURLString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "wikiRevisionReader/0.1 (https://www.youtube.com/@elizamax02; elizabeth.collins2@bsu.edu)");
            InputStream inputStream = connection.getInputStream();
            wikiRevisionParser parser = new wikiRevisionParser();
            String timeStamp = parser.parse(inputStream);
            return timeStamp;
        } catch (MalformedURLException malformedURLException) {
            throw new RuntimeException(malformedURLException);
        }
    }
}
