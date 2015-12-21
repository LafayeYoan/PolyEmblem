package model.Event;

import controller.ItemController;
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
        // ???        
    }
}
