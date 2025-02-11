package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;

public class wikiMenu {
    wikiWebsiteConnection websiteConnection = new wikiWebsiteConnection();
    wikiRevisionParser revisionParser;
    wikiFormatRevisions formatRevisions = new wikiFormatRevisions();
    wikiUser user = new wikiUser();

    //inspired by code written by Christopher Davis and Alexis Evans
    public void runMenu() throws IOException {
        String wikiName = user.takeWikiUserInput();
        if (wikiName == null || wikiName.isEmpty()){
            System.err.println("No article name has been provided");
            System.exit(1);
        }
        JSONArray revisions = websiteConnection.fetchWikiRevisions(wikiName);
        if (revisions == null || revisions.isEmpty()){
            System.err.println("No revisions can be found");
            System.exit(1);
        }
        formatRevisions.formatRevisions(revisions);

    }

}
