/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Darkos
 */
public class PersonnageAssignPointController {
    public static void assignPoint(model.Personnage player){
        view.Personnage.CapacityAssignPointView view = new view.Personnage.CapacityAssignPointView(player);
        
        view.loadHUD();
        
        model.Characteristic charact = view.getResponse();
        
        player.increaseCharacteristic(charact);  
       
    }
}
