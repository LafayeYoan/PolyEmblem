package main;

import controller.StoryController;
import java.util.ArrayList;
import java.util.List;
import model.Classes.Gbm;
import model.Classes.Info;
import model.Classes.Mam;
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
        System.out.println("Sacha Lhopital");
        System.out.println("Yoan Lafaye De Micheaux");
        System.out.println("Loïck Paccaud");
        
        run();        
    }
    
    /**
     * run the game, and all events of the story
     */
    public static void run(){
        
        /* Initialisation */
        StoryController.generateEvents();
        //List<Personnage> players = CharacterCreation.start();
        
        /* Run the game */
        //StoryController.runTheGame(players);
        
        //To remove : 
        List<Personnage> testList = new ArrayList<Personnage>();
        testList.add(new Info("Sacha"));
        testList.add(new Gbm("Pierre-Yves"));
        
        StoryController.runTheGame(testList);
    }
    
  
}
