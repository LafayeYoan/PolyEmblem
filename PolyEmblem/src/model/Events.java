package model;


public class Events {
    
    /* the number of the event define it's order */
    private int eventNumber;
    /* Describe the event for the player */
    private String descriptionEvent;
    
    public Events(int number, String description) {
        eventNumber = number;
        descriptionEvent = description;
    }
    
    public String getDescriptionEvent() {
        return descriptionEvent;
    }    
}
