package model;

import view.HUD;

public abstract class Events {
    
    /* Describe the event for the player */
    private String descriptionEvent;
    
    public Events(String description) {
        descriptionEvent = description;
    }
    
    public String getDescriptionEvent() {
        return descriptionEvent;
    }   
    
    public abstract void execute(Personnage player, HUD menuForDisplay);
}
