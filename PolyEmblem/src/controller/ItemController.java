package controller;

import java.util.ArrayList;
import java.util.List;
import model.Bag;
import model.Item;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Personnage;
import view.ErrorItemView;
import view.ItemDisplayView;
import view.SelectItemView;

public class ItemController {

    /***
     * Arranges a treasure found in the bag
     * @param allPlayers list of all the players
     * @param treasure the item to arrange
     * @param bag the team's bag
     */
    public void itemFound(List<Personnage> allPlayers, Item treasure, Bag bag) {
        
        SelectItemView itemView = new SelectItemView(bag);
        ItemDisplayView itemDisplayView = new ItemDisplayView(treasure);
        ErrorItemView errorItemView = new ErrorItemView(bag);
        
        boolean abandonTreasure = false;
        String treasureClass = treasure.getClass().toString();
        
        /* Try to put the item in the bag */
        while(bag.getActualInUseWeight() + treasure.getWeight() > bag.maxWeight) {
            errorItemView.loadHUD();
            
            try{
                int i = Integer.parseInt((String) errorItemView.getResponse());
                abandonTreasure = true;
                break;
            }catch(ClassCastException e){
                bag.removeItem((Item) errorItemView.getResponse());
            }
        }
        
        if(abandonTreasure) {
            //Do nothing, we leave the treasure
        } else {
            bag.addItem(treasure);
            
            if(treasureClass.equals("class model.Items.ArmorItem")) {
                itemDisplayView.loadHUD();
                if(itemDisplayView.getResponse().equals(0)) {
                    //Do nothing : go back to the main menu
                } else {
                    //TODO
                    //player.equipArmor((ArmorItem) treasure);
                }
            }
        
            if(treasureClass.equals("class model.Items.WeaponItem")) {
                itemDisplayView.loadHUD();
                if(itemDisplayView.getResponse().equals(0)) {
                    //Do nothing : go back to the main menu
                } else {
                    //TODO
                    //player.equipWeapon((WeaponItem) treasure);
                }
            }

            itemView.canAddItem();
            manageItemBag(bag, itemView);
        }   
    }

    /***
     * Manage the bag of the team : displays items from the bag or go back to 
     * the main menu if the itemView is 0. 
     * @param bag the bag to display
     * @param itemView the SelectItem view 
     */
    private void manageItemBag(Bag bag, SelectItemView itemView) {
        
        switch(itemView.getResponse().getClass().toString()) {
            
            case  "class java.lang.Integer" : /* Go back to the main menu */
                
                break;
            
            default : /* Display the item details */
                ItemDisplayView itemDisplayView = new ItemDisplayView((Item) itemView.getResponse());
                itemDisplayView.loadHUD();  
        }
    }
    
}
