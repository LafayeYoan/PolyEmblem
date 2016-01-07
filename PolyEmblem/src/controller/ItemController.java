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
        
        switch (treasure.getClass().toString()) {
            
            case "class model.Items.ArmorItem" :
                /**
                TODO : NOT WORKING
                
                itemDisplayView.loadHUD();
                
                if(itemDisplayView.getResponse().equals(0)) {
                    //Do nothing : go back to the main menu
                } else {
                    System.out.println(treasure.toString());
                    player.equipArmor((ArmorItem) treasure);
                }
                break;*/
                
            case "class model.Items.WeaponItem":
                /**
                itemDisplayView.loadHUD();
                
                if(itemDisplayView.getResponse().equals(0)) {
                    //Do nothing : go back to the main menu
                } else {
                    player.equipWeapon((WeaponItem) treasure);
                }
                break;*/
                
            case "class model.Items.EdibleItem":
                
            default:
                if(player.getActualInUseWeight() + treasure.getWeight() < Personnage.MAX_WEIGHT) {
                    
                } else {
                    ErrorItemView errorItemView = new ErrorItemView(player);
                    errorItemView.loadHUD();
                    player.removeItem(player.getItems().get((int) errorItemView.getResponse()));
                }
                player.addItem(treasure);
                itemView.canAddItem();
                manageItemBag(player, itemView);
        }
    }

    /***
     * Manage the bag of the player : displays items from the bag or go back to 
     * the main menu if the itemView is 0. 
     * @param player the player with the bag
     * @param itemView the SelectItem view 
     */
    private void manageItemBag(Personnage player, SelectItemView itemView) {
        
        switch(itemView.getResponse().getClass().toString()) {
            
            case  "class java.lang.Integer" : /* Retour au menu principal */
                
                break;
            
            default : /* Afficher le détail d'un objet */
                ItemDisplayView itemDisplayView = new ItemDisplayView((Item) itemView.getResponse());
                itemDisplayView.loadHUD();  
        }
    }
    
}
