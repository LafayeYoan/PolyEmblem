package model.Event;

import model.Events;
import model.Item;
import model.Items.ArmorItem;
import model.Items.WeaponItem;
import model.Personnage;
import view.HUD;

public class DiscoverPlaceEvent extends Events {
    
    /* Item to discover in this */
    private Item zeTreasure;
    
    public DiscoverPlaceEvent(String description, Item treasure) {
        super(description);
        zeTreasure = treasure;
    }
    
    @Override
    public void execute(Personnage player, HUD menuForDisplay) {
        
        //lancer vue 
        // récupérer le résultat si y en a un 
        // lancer l'event suivant
        
        menuForDisplay.showPlayer(getDescriptionEvent());
        menuForDisplay.showPlayer("\n Vous obtenez : " + zeTreasure.getName() 
            + ". \n" + zeTreasure.getDescription());
      
        if(zeTreasure.getClass() == ArmorItem.class 
                || zeTreasure.getClass() == WeaponItem.class) {
            //TODO : Proposer au joueur de l'équiper.
        } else { 
            if(player.getActualInUseWeight() + zeTreasure.getWeight() > Personnage.MAX_WEIGHT) {
                menuForDisplay.showPlayer("\n L'objet ne peux pas être ajouté au sac à dos car il est déjà plein !");
                //TODO : proposer de supprimer un objet de l'inventaire
            } else  {
                //TODO : ajouter l'item dans le sac à dos
                menuForDisplay.showPlayer("\n L'objet est ajouté au sac à dos !");
            }
        }
    }

    @Override
    public void act(model.Personnage perso) {
        
    }
}
