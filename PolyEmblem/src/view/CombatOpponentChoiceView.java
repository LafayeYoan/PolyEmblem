package view;

import utils.KeyboardInput;
import java.util.List;
import model.Personnage;

/**
 * View that manage the target of a fight.
 * Give to the controller the target choosen.
 */
public class CombatOpponentChoiceView implements HUD{
    
    private List<Personnage> opponents;
    private String enteredText;

    public CombatOpponentChoiceView(List <Personnage> opponents){
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
        if(!utils.Validator.checkEmpty(enteredText)){
            return false;
        }
        int i = 0;
        if(!utils.Validator.checkIsInteger(enteredText)){
            return false;
        }
        try{
            i = Integer.parseInt(enteredText);         
        }catch(Exception e){
        }
        
        if(!utils.Validator.checkRange(i, 1, opponents.size())){
            return false;
        }   
        
        return true;
    }
    
}
