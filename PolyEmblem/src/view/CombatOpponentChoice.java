package view;

import controller.KeyboardInput;
import java.util.List;
import model.Personnage;

/**
 * View that manage the target of a fight.
 * Give to the controller the target choosen.
 */
public class CombatOpponentChoice implements HUD{
    
    private List<Personnage> opponents;
    private String enteredText;

    public CombatOpponentChoice(List <Personnage> opponents){
        this.opponents = opponents;
    }
    
    @Override 
    public void loadHUD() {
        System.out.println("Veuillez choisir le personage à attaquer:");
        int i = 1;
        for(Personnage p:opponents){
            System.out.println( i + ":" + p.getBasicDescription());
            i++;
        }
        do{
            enteredText = KeyboardInput.getInput();            
        }while(!isValid());
    }

    @Override
    public Personnage getResponse() {
        try{
            return opponents.get(Integer.parseInt(enteredText) -1);
        }catch(Exception e){
            
        }
        return null;
    }
    
    private boolean isValid(){
        boolean valid = true;
        if(enteredText.isEmpty()){
            System.out.println("Veuillez entrer une valeur.");
            valid = false;
            return valid;
        }
        int i;
        try{
            i = Integer.parseInt(enteredText);         
        }catch(Exception e){
            System.out.println("Veuillez entrer un chiffre.");
            valid = false;
            return valid;
        }
        
        if(i>opponents.size()||i <=0){
            System.out.println("Veuillez entrer un chiffre compris entre 1 et "+opponents.size()+".");
            valid = false;
            return valid;
        }
        
        
        return valid;
    }
    
}
