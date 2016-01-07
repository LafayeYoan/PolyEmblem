package controller;

import java.util.List;
import model.Bag;
import model.Item;
import model.Personnage;
import view.Item.ErrorItemView;
import view.Item.ItemDisplayView;
import view.Item.SelectItemView;

/***
 * Controller for items : 
 * Manage the item found on a DiscoverPlaceEvent (and so manage the bag of the player)
 * @author Lafaye, Lhopital, Paccaud
 */
public class ItemController {

    /***
     * Arranges a treasure found in the bag
     * @param treasure the item to arrange
     * @param bag the team's bag
     */
    public void itemFound(Item treasure, Bag bag) {
        
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
     * Manage the bag of the team. 
     * Displays items from the bag OR go back to the main menu 
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
