package controller;

import java.util.List;
import model.Personnage;
import model.Skill;
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
                if(isDead(player)) {
                    //Afficher la vue de fin de partie (la partie est perdu !)
                } else {
                    playerTurn.displayEndFight();
                    //A la fin, mise à jour xp : appelle vue xp
                    //Joueur regagne un peu de sa vie : appelle vue détail perso
                }                
                break;
            }            
            
            if(isPlayerTurn) {
                playerTurn.loadHUD();
                Skill skillToUse = (Skill) playerTurn.getResponse();
                skillToUse.useAbility(player, allBadGuys);
                //Tour du joueur
                isPlayerTurn = false;
            } else {
                //Tour IA
            }
            
            break; //To remove, c'est pour ne pas bloquer tant que la méthode n'est pas finie. 
        }
    }        

    /***
     * Check if it's the end of the fight. Fight stop when the player
     * OR bad guys is/are dead.
     * @param player the player
     * @param allBadGuys a list of bad guys (one or many)
     * @return true if player life equal 0. true if all bad guys life equal 0. false if the player is alive and at least one of the bad guys is alive
     */
    private boolean theFightIsOver(Personnage player, List<Personnage> allBadGuys) {
        
        if(isDead(player)) { 
            return true;
        }
        
        for(Personnage aBadGuy : allBadGuys) {
            if(isDead(aBadGuy)) {
                
            } else {
                return false;
            }
        }
        return true;
    }    
    
    /***
     * Check if the personnage is dead
     * @param player the personnage you want to check the health
     * @return true if the player life equal 0. False otherwise.
     */
    private boolean isDead(Personnage player) {
        return (player.getActualLife() <= 0);
    }
}
