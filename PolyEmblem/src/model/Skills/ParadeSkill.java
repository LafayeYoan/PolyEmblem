package model.Skills;

import java.util.List;
import java.util.Random;
import model.Skill;
import model.Personnage;
import model.Effect;

public class ParadeSkill implements Skill {

    @Override
    public Effect[] useAbility(Personnage srcCharacter, List<Personnage> targetCharacter) {
         for(Personnage p:targetCharacter){
            //test si l'action est success
            //EDIT : pour l'instant impoossible de raté
            Random r = new Random();
            if(r.nextFloat() > this.successProbability(srcCharacter)){
                //on saute ce personnage, la parade a ratée
                continue;
            }
            //on prend sa valeur d'armure de base pour lui ajouter un bonus
            int bonusDef = p.getCharacteritics().get(model.Characteristic.DEFENCE)*2;
            
            //on applique l'effet
            p.applicateEffect(new Effect(model.Characteristic.DEFENCE, bonusDef,1));
        }
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