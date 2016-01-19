package model.Skills;

import model.Skill;
import model.Personnage;
import model.Effect;

/**
 * Heal skill
 * @author Lafaye, Lhopital, Paccaud
 */
public class HealSkill implements Skill {

    /**
     * Heal 
     * @param srcCharacter the character who heal
     * @param targetCharacter the target of the heal
     * @return an effects table 
     */
    @Override
    public Effect[] useAbility(Personnage srcCharacter, Personnage targetCharacter) {
        model.Items.WeaponItem weapon = srcCharacter.getWeapon();
        
            //test si l'action est success
            if(Math.random() > this.successProbability(srcCharacter)){
                //on saute ce personnage, l'attaque a ratée
                return null;
            }
            int heal = 0;
            if(weapon!= null){
                //on calcul le soin de l'arme 
                heal += weapon.getHeal();                
            }
            
            //on applique l'effet
            targetCharacter.applicateEffect(new Effect(model.Characteristic.LIFE, heal,1));
        return null;
    }

    /**
     * Counting the success probability for heal
     * @param srcCharacter the character who heal
     * @return the success probability
     */
    @Override
    public double successProbability(Personnage srcCharacter) {
        return  0.8;
    }

    /**
     * Get the skill name
     * @return "Soin"
     */
    @Override
    public String getName() {
        return "Soin";
    }
    
}
