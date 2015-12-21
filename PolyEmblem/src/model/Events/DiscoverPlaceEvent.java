package model.Events;

import model.Event;
import model.Item;

public class DiscoverPlaceEvent extends Event {
    
    /* Item to discover in this */
    private Item zeTreasure;
    
    public DiscoverPlaceEvent(String description, Item treasure) {
        super(description);
        zeTreasure = treasure;
    }
}
