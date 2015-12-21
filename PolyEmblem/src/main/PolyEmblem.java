/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.CharacterCreation;

/**
 *
 * @author Darkos
 */
public class PolyEmblem {
    public static void main(String [] args){
        System.out.println("PolyEmblem, the Game TaTaTa!!! (comme les mignon)");
        System.out.println("Soon on yours screens !!");        
        run();        
    }
    
    public static void run(){
        controller.Controller.generateEvents();
        controller.Controller.players = CharacterCreation.start();
    }
    
    
}
