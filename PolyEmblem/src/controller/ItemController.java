package controller;

import model.Item;
import model.Personnage;
import view.ErrorItemView;
import view.EventView;
import view.ItemDisplayView;
import view.SelectItem;

public class ItemController {

    /***
     * Arranges a treasure found in the bag
     * @param player the player with the bag
     * @param treasure the item to arrange
     */
    public void itemFound(Personnage player, Item treasure) {
        
        SelectItem itemView = new SelectItem(player);
        
        switch (treasure.getClass().toString()) {
            
            case "class model.Items.ArmorItem" :
                
            case "class model.Items.WeaponItem":
                //TODO
                //Demander au joueur s'il veut l'équiper. 
                //Si oui on équipe mais on ajoute quand même au sac
                //Sinon on l'ajoute juste. 
                
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
    private void manageItemBag(Personnage player, SelectItem itemView) {
        
        EventView eventView = new EventView(player);
        
        switch(itemView.getResponse().getClass().toString()) {
            
            case  "class java.lang.Integer" : /* Retour au menu principal */
                
                break;
            
            default : /* Afficher le détail d'un objet */
                ItemDisplayView itemDisplayView = new ItemDisplayView((Item) itemView.getResponse());
                itemDisplayView.loadHUD();  
                eventView.loadHUD();
        }
    }
    
}
