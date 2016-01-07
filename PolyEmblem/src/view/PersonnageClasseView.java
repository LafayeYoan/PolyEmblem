
package view;
import utils.KeyboardInput;

/**
 * View that manage the class of the character when created. 
 * Give to the controller the class choosen.
 */
public class PersonnageClasseView implements HUD {

    private String className;
    @Override
    public void loadHUD() {
        System.out.println("Veuillez selectionez la classe:");
        System.out.println("1 - GBM, Genie Biomedical : Soin");
        System.out.println("2 - INFO, Informatitien : Voleur");
        System.out.println("3 - MAM, Mathematique Appliquee et Modelisation : Mage");
        System.out.println("4 - MAT, Materiaux : Distance");
        System.out.println("5 - MECA, Mecannique : Brute de decofrage");
        do{
            className = KeyboardInput.getInput();           
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
    
}
