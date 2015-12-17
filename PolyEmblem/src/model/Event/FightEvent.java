package model.Event;

import model.Events;

public class FightEvent extends Events {
    
    /* Character who wants to fight !*/
    private Character zeBadGuy;
    
    public FightEvent(int number, String description, Character badGuy) {
        super (number, description);
        zeBadGuy = badGuy;
    }
    
}
