package model;

public abstract class Events {
    
    /* Describe the event for the player */
    private String descriptionEvent;
    
    public Events(String description) {
        descriptionEvent = description;
    }
    
    public String getDescriptionEvent() {
        return descriptionEvent;
    }   
    
    public abstract Events execute();
}
