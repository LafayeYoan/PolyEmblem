package model.Events;

import model.Event;

public class FightEvent extends Event {
    
    /* Character who wants to fight !*/
    private model.Personnage zeBadGuy;
    private model.Personnage zeSecondBadGuy;
    
    public FightEvent(String description, model.Personnage badGuy) {
        super (description);
        zeBadGuy = badGuy;
    }
    
    public FightEvent(String description, model.Personnage badGuy, model.Personnage otherBadGuy) {
        super (description);
        zeBadGuy = badGuy;
        zeSecondBadGuy = otherBadGuy;
    }

    @Override
    public void act(model.Personnage perso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
