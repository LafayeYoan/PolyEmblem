package model;


public class Event {
    
    /* Describe the event for the player */
    private String descriptionEvent;
    
    public Event(String description) {
        descriptionEvent = description;
    }
    
    public String getDescriptionEvent() {
        return descriptionEvent;
    }    
}
