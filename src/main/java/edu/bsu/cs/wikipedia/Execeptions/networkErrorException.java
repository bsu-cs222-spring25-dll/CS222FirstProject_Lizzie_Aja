package edu.bsu.cs.wikipedia.Execeptions;

public class networkErrorException extends Exception{
    public networkErrorException(){
        super("There seems to be a network error!");
    }
}
