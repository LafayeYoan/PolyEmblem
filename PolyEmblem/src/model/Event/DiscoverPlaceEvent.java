package model.Event;

import model.Events;
import model.Item;
import view.ActionChoix;

public class DiscoverPlaceEvent extends Events {
    
    /* Item to discover in this */
    private Item zeTreasure;
    
    public DiscoverPlaceEvent(String description, Item treasure) {
        super(description);
        zeTreasure = treasure;
    }
    
    @Override
    public Events execute() {
        //Mise en forme de la description
        ActionChoix.showPlayer(getDescriptionEvent());
        //Découverte de l'item :
            //Description de l'item 
            //Ajout dans le sac ou sur le personnage (si équipable, proposer de l'équiper)
        return this;
    }
}
