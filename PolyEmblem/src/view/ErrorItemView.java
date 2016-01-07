package view;

import utils.KeyboardInput;
import model.Personnage;

/***
 * View that manage the error when we try to add an item in the bag and it's not possible. 
 * Give to the controller the item to delete instead of the new one. 
 */
public class ErrorItemView implements HUD {
    
    private final Personnage perso;
    private String itemToDelete;
    
    public ErrorItemView(Personnage perso){
        this.perso = perso;
    }

    @Override
    public void loadHUD() {
        System.out.println("\n L'objet ne peux pas être ajouté au sac à dos car il est déjà plein !");
        System.out.println("\n Quel objet souhaitez-vous laisser sur place ?");
        int i = 1;
        for(model.Item o:perso.getItems()){
            System.out.print( i + ":" + o.getName());
            
            if(o.equiped){
                System.out.println(" qui est équipé.");
            }else
            {
                System.out.println();
            }
            i++;
        }
        do{
            itemToDelete = KeyboardInput.getInput();
        }while(!isValid());
    }

    @Override
    public Object getResponse() {
        try{
            return perso.getItems().get(Integer.parseInt(itemToDelete) -1);
        }catch(Exception e){
            
        }
        return null;
    }
    
    private boolean isValid(){
        boolean valid = true;
        if(itemToDelete.isEmpty()){
            System.out.println("Veuillez entrer une valeur.");
            valid = false;
            return valid;
        }
        int i;
        try{
            i = Integer.parseInt(itemToDelete);         
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
