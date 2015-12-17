package model.Event;

import model.Events;
import model.Item;

public class DiscoverPlaceEvent extends Events {
    
    /* Item to discover in this */
    private Item zeTreasure;
    
    public DiscoverPlaceEvent(int number, String description, Item treasure) {
        super(number, description);
        zeTreasure = treasure;
    }
}
