package model.Event;

import model.Events;
import model.Personnage;

public class FightEvent extends Events {
    
    /* Character who wants to fight !*/
    private Personnage zeBadGuy;
    private Personnage zeSecondBadGuy;
    
    public FightEvent(String description, Personnage badGuy) {
        super (description);
        zeBadGuy = badGuy;
    }
    
    public FightEvent(String description, Personnage badGuy, Personnage otherBadGuy) {
        super (description);
        zeBadGuy = badGuy;
        zeSecondBadGuy = otherBadGuy;
    }
    
}
