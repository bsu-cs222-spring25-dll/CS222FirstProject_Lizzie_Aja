package edu.bsu.cs.wikipedia;

public class Revision {
    //inspired by Nolan Meyer and Dakota Coughlin
    protected String name;
    protected String timeStamp;

    public Revision(String name, String timeStamp){
        this.name = name;
        this.timeStamp = timeStamp;
    }
}
