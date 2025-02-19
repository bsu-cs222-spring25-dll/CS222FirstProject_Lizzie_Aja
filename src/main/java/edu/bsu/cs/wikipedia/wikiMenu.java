package edu.bsu.cs.wikipedia;

import edu.bsu.cs.Execeptions.networkErrorException;
import edu.bsu.cs.Execeptions.noArticleException;
import edu.bsu.cs.Execeptions.openInputStreamException;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class wikiMenu {
    //inspired by Nolan Meyer and Dakota Coughlin
    //also inspired by Christopher Davis and Alexis Evans
    wikiFormatRevisions formatRevisions = new wikiFormatRevisions();
    private wikiRevisionParser parser;
    wikiConnection wikiConnection = new wikiConnection();
    Scanner scan = new Scanner(System.in);

    //inspired by code written by Christopher Davis and Alexis Evans
    public void runMenu(){
        System.out.print("Enter a title you would like revisions about:");
        String userInput = scan.nextLine();

        if(validateUserInput(userInput)) {

            try {
                List<Revision> revisionList = inputSearch(userInput);

                if (!revisionList.isEmpty()) {
                    inputSearchPrint(revisionList);
                }
            }catch(noArticleException | networkErrorException | openInputStreamException e){
                System.err.println(e.getMessage());
            }

        }else{
            System.err.println("Please enter an article!");
        }
    }

    private List<Revision> inputSearch(String userInput) throws noArticleException, networkErrorException, openInputStreamException {
        InputStream wikiResponse = wikiConnection.search(userInput);
        parser = new wikiRevisionParser(new revisionInputStream(wikiResponse));
        return parser.parse();
    }

    private void inputSearchPrint(List<Revision> revisionList){
        System.out.println(parser.extractRedirect(parser.inputStreamInstance.openInputStream()));
        System.out.println(formatRevisions.printRevisionList(revisionList));
    }

    protected boolean validateUserInput(String userInput){
        return !userInput.isEmpty();
    }
}
