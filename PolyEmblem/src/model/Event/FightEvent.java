package model.Event;

import java.util.ArrayList;
import java.util.List;
import model.Events;
import model.IA.IAPersonnage;

public class FightEvent extends Events {
    
    /* Characters who wants to fight !*/
    private List<IAPersonnage> allBadGuys;
    
    public FightEvent(String description, IAPersonnage... badGuys) {
        super (description);
        
        allBadGuys = new ArrayList<IAPersonnage>();
        for(int i = 0; i < badGuys.length; i ++) {
            allBadGuys.add(badGuys[i]);
        }
    }
    
    public List<IAPersonnage> getAllBadGuys() {
        return allBadGuys;
    }
}
