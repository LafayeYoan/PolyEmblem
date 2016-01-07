package view;

import controller.KeyboardInput;

/**
 * View that manage the name of the character when created.
 * Give to the controller the name choosen.
 */
public class PersonnageNom implements HUD{

    private String nom;

    @Override
    public void loadHUD() {
        System.out.println("Veullez entrez votre nom de personnage.");
        do{
            nom = KeyboardInput.getInput();         
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
