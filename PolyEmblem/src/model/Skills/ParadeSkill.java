package model.Skills;

import model.Skill;
import model.Personnage;
import model.Effect;

/**
 * Parade skill
 * @author Lafaye, Lhopital, Paccaud
 */
public class ParadeSkill implements Skill {

    /**
     * Parade
     * @param srcCharacter the character who parry
     * @param targetCharacter the target
     * @return an effects table
     */
    @Override
    public Effect[] useAbility(Personnage srcCharacter, Personnage targetCharacter) {
            //test si l'action est success
            if(Math.random() > this.successProbability(srcCharacter)){
                //on saute ce personnage, la parade a ratée
                return null;
            }
            //on prend sa valeur d'armure de base pour lui ajouter un bonus
            int bonusDef = targetCharacter.getCharacteritics().get(model.Characteristic.DEFENCE)*2;
            
            //on applique l'effet
            targetCharacter.applicateEffect(new Effect(model.Characteristic.DEFENCE, bonusDef,1));
        return null;
    }

    /**
     * Counting the success probability for parry
     * @param srcCharacter the character who parry
     * @return the success probability (For the moment : 1)
     */
    @Override
    public double successProbability(Personnage srcCharacter) {
        return 1;
    }

    /**
     * Get the skill name
     * @return "Parade"
     */
    @Override
    public String getName() {
        return "Parade";
    }
 
}