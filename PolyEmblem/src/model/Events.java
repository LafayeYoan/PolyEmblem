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
    
    /* YOAN VERSION
    
    /* Describe the event for the player 
    private String descriptionEvent;
    
    public Event(String description) {
        descriptionEvent = description;
    }
    
    public String getDescriptionEvent() {
        return descriptionEvent;
    }
    
    //Called when the event is used
    /**
     * 
     * @param perso Perosnage conserned by the event
     */
    public abstract void act(model.Personnage perso);

}
