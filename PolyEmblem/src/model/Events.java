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
    
    //Called when the event is used
    /**
     * 
     * @param perso Perosnage conserned by the event
     */
    public abstract void act(Personnage perso);

}
