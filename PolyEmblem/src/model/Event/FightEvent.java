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

    @Override
    public Events execute() {
        //TODO
        //Mise en forme de la description
        //Combat : 
            //tant que vivant : combat 
            //A la fin, mise à jour xp
            //Joueur regagne un peu de sa vie
        return this;
    }
    
}
