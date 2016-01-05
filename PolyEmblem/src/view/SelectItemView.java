/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.KeyboardInput;

/**
 *
 * @author Darkos
 */
public class SelectItemView implements HUD{

    private model.Personnage perso;
    private String enteredText;
    
    public SelectItemView(model.Personnage perso){
        this.perso = perso;
    }
    
    @Override
    public void loadHUD() {
        System.out.println("----------------------------------------");
        System.out.println("-------- Contenu de votre sac ----------");
        System.out.println("----------------------------------------");
        System.out.println("Choisissez un objet pour voir son détail : ");
        System.out.println("(Appuyez sur 0 pour revenir au menu principal) \n");
        int i = 1;
        for(model.Item o:perso.getItems()){
            System.out.print( i + ":" + o.getName());
            
            if(o.equiped){
                System.out.println(" est équipé.");
            }else
            {
                System.out.println();
            }
            i++;
        }
        do{
            enteredText = KeyboardInput.getInput();
        }while(!isValid());
    }

    /***
     * Show the confirmation message when adding to the bag. Then go back to the 
     * SelectItem global menu.
     */
    public void canAddItem() {
        System.out.println("\n L'objet a correctement été ajouté au sac à dos ! \n");
        loadHUD();
    }

    @Override
    public Object getResponse() {
        
        if(enteredText.equals("0")) {
            return 0;
        } 
        
        try{
            return perso.getItems().get(Integer.parseInt(enteredText) -1);
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
        
        if(i>=perso.getSkills().size()||i < 0){
            System.out.println("Veuillez entrer un chiffre compris entre 0 et "+perso.getItems().size()+".");
            valid = false;
            return valid;
        }
        
        
        return valid;
    }
    
}
