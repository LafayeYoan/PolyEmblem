package view;

import java.util.Scanner;

public class ActionChoix implements HUD{
    
    private model.Personnage personnage;
    private String enteredText;
    
    public ActionChoix(model.Personnage chararcter){
        this.personnage = chararcter;
    }
    
    @Override 
    public void loadHUD() {
        System.out.println("Vuillez choisir une action à faire pendant ce tour:");
        int i = 1;
        for(model.Skill s:personnage.getSkills()){
            System.out.println( i + ":" + s.getName());
            i++;
        }
        
        Scanner sc = new Scanner(System.in);
        do{
            enteredText = sc.nextLine();            
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

    @Override
    public void showPlayer(String message) {
        System.out.println(message.toString());
    }
}
