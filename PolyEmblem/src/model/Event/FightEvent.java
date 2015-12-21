package model.Event;

import java.util.ArrayList;
import java.util.List;
import model.Events;
import model.Personnage;
import model.Fight;
import view.HUD;

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
    public void execute(Personnage player, HUD menuForDisplay) {
        
        menuForDisplay.showPlayer("\n" + getDescriptionEvent() + "\n");
        
        for(Personnage badGuy : allBadGuys) {
            menuForDisplay.showPlayer(badGuy.getName() + " "); 
        }
        menuForDisplay.showPlayer(" veulent se battre !"); 
        
        //Combat : 
        //Weird Implémentation ???
        Fight zeFight = new Fight(player, allBadGuys.get(0), null);
        //zeFight.run();
        //A la fin, mise à jour xp
        //Joueur regagne un peu de sa vie
    }
    
}
