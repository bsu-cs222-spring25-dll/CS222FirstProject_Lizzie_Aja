package edu.bsu.cs.wikipedia;

import java.io.IOException
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

    private String getLatestRevisionOf(String articleTitle) throw IOException {
        String urlString = String.format("");
    }
}
