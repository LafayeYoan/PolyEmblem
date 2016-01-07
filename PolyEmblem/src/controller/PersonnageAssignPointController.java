package controller;

/**
 * Helper for assign a capacity point to a character when level up.
 * @author Lafaye, Lhopital, Paccaud
 */
public class PersonnageAssignPointController {
    
    /***
     * Asks the player to assign a capacity point to his character. 
     * Then update the character. 
     * @param player the character who level up
     */
    public static void assignPoint(model.Personnage player){
        view.Personnage.CapacityAssignPointView view = new view.Personnage.CapacityAssignPointView(player);
        
        view.loadHUD();
        
        model.Characteristic charact = view.getResponse();
        
        player.increaseCharacteristic(charact);  
       
    }
}
