package edu.bsu.cs.Execeptions;

public class noArticleException extends Exception {
    public noArticleException(){
        super("No Wikipedia article could be found!");
    }

}
