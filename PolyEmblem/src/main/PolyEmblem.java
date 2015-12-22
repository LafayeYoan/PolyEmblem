package main;

import controller.StoryController;
import model.Classes.Info;

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
        //Controller.runTheGame(Controller.players.get(0));
        
        StoryController.runTheGame(new Info("Sacha"));
    }
    
    
}
