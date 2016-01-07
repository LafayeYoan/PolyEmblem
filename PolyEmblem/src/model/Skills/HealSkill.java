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
            Random r = new Random();
            if(r.nextFloat() > this.successProbability(srcCharacter)){
                //on saute ce personnage, l'attaque a ratée
                continue;
            }
            int heal = 0;
            if(weapon!= null){
                //on calcul le soin de l'arme 
                heal += weapon.getHeal();                
            }
            //On ajoute l'inteligence
            heal += srcCharacter.getCharacteritics().getOrDefault(model.Characteristic.INTELIGENCE,0);
            
            //on applique l'effet
            p.applicateEffect(new Effect(model.Characteristic.LIFE, heal,0));
            
        }
        return null;
    }

    @Override
    public double successProbability(Personnage srcCharacter) {
        return  0.85;
    }

    @Override
    public String getName() {
        return "Soin";
    }
    
}
