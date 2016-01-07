package controller;

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
     * @param player the player with the bag
     * @param treasure the item to arrange
     */
    public void itemFound(Personnage player, Item treasure) {
        
        SelectItemView itemView = new SelectItemView(player);
        ItemDisplayView itemDisplayView = new ItemDisplayView(treasure);
        String treasureClass = treasure.getClass().toString();
        
        /* Try to put the item in the bag */
        if(player.getActualInUseWeight() + treasure.getWeight() < Personnage.MAX_WEIGHT) {
                    
        } else {
            ErrorItemView errorItemView = new ErrorItemView(player);
            errorItemView.loadHUD();
            player.removeItem(player.getItems().get((int) errorItemView.getResponse()));
        }
        
        player.addItem(treasure);
        
        if(treasureClass.equals("class model.Items.ArmorItem")) {
            itemDisplayView.loadHUD();
            if(itemDisplayView.getResponse().equals(0)) {
                //Do nothing : go back to the main menu
            } else {
                player.equipArmor((ArmorItem) treasure);
            }
        }
        
        if(treasureClass.equals("class model.Items.WeaponItem")) {
            /**
            itemDisplayView.loadHUD();

            if(itemDisplayView.getResponse().equals(0)) {
                //Do nothing : go back to the main menu
            } else {
                player.equipWeapon((WeaponItem) treasure);
            }*/
        }
        
        itemView.canAddItem();
        manageItemBag(player, itemView);
    }

    /***
     * Manage the bag of the player : displays items from the bag or go back to 
     * the main menu if the itemView is 0. 
     * @param player the player with the bag
     * @param itemView the SelectItem view 
     */
    private void manageItemBag(Personnage player, SelectItemView itemView) {
        
        switch(itemView.getResponse().getClass().toString()) {
            
            case  "class java.lang.Integer" : /* Go back to the main menu */
                
                break;
            
            default : /* Display the item details */
                ItemDisplayView itemDisplayView = new ItemDisplayView((Item) itemView.getResponse());
                itemDisplayView.loadHUD();  
        }
    }
    
}
