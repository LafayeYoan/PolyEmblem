package view;

import java.util.List;
import model.Item;
import model.Personnage;
import utils.KeyboardInput;

/**
 * View that manage the bag of the player.
 * Give to the controller the action to do next 
 * (i.e : an item to display OR go back to the main menu).
 */
public class SelectItemView implements HUD{

    private List<Item> allItemsOfTeam;
    private String enteredText;
    
    public SelectItemView(List<Item> allItems){
        this.allItemsOfTeam = allItems;
    }
    
    @Override
    public void loadHUD() {
        System.out.println("----------------------------------------");
        System.out.println("-------- Contenu de vos sacs ----------");
        System.out.println("----------------------------------------");
        System.out.println("Choisissez un objet pour voir son détail : ");
        System.out.println("(Appuyez sur 0 pour revenir au menu principal) \n");
        
        int i = 1;
        for(Item o: allItemsOfTeam){
            System.out.print( i + ":" + o.getName());
            
            if(o.equiped){
                
                System.out.println(" est équipé.");
            } else {
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
            return allItemsOfTeam.get(Integer.parseInt(enteredText) -1);
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
