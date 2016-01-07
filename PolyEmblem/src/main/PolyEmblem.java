package main;

import controller.StoryController;
import model.Classes.Info;

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
        StoryController.runTheGame(new Info("Sacha"));
    }
    
    
}
