/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Darkos
 */
public class SelectItem implements HUD{

    private model.Personnage perso;
    private String enteredText;
    
    public SelectItem(model.Personnage perso){
        this.perso = perso;
    }
    
    @Override
    public void loadHUD() {
       
        System.out.println("Vuillez choisir un Item:");
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
        
        Scanner sc = new Scanner(System.in);
        do{
            enteredText = sc.nextLine();            
        }while(!isValid());
    }

    @Override
    public Object getResponse() {
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
        
        if(i>=perso.getSkills().size()||i <=0){
            System.out.println("Veuillez entrer un chiffre compris entre 1 et "+perso.getItems().size()+".");
            valid = false;
            return valid;
        }
        
        
        return valid;
    }
    
}
