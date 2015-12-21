package model.Event;

import model.Events;
import model.Item;

public class DiscoverPlaceEvent extends Events {
    
    /* Item to discover in this */
    private Item zeTreasure;
    
    public DiscoverPlaceEvent(String description, Item treasure) {
        super(description);
        zeTreasure = treasure;
    }
    
    @Override
    public Events execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
