package edu.bsu.cs.wikipedia;

import java.util.ArrayList;
import java.util.Scanner;

public class wikiUser {

    String wikiUserInput;

    public String getWikiUser(){
        return wikiUserInput;
    }

    public void setWikiUser(String wikiUser){
        this.wikiUserInput = wikiUser;
    }

    public wikiUser(){
        this.wikiUserInput = wikiUserInput;
    }

    public void researchWikiArticle(){
        System.out.println("Enter a Wiki Article Name to get the most recent updates to the article.");
    }

    public String takeWikiUserInput() {
        researchWikiArticle();
        Scanner scan = new Scanner(System.in);
        wikiUserInput = scan.nextLine();
        return wikiUserInput;
    }

}
