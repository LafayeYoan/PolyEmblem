package model.Event;

import model.Events;

public class FightEvent extends Events {
    
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
