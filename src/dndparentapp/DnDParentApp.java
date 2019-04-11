/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndparentapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rewil
 */
public class DnDParentApp extends Application {
    
    private static Stage pStage = null;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        pStage = stage;
        stage.setScene(scene);
        stage.setTitle("D&D Parent Button Bar");
        stage.setAlwaysOnTop(true);
        stage.setOnHidden(event -> {
            FXMLDocumentController.applicationStage.close();
        });
        stage.show();
    }
    
    public static Stage getStage() {
        return pStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
