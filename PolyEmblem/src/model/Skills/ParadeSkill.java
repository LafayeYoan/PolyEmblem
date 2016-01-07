package model.Skills;

import java.util.List;
import java.util.Random;
import model.Skill;
import model.Personnage;
import model.Effect;

public class ParadeSkill implements Skill {

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

    @Override
    public double successProbability(Personnage srcCharacter) {
        return 1;
    }

    @Override
    public String getName() {
        return "Parade";
    }
 
}