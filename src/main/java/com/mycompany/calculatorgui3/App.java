package com.mycompany.calculatorgui3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import polsl.ld308770.controllers.CalculatorController;
//import polsl.ld308770.model.Multiplication;
//import polsl.ld308770.model.Substraction;
//import polsl.ld308770.model.Addition;
//import polsl.ld308770.model.Division;
import polsl.ld308770.model.Functions;

import polsl.ld308770.model.Memory;

public class App extends Application {

    private static Scene scene;
    private static Functions function;
    
    
    
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/com/mycompany/calculatorgui3/Calculator"), 640, 480);
     
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory( p -> { return new CalculatorController();} );
        
        return fxmlLoader.load();
    }

    
    //main
    public static void main(String[] args) {
        
        launch();
    }

}