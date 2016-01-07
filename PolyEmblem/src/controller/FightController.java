package controller;

import java.util.List;
import model.IA.IAPersonnage;
import model.Personnage;
import model.Skill;
import view.EndOfGameView;
import view.Fight.CombatActionChoiceView;
import view.Fight.CombatOpponentChoiceView;
import view.Fight.RoundView;

/**
 *
 * @author lhopital
 */
public class FightController {

    /***
     * Run the Fight between player and all bad guys.
     * Call the correct view for each action.
     * @param allPlayers a list of all players who will fight (one or many)
     * @param allBadGuys a list of bad guys (one or many)
     */
    public void runTheFight(List<Personnage> allPlayers, List<IAPersonnage> allBadGuys) {
        boolean isPlayerTurn = true;
        CombatActionChoiceView fightChoice;
        CombatOpponentChoiceView opponentChoice;
        
        while(true) {
            int fightResult = theFightIsOver(allPlayers, allBadGuys);
            
            if(fightResult == 1) { /* Player loose */
                EndOfGameView.loadLooserEnding();
                break;
            } else if(fightResult == -1){ /* Player win */
                //TODO
                //Dire que que joueur a gagné
                //A la fin, mise à jour xp : appelle vue xp
                //Joueur regagne un peu de sa vie : appelle vue détail perso
                break;
            }                
            
            for(Personnage p: allPlayers){
                opponentChoice = new CombatOpponentChoiceView(p, allBadGuys);
                opponentChoice.loadHUD();
                Personnage badGuy = opponentChoice.getResponse();

                fightChoice = new CombatActionChoiceView(p);
                fightChoice.loadHUD();
                Skill skillToUse = fightChoice.getResponse();
                skillToUse.useAbility(p, badGuy);
                
                if(badGuy.getActualLife()<= 0){
                    allBadGuys.remove(badGuy);
                    if(theFightIsOver(allPlayers, allBadGuys)==-1){
                        //player win
                        break;
                    }
                }
            }
            
            for(IAPersonnage aBadGuy: allBadGuys){
                Skill skillToUse = aBadGuy.getSkill();
                Personnage perso = aBadGuy.getTarget(allPlayers, allBadGuys);                
                skillToUse.useAbility(aBadGuy.getPersonnage(), perso);
                RoundView.IAAttackDisplay(aBadGuy, perso);
                
                if(perso.getActualLife()<= 0){
                    allPlayers.remove(perso);
                    if(theFightIsOver(allPlayers, allBadGuys)==1){
                        //IA win
                        break;
                    }
                }
            }
            
            RoundView roundView = new RoundView(allPlayers, allBadGuys);
            roundView.loadHUD();
        }
    }        

    /***
     * Check if it's the end of the fight. Fight stop when the player
     * OR bad guys is/are dead.
     * @param allPlayers a list of all players who fight (one or many)
     * @param allBadGuys a list of bad guys (one or many)
     * @return 1 if player life equal 0. -1 if all bad guys life equal 0. 0 if one player is alive and at least one of the bad guys is alive
     */
    private int theFightIsOver(List<Personnage> allPlayers, List<IAPersonnage> allBadGuys) {
        
        boolean onePlayerAlive = false;
        boolean oneBadGuyAlive = false;
        for(Personnage p: allPlayers){
            if(!isDead(p)){
                onePlayerAlive = true;
                break;
            }
        }
        
        if(!onePlayerAlive){
            return 1;
        }
        
        for(IAPersonnage aBadGuy : allBadGuys) {
            if(!isDead(aBadGuy.getPersonnage())) {
                oneBadGuyAlive = true;
                break;
            }
        }       
        if(!oneBadGuyAlive){
            return -1;
        }
        return 0;
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
