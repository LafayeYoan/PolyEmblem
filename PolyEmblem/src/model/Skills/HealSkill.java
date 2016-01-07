package model.Skills;

import java.util.List;
import java.util.Random;
import model.Skill;
import model.Personnage;
import model.Effect;

public class HealSkill implements Skill {

    @Override
    public Effect[] useAbility(Personnage srcCharacter, List<Personnage> targetCharacter) {
        model.Items.WeaponItem weapon = srcCharacter.getWeapon();
        
        for(Personnage p:targetCharacter){
            //test si l'action est success
            if(Math.random() > this.successProbability(srcCharacter)){
                //on saute ce personnage, l'attaque a ratée
                continue;
            }
            int heal = 0;
            if(weapon!= null){
                //on calcul le soin de l'arme 
                heal += weapon.getHeal();                
            }
            
            //on applique l'effet
            p.applicateEffect(new Effect(model.Characteristic.LIFE, heal,1));
            
        }
        return null;
    }

    @Override
    public double successProbability(Personnage srcCharacter) {
        return  0.8;
    }

    @Override
    public String getName() {
        return "Soin";
    }
    
}
