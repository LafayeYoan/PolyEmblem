package model.Events;

import model.Event;

public class FightEvent extends Event {
    
    /* Character who wants to fight !*/
    private Character zeBadGuy;
    private Character zeSecondBadGuy;
    
    public FightEvent(String description, Character badGuy) {
        super (description);
        zeBadGuy = badGuy;
    }
    
    public FightEvent(String description, Character badGuy, Character otherBadGuy) {
        super (description);
        zeBadGuy = badGuy;
        zeSecondBadGuy = otherBadGuy;
    }
    
}
