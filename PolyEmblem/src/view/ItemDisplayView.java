package view;

import utils.KeyboardInput;
import model.Item;

/**
 * View that display details of an item. 
 * Give to the controller the action to do next 
 * (i.e : go back to the main menu OR Equip the item and go back to the main menu)
 */
public class ItemDisplayView implements HUD {
    
    private final Item item;
    private String enteredText;
    
    public ItemDisplayView(Item itemToDisplay){
        this.item = itemToDisplay;
    }

    @Override
    public void loadHUD() {
        System.out.println("----------------------------------------");
        System.out.println("--------- Details de l'objet -----------");
        System.out.println("----------------------------------------");
        System.out.println(item.getDescription());
        
        /* If the item is equipable */
        if(item.getClass().toString().equals("class model.Items.ArmorItem")
                || item.getClass().toString().equals("class model.Items.WeaponItem")) {
            
            /* If the item is not equiped */
            if(item.equiped == false) {
                
                System.out.println("(Appuyez sur 0 si vous souhaitez revenir au menu principal) ");
                System.out.println("(Appuyez sur 1 si vous souhaitez équiper cet objet) ");
                
                enteredText = KeyboardInput.getInput();
                                  
            } else {
                enteredText = "0";
            }
        }
    }

    @Override
    public Object getResponse() {
        if(enteredText.equals("0")) {
            return 0;
        } 
        return 1;
    }
    
}
