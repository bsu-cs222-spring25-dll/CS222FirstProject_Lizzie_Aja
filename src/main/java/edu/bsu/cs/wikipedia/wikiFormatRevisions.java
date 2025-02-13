package edu.bsu.cs.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class wikiFormatRevisions {
    //inspired by Dominick Smith and Christopher Vojkufka (helped me use the replaceAll function)
    public void formatRevisions(JSONArray revisions){
        int count = 1;
        int maxRevisions = Math.min(revisions.size(), 21);
        for (int i = revisions.size() - 1; i >= revisions.size() - maxRevisions; i--) {
            String time = JsonPath.read(revisions.get(i), "$..timestamp").toString().replaceAll("[\\[\\]\"]", " ");
            String user = JsonPath.read(revisions.get(i), "$..user").toString().replaceAll("[\\[\\]\"]", " ");
            System.out.print(count + " " + time + " " + user + "\n");
            count++;
        }
    }
}
