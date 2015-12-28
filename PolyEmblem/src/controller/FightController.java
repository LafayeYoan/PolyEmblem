package controller;

import java.util.List;
import model.Fight;
import model.Personnage;
import view.CombatActionChoice;

/**
 *
 * @author lhopital
 */
public class FightController {

    /***
     * Run the Fight between player and all bad guys.
     * Call the correct view for each action.
     * @param player the player
     * @param allBadGuys a list of bad guys (one or many)
     */
    public void runTheFight(Personnage player, List<Personnage> allBadGuys) {
        
        boolean isPlayerTurn = true;
        CombatActionChoice playerTurn = new CombatActionChoice(player);
        
        while(true) {
            
            if(theFightIsOver(player, allBadGuys)) {
                //Appeller la vue pour la fin du combat
                break;
            }
            
            if(isPlayerTurn) {
                //Tour du joueur
            } else {
                //Tour IA
            }
            
            break; //To remove, c'est pour ne pas bloquer tant que la méthode n'est pas finie. 
        }
    }
        
        //Combat : appelle la vue de combat
        //A la fin, mise à jour xp : appelle vue xp
        //Joueur regagne un peu de sa vie : appelle vue détail perso

    /***
     * Check if it's the end of the fight. Fight stop when the player
     * OR bad guys is/are dead.
     * @param player the player
     * @param allBadGuys a list of bad guys (one or many)
     * @return true if player life equal 0. true if all bad guys life equal 0. false if the player is alive and at least one of the bad guys is alive
     */
    private boolean theFightIsOver(Personnage player, List<Personnage> allBadGuys) {
        if(player.getActualLife() == 0) {
            return true;
        }
        
        for(Personnage aBadGuy : allBadGuys) {
            if(aBadGuy.getActualLife() == 0) {
                
            } else {
                return true;
            }
        }
        return false;
    }    
}
