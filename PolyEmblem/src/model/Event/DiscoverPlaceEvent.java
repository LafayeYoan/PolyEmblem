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
    
    public Item getTreasure() {
        return zeTreasure;
    }
    
}
