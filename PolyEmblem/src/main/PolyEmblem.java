package main;

import controller.StoryController;
import java.util.ArrayList;
import java.util.List;
import model.Classes.Info;
import model.Classes.Mam;
import model.Classes.Meca;
import model.Personnage;

public class PolyEmblem {
    
    public static void main(String [] args){
        
        System.out.println("\nPolyEmblem, created by "); 
        System.out.println("Sacha Lhopital");
        System.out.println("Yoan Lafaye De Micheaux");
        System.out.println("Loïck Paccaud");
        
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
        testList.add(new Meca("Pierre-Yves"));
        
        StoryController.runTheGame(testList);
    }
    
    
}
