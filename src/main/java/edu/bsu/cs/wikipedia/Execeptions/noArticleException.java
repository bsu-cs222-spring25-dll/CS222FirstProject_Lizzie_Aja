package edu.bsu.cs.wikipedia.Execeptions;

public class noArticleException extends Exception {
    public noArticleException(){
        super("No Wikipedia article could be found!");
    }

}
