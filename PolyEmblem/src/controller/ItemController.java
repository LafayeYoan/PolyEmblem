package controller;

import model.Item;
import model.Personnage;
import view.ErrorItemView;
import view.SelectItem;

public class ItemController {

    public void addItem(Personnage player, Item treasure) {
        
        SelectItem itemView = new SelectItem(player);
        
        switch (treasure.getClass().toString()) {
            
            case "class model.Items.ArmorItem":
                //TODO
                //Equip if possible
                break;
                
            case "class model.Items.WeaponItem":
                //TODO
                //Equip if possible
                break;
                
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
        }
    }
    
}
