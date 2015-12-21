package model.Event;

import model.Events;
import model.Item;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Personnage;
import view.ActionChoix;

public class DiscoverPlaceEvent extends Events {
    
    /* Item to discover in this */
    private Item zeTreasure;
    
    public DiscoverPlaceEvent(String description, Item treasure) {
        super(description);
        zeTreasure = treasure;
    }
    
    @Override
    public Events execute(Personnage player) {
        
        ActionChoix.showPlayer(getDescriptionEvent());
        ActionChoix.showPlayer("\n Vous obtenez : " + zeTreasure.getName() 
            + ". \n" + zeTreasure.getDescription());
      
        if(zeTreasure.getClass() == ArmorItem.class 
                || zeTreasure.getClass() == WeaponItem.class) {
            //TODO : Proposer au joueur de l'équiper.
        } else { 
            if(player.getActualInUseWeight() + zeTreasure.getWeight() > Personnage.MAX_WEIGHT) {
                ActionChoix.showPlayer("\n L'objet ne peux pas être ajouté au sac à dos car il est déjà plein !");
                //TODO : proposer de supprimer un objet de l'inventaire
            } else  {
                //TODO : ajouter l'item dans le sac à dos
                ActionChoix.showPlayer("\n L'objet est ajouté au sac à dos !");
            }
        }
        return this;
    }
}
