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
    
    public List<Personnage> getAllBadGuys() {
        return allBadGuys;
    }

    @Override
    public void act(Personnage player) {
        
        //Combat : 
        //Weird Implémentation ???
        Fight zeFight = new Fight(player, allBadGuys.get(0), null);
        //zeFight.run();
        //A la fin, mise à jour xp
        //Joueur regagne un peu de sa vie
    }
}
