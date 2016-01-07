package controller;

import java.util.ArrayList;
import java.util.List;
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
     */
    public void itemFound(List<Personnage> allPlayers, Item treasure) {
        
        SelectItemView itemView = new SelectItemView(getAllItemsOf(allPlayers));
        ItemDisplayView itemDisplayView = new ItemDisplayView(treasure);
        ErrorItemView errorItemView = new ErrorItemView(player);
        
        String treasureClass = treasure.getClass().toString();
        boolean abandonTreasure = false;
        
        /* Try to put the item in the bag */
        while(player.getActualInUseWeight() + treasure.getWeight() > Personnage.MAX_WEIGHT) {
            errorItemView.loadHUD();
            
            try{
                int i = Integer.parseInt((String) errorItemView.getResponse());
                abandonTreasure = true;
                break;
            }catch(ClassCastException e){
                player.removeItem((Item) errorItemView.getResponse());
            }
        }
        
        if(abandonTreasure) {
            //Do nothing, we leave the treasure
        } else {
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
                itemDisplayView.loadHUD();
                if(itemDisplayView.getResponse().equals(0)) {
                    //Do nothing : go back to the main menu
                } else {
                    player.equipWeapon((WeaponItem) treasure);
                }
            }

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
            
            case  "class java.lang.Integer" : /* Go back to the main menu */
                
                break;
            
            default : /* Display the item details */
                ItemDisplayView itemDisplayView = new ItemDisplayView((Item) itemView.getResponse());
                itemDisplayView.loadHUD();  
        }
    }

    /***
     * Get all items of the team. 
     * @param allPlayers a list of all characters which we want items
     * @return a list of item
     */
    private List<Item> getAllItemsOf(List<Personnage> allPlayers) {
        
        List<Item> allItems = new ArrayList<Item>();
        for(Personnage player : allPlayers) {
            allItems.addAll(player.getItems());
        }
        return allItems;
    }
    
}
