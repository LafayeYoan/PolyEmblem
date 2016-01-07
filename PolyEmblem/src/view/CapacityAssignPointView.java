package view;

import java.util.Map;
import utils.KeyboardInput;

/**
 * View that manage "l'attribution d'un point de compétence" when level up.
 * Give to the controller the field chosen.
 */
public class CapacityAssignPointView implements HUD{
    
    private final model.Personnage  perso;
    private String enteredText;
    
    public CapacityAssignPointView(model.Personnage perso){
        this.perso = perso;
    }
    @Override
    public void loadHUD() {
        System.out.println("--------------------------------------------------");
        System.out.println("------- Attribution du point de compétence -------");
        System.out.println("--------------------------------------------------");
        Map <model.Characteristic, Integer> caracts = perso.getCharacteritics();
        System.out.println("1 - Force (val:"+caracts.getOrDefault(model.Characteristic.STRENGHT,0)+")");
        System.out.println("2 - Defence (val:"+caracts.getOrDefault(model.Characteristic.DEFENCE,0)+")");
        System.out.println("3 - Dextiritée (val:"+caracts.getOrDefault(model.Characteristic.DEXTIRITY,0)+")");
        System.out.println("4 - Intéligence (val:"+caracts.getOrDefault(model.Characteristic.INTELIGENCE,0)+")");
        System.out.println("5 - Vie (val:"+caracts.getOrDefault(model.Characteristic.HEALTH,0)+")");
        System.out.println("--------------------------------------------------");


        do{
        System.out.println("Veuillez selectionner une caracteristique à modifier (1-5).");
        
        enteredText = KeyboardInput.getInput();
        }while(!isValid());
        
        System.out.println("--------------------------------------------------");

   
    }

    @Override
    public model.Characteristic getResponse() {
        int selected = Integer.parseInt(enteredText);
        switch(selected){
            case 1:
                return model.Characteristic.STRENGHT;
            case 2:
                return model.Characteristic.DEFENCE;
            case 3:
                return model.Characteristic.DEXTIRITY;
            case 4:
                return model.Characteristic.INTELIGENCE;
            case 5:
                return model.Characteristic.HEALTH;
            default:
                return null;
            
        }
    }
    
    private boolean isValid(){
        int selected = 0;
        try{
            selected = Integer.parseInt(enteredText);
        }catch(Exception e){
            System.out.println("Veuillez entrer un chiffre");
            return false;
        }
        if(selected < 1 || selected >5){
            System.out.println("Veuillez entrer un chiffre entre 0 et 5");
            return false;
        }        
        return true;
    }
    
}
