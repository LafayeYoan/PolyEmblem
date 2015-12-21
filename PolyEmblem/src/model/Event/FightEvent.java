package model.Event;

import java.util.ArrayList;
import java.util.List;
import model.Events;
import model.Personnage;
import model.Fight;
import view.ActionChoix;

public class FightEvent extends Events {
    
    /* Character who wants to fight !*/
    private List<Personnage> allBadGuys;
    
    public FightEvent(String description, Personnage... badGuys) {
        super (description);
        
        allBadGuys = new ArrayList<Personnage>();
        for(int i = 0; i < badGuys.length; i ++) {
            allBadGuys.add(badGuys[i]);
        }
    }

    @Override
    public Events execute(Personnage player) {
        
        ActionChoix.showPlayer("\n" + getDescriptionEvent() + "\n");
        
        for(Personnage badGuy : allBadGuys) {
            ActionChoix.showPlayer(badGuy.getName() + " "); 
        }
        ActionChoix.showPlayer(" veulent se battre !"); 
        
        //Combat : 
        //Weird Implémentation ???
        Fight zeFight = new Fight(player, allBadGuys.get(0), null);
        //zeFight.run();
        //A la fin, mise à jour xp
        //Joueur regagne un peu de sa vie
        return this;
    }
    
}
