package edu.bsu.cs.wikipedia;

import java.util.List;

public class wikiFormatRevisions {
    //inspired by Nolan Meyer and Dakota Coughlin
    public String printRevisionList(List<Revision> revisionList){

        int lineNumber = 1;

        StringBuilder output = new StringBuilder();

        for(Revision revision:revisionList){
            output.append(String.format("%d  %s",lineNumber,formatOutput(revision)));
            lineNumber++;
        }

        return output.toString();
    }

    protected String formatOutput(Revision revision){
        return String.format("%s  %s\n",revision.timeStamp,revision.name);
    }


}
