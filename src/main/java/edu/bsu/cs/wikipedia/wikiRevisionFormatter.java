package edu.bsu.cs.wikipedia;

import net.minidev.json.JSONArray;

public class wikiRevisionFormatter {
    public void printList(){

    }
    public static String wikiFormat(JSONArray timeStamps, JSONArray wikiUsers){
        String formationString = "";
        for (int i = 0; i < timeStamps.size(); i++){
            String timeStamp = (String) timeStamps.get(i);
            String user = (String) wikiUsers.get(i);
            formationString = formationString + " " + (i+1) + "   " + timeStamp + " " + user + "/n";
        }
        return formationString;
    }
}
