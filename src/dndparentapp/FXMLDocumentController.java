/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndparentapp;

import com.sun.glass.ui.Screen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author rewil
 */
public class FXMLDocumentController implements Initializable {
    
    public void openScene1() {
        applicationStage.setScene(diceScene);
        applicationStage.show();
        moveOnScreen();
    }
    
    public void openScene2() {
        applicationStage.setScene(healthScene);
        applicationStage.show();
        moveOnScreen();
    }
    
    public void openScene3() {
        applicationStage.setScene(toolScene);
        applicationStage.show();
        moveOnScreen();
    }
    
    public void openScene4() {
        applicationStage.setScene(initiativeScene);
        applicationStage.show();
        moveOnScreen();
    }
    
    public void openScene5() {
        applicationStage.setScene(sorcererScene);
        applicationStage.show();
        moveOnScreen();
    }
    
    public void openScene6() {
        applicationStage.setScene(spellbookScene);
        applicationStage.show();
        moveOnScreen();
    }
    
    private void moveOnScreen() {
        Screen screen = Screen.getMainScreen();
        double maxX = screen.getWidth();
        double maxY = screen.getHeight();
        
        if((applicationStage.getX() + applicationStage.getWidth()) > maxX) {
            applicationStage.setX(maxX - applicationStage.getWidth());
        }
        if((applicationStage.getY() + applicationStage.getHeight()) > maxY) {
            applicationStage.setY(maxY - applicationStage.getHeight());
        }
    }
    
    public static final Stage applicationStage = new Stage();
    
    Scene diceScene = null;
    Scene healthScene = null;
    Scene toolScene = null;
    Scene initiativeScene = null;
    Scene sorcererScene = null;
    Scene spellbookScene = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //<editor-fold>
        try {
            ClassLoader diceLoader = FXMLDocumentController.class.getClassLoader();
            
            // Load Dice App
            Class tempApp = diceLoader.loadClass("diceroller.DiceRoller");
            diceroller.DiceRoller diceMain = (diceroller.DiceRoller) tempApp.newInstance();
            diceMain.start(applicationStage);
            diceScene = diceMain.getScene();
            System.out.println("Dice " + diceMain.getScene());
            
            // Load Health App
            tempApp = diceLoader.loadClass("dndhealthtracker.DnDHealthTracker");
            dndhealthtracker.DnDHealthTracker healthMain = (dndhealthtracker.DnDHealthTracker) tempApp.newInstance();
            healthMain.start(applicationStage);
            healthScene = healthMain.getScene();
            System.out.println("Health " + healthMain.getScene());
            
            // Load Tool App
            tempApp = diceLoader.loadClass("dndtool.DnDTool");
            dndtool.DnDTool toolMain = (dndtool.DnDTool) tempApp.newInstance();
            toolMain.start(applicationStage);
            toolScene = toolMain.getScene();
            System.out.println("Tool " + toolMain.getScene());
            
            // Load Iniative App
            tempApp = diceLoader.loadClass("initiativeholder.InitiativeHolder");
            initiativeholder.InitiativeHolder initiativeMain = (initiativeholder.InitiativeHolder) tempApp.newInstance();
            initiativeMain.start(applicationStage);
            initiativeScene = initiativeMain.getScene();
            System.out.println("Init " + initiativeMain.getScene());
            
            // Load Sorcerer App
            tempApp = diceLoader.loadClass("sorcererhelper.SorcererHelper");
            sorcererhelper.SorcererHelper sorcererMain = (sorcererhelper.SorcererHelper) tempApp.newInstance();
            sorcererMain.start(applicationStage);
            sorcererScene = sorcererMain.getScene();
            System.out.println("Sorcerer " + sorcererMain.getScene());
            
            // Load Spellbook App
            tempApp = diceLoader.loadClass("spellbook.Spellbook");
            spellbook.Spellbook spellbookMain = (spellbook.Spellbook) tempApp.newInstance();
            spellbookMain.start(applicationStage);
            spellbookScene = spellbookMain.getScene();
            System.out.println("spellboook " + spellbookMain.getScene());
            
            // Load Scene 1
            applicationStage.setTitle("D&D Application Child Window");
            openScene1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());
        }
        //</editor-fold>
    }    
    
}
