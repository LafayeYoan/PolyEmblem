package model.Event;

import java.util.ArrayList;
import java.util.List;
import model.Events;
import model.Personnage;

public class FightEvent extends Events {
    
    /* Characters who wants to fight !*/
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
}
