package main;

import controller.StoryController;
import java.util.ArrayList;
import java.util.List;
import model.Classes.Info;
import model.Classes.Mam;
import model.Personnage;

public class PolyEmblem {
    
    public static void main(String [] args){
        
        System.out.println("PolyEmblem, the Game TaTaTa!!! (comme les mignon)");
        System.out.println("Soon on yours screens !!");     
        
        run();        
    }
    
    public static void run(){
        
        /* Initialisation */
        StoryController.generateEvents();
        //Controller.players = CharacterCreation.start();
        
        /* Run the game */
        //StoryController.runTheGame(Controller.players));
        
        //To remove : 
        List<Personnage> testList = new ArrayList<Personnage>();
        testList.add(new Info("Sacha"));
        testList.add(new Mam("Pierre-Yves"));
        
        StoryController.runTheGame(testList);
    }
    
    
}
