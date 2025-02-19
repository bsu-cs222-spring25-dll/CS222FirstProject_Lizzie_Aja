package edu.bsu.cs.wikipedia;

import edu.bsu.cs.Execeptions.networkErrorException;
import edu.bsu.cs.Execeptions.noArticleException;
import edu.bsu.cs.Execeptions.openInputStreamException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class wikiGUI extends Application {
    //inspired by Nolan Meyer and Dakota Coughlin
    //also inspired by Christopher Davis and Alexis Evans
    wikiFormatRevisions formatRevisions = new wikiFormatRevisions();
    wikiConnection wikiConnection = new wikiConnection();


    private VBox parent;
    private VBox buttonPlacement;
    private HBox backButtonContainer;
    private Button searchButton;
    private TextField articleText;
    private Label articleLabel;

    @Override
    public void start(Stage primaryStage) throws Exception{
        parent = new VBox();
        createTitle(parent, 80);
        createArticleLabel(parent, primaryStage);
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

    private void createArticleLabel(VBox parent, Stage primaryStage) throws FileNotFoundException {
        articleLabel = new Label("Enter the title of the Wikipedia Article");
        HBox articleTitleInput = new HBox(articleLabel);
        articleText = new TextField();
        articleTitleInput.getChildren().add(articleText);
        articleTitleInput.setAlignment(Pos.CENTER);
        articleTitleInput.setPadding(new Insets(0,0,15,0));
        parent.getChildren().add(articleTitleInput);
        primaryStage.setTitle("Wiki Revision Search");
        buttonPlacement = new VBox();
        searchButton = createSearchButton(primaryStage, articleText);
        buttonPlacement.getChildren().add(searchButton);
        parent.getChildren().add(buttonPlacement);

    }

    private Button createSearchButton(Stage primaryStage, TextField articleText) {
        searchButton = new Button("Article Revisions");
        searchButton.setOnAction(e ->{
            try {
                switchScene(primaryStage, articleText.getText());
            } catch (FileNotFoundException f){
                throw new RuntimeException(f);
            }
        });
        return searchButton;
    }

    private void switchScene(Stage primaryStage, String searchInput) throws FileNotFoundException {
        String output = "";
        parent = new VBox();
        parent.setAlignment(Pos.CENTER);
        Alert errorsPopUP = popUpErrors();
        if(searchInput.isEmpty()){
            errorsPopUP.setContentText("Nothing was typed into the search bar");
            errorsPopUP.showAndWait();
        } else {
            try {
                InputStream wikiResponse = wikiConnection.search(searchInput);
                revisionInputStream inputStream = new revisionInputStream(wikiResponse);
                wikiRevisionParser parser = new wikiRevisionParser(inputStream);
                output = formatRevisions.printRevisionList(parser.parse());
                Label redirectLabel = new Label(parser.extractRedirect(inputStream.openInputStream()));
                redirectLabel.setPadding(new Insets(0,0,10,0));
                parent.getChildren().add(redirectLabel);
            } catch (noArticleException | networkErrorException | openInputStreamException e){
                errorsPopUP.setContentText(e.getMessage());
                errorsPopUP.showAndWait();
            }
        }
        createOutPutLabel(parent,output);
        Region spacer = createSpacerRegion();
        Button buttonContainer = createButtonContainer();
        if(!output.isEmpty()){
            primaryStage.setScene(new Scene(parent));
        }
    }

    private Region createSpacerRegion(){
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        parent.getChildren().add(spacer);
        return spacer;
    }

    private Button createButtonContainer(){
        backButtonContainer = new HBox();
        Button backButton = new Button(" <- Back ");
        backButton.setOnAction(e->{
            backButtonContainer.getChildren().add(backButton);
            backButtonContainer.setAlignment(Pos.BOTTOM_LEFT);
            parent.getChildren().add(backButtonContainer);
        });
        return backButton;
    }

    private void createOutPutLabel(VBox parent, String output) {
        Label outputLabel = new Label(output);
        outputLabel.setMaxWidth(600);
        outputLabel.setMinWidth(400);
        outputLabel.setWrapText(true);
        outputLabel.setPadding(new Insets(0, 0, 10, 20));
        outputLabel.setAlignment(Pos.CENTER_LEFT);
        ScrollPane scrollPane = new ScrollPane(outputLabel);
        scrollPane.setFitToWidth(true);
        scrollPane.setMaxHeight(380);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        parent.getChildren().add(scrollPane);
        parent.getChildren().add(outputLabel);
    }

    private Alert popUpErrors(){
        Alert errorsPopUp = new Alert(Alert.AlertType.ERROR);
        errorsPopUp.setTitle("ERROR MESSAGE");
        errorsPopUp.getDialogPane().setStyle("-fx-background-color: gray;");
        errorsPopUp.getDialogPane().setStyle("-fx-font-size: 20px");
        return errorsPopUp;
    }

    private void createTitle(VBox parent, int padding) throws FileNotFoundException {
        HBox titleContainer = new HBox();
        Label labelTitle = new Label("Wikipedia Article Revisions");
        titleContainer.getChildren().add(labelTitle);
        titleContainer.setAlignment(Pos.CENTER);
        titleContainer.setPadding(new Insets(0,0,padding,0));
        parent.getChildren().add(titleContainer);
    }

}

