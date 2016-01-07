package model;

public class Events {
    
    /* Describe the event for the player */
    private String descriptionEvent;
    public boolean isDone;
    
    public Events(String description) {
        descriptionEvent = description;
        isDone = false;
    }
    
    public String getDescriptionEvent() {
        return descriptionEvent;
    }
}
