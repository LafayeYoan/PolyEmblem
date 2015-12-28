package view;

import controller.KeyboardInput;
import java.util.Scanner;
import model.Personnage;

/**
 *
 * @author Darkos
 */
public class CombatActionChoice implements HUD{
    
    private Personnage personnage;
    private String enteredText;

    public CombatActionChoice(model.Personnage perso){
        this.personnage = perso;
    }
    
    @Override 
    public void loadHUD() {
        System.out.println("Veuillez choisir une action à faire pendant ce tour:");
        int i = 1;
        for(model.Skill s:personnage.getSkills()){
            System.out.println( i + ":" + s.getName());
            i++;
        }
        do{
            enteredText = KeyboardInput.getInput();            
        }while(!isValid());
    }

    @Override
    public Object getResponse() {
        try{
            return personnage.getSkills().get(Integer.parseInt(enteredText) -1);
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
        
        if(i>=personnage.getSkills().size()||i <=0){
            System.out.println("Veuillez entrer un chiffre compris entre 1 et "+personnage.getSkills().size()+".");
            valid = false;
            return valid;
        }
        
        
        return valid;
    }
    
    /***
     * Show the confirmation message when win the fight. Then go back to the 
     * global menu.
     */
    public void displayEndFight() {
        System.out.println("Bravo ! Vous avez gagné ce combat !");
    }
}
