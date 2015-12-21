package model.Event;

import model.Events;
import model.Item;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Personnage;

public class DiscoverPlaceEvent extends Events {
    
    /* Item to discover in this */
    private Item zeTreasure;
    
    public DiscoverPlaceEvent(String description, Item treasure) {
        super(description);
        zeTreasure = treasure;
    }
    
    public Item getTreasure() {
        return zeTreasure;
    }
    
    @Override
    public void act(Personnage player) {
      
        if(zeTreasure.getClass() == ArmorItem.class 
                || zeTreasure.getClass() == WeaponItem.class) {
            //TODO : Proposer au joueur de l'équiper.
        } else { 
            if(player.getActualInUseWeight() + zeTreasure.getWeight() > Personnage.MAX_WEIGHT) {
                System.out.println("\n L'objet ne peux pas être ajouté au sac à dos car il est déjà plein !");
                //TODO : proposer de supprimer un objet de l'inventaire
            } else  {
                //TODO : ajouter l'item dans le sac à dos
                System.out.println("\n L'objet est ajouté au sac à dos !");
            }
        }
    }
}
