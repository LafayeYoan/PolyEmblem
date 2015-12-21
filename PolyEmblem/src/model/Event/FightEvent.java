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
    
    /* OLD Version 
    
    /* Character who wants to fight !
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
    }*/

    @Override
    public void act(Personnage perso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
