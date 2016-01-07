
package view;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utils.KeyboardInput;
import utils.Validator;

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
        valid = valid & Validator.checkEmpty(className);
        if(!valid){
            return valid;
        }
        valid = valid & Validator.checkInList(className,Arrays.asList(new Object[]{"GBM","INFO","MAM","MAT","MECA"}));
        return valid;
    }

    @Override
    public String getResponse() {
        return className;
    }
    
}
