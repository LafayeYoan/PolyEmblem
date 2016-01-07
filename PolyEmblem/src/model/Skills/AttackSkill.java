package model.Skills;

import java.util.List;
import java.util.Random;
import model.Skill;
import model.Personnage;
import model.Effect;

public class AttackSkill implements Skill {

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
            int damages = 0;
            if(weapon!= null){
                //on calcul les degats de l'arme 
                damages += weapon.getDamage();                
            }
            //On ajoute les degats de force
            damages += srcCharacter.getCharacteritics().getOrDefault(model.Characteristic.STRENGHT,0);
            
            
            //on retire les effets d'armure
            model.Items.ArmorItem armor = p.getArmor();
            if(armor!= null){
                //on reduit les dégats par la protection
                damages -= armor.getProtection();
            }
            
            //test d'esquive
            Random d = new Random();
            double dext = p.getCharacteritics().get(model.Characteristic.DEXTIRITY)*2/100;
            if(d.nextFloat() > dext){
                //le personnage a esquivé
                System.out.println("Le personnage "+p.getName()+" esquive !");
                continue;
           
            }
            //on applique l'effet
            p.applicateEffect(new Effect(model.Characteristic.LIFE, -damages,1));
            
        }
        return null;
        
    }

    @Override
    public double successProbability(Personnage srcCharacter) {
        return 0.80;
    }

    @Override
    public String getName() {
        return "Attaque";
    }
    
}
