package edu.bsu.cs.wikipedia;

import net.minidev.json.JSONArray;

public class wikiMenu {
    wikiWebsiteConnection websiteConnection = new wikiWebsiteConnection();
    wikiRevisionParser revisionParser;
    wikiRevisionFormatter revisionFormatter = new wikiRevisionFormatter();
    wikiUser user = new wikiUser();

    //inspired by code written by Christopher Davis and Alexis Evans
    public void runMenu(){
        String wikiName = user.takeWikiUserInput();
        if (wikiName == null || wikiName.isEmpty()){
            System.err.println("No article name has been provided");
            System.exit(1);
        }
        //JSONArray revisions = websiteConnection.


    }
}
