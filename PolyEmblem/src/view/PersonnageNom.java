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
public class PersonnageNom implements HUD{

    private String nom;

    @Override
    public void loadHUD() {
        System.out.println("Veullez entrez votre nom de personnage.");
        Scanner sc = new Scanner(System.in);
        do{
            nom = sc.nextLine();            
            if(nom.isEmpty()){
                System.out.println("Le nom est vide, veuillez le reentrer.");
            }
        }while(nom.isEmpty());
        
    }

    @Override
    public String getResponse() {
        return nom;
    }
    
}