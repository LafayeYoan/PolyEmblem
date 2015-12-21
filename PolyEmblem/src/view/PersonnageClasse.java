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
public class PersonnageClasse implements HUD {

    private String className;
    @Override
    public void loadHUD() {
        System.out.println("Veuillez selectionez la classe:");
        System.out.println("1 - GBM, Genie Biomedical : Soin");
        System.out.println("2 - INFO, Informatitien : Voleur");
        System.out.println("3 - MAM, Mathematique Appliquee et Modelisation : Mage");
        System.out.println("4 - MAT, Materiaux : Distance");
        System.out.println("5 - MECA, Mecannique : Brute de decofrage");
        Scanner sc = new Scanner(System.in);
        do{
            className = sc.nextLine();            
        }while(!isValid());
    }
    
    private boolean isValid(){
        boolean valid = true;
        if(className.isEmpty()){
            valid = false;
            System.out.println("Le nom est vide, veuillez le reentrer.");
            return valid;
        }
        
        if(!(className.equals("GBM")|className.equals("INFO")||className.equals("MAM")||className.equals("MAT")||className.equals("MECA"))){
            valid = false;
            System.out.println("La classe choisie n'existe pas, veuillez le reentrer.");
        }
        return valid;
    }

    @Override
    public String getResponse() {
        return className;
    }

    @Override
    public void showPlayer(String message) {
        System.out.println(message.toString());
    }
    
}
