package main;

import controller.CharacterCreation;
import controller.StoryController;
import java.util.List;
import model.Personnage;

/**
 * PolyEmblem the game. 
 * 2015/2016
 * @author Lafaye, Lhopital, Paccaud
 */
public class PolyEmblem {
    
    /**
     * PolyEmblem the game
     * @param args
     */
    public static void main(String [] args){
        
        System.out.println("\nPolyEmblem, created by "); 
        System.out.println("Yoan Lafaye De Micheaux");
        System.out.println("Sacha Lhopital");
        System.out.println("Loïck Paccaud");
        
        run();        
    }
    
    /**
     * run the game, and all events of the story
     */
    public static void run(){
        
        /* Initialisation */
        StoryController.generateEvents();
        List<Personnage> players = CharacterCreation.start();
        
        /* Run the game */
        StoryController.runTheGame(players);
    }
    
  
}
