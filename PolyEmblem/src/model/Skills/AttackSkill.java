package model.Skills;

import model.Skill;
import model.Personnage;
import model.Effect;

/**
 * Attack skill
 * @author Lafaye, Lhopital, Paccaud
 */
public class AttackSkill implements Skill {

    /**
     * Attack !
     * @param srcCharacter the character who attack
     * @param targetCharacter the target
     * @return an effects table
     */
    @Override
    public Effect[] useAbility(Personnage srcCharacter, Personnage targetCharacter) {
        model.Items.WeaponItem weapon = srcCharacter.getWeapon();
            
            //Test si c'est un Mat fatigué
            if(srcCharacter instanceof model.Classes.Mat){
                model.Classes.Mat m = (model.Classes.Mat)srcCharacter;
                if(m.isTired()){
                    m.setTired(false);
                    System.out.println("\n----------------------------------------");
                    System.out.println(srcCharacter.getName()+ " est fatigué !");
                    System.out.println("----------------------------------------");
                    return null;
                }
                m.setTired(true);
            }
        
            //test si l'action est success
            if(Math.random() > this.successProbability(srcCharacter)){
                //on saute ce personnage, l'attaque a ratée
                System.out.println("\n----------------------------------------");
                System.out.println(srcCharacter.getName()+ " a fait un échec critique !");
                System.out.println("----------------------------------------");
                return null;
            }
            int damages = 0;
            if(weapon!= null){
                //on calcul les degats de l'arme 
                damages += weapon.getDamage();                
            }
            //On ajoute les degats de force
            damages += srcCharacter.getCharacteritics().getOrDefault(model.Characteristic.STRENGHT,0);
            
            //On reduit les degat de la defence
            damages -= targetCharacter.getCharacteritics().getOrDefault(model.Characteristic.DEFENCE,0);
           
            
            //on retire les effets d'armure
            model.Items.ArmorItem armor = targetCharacter.getArmor();
            if(armor!= null){
                //on reduit les dégats par la protection
                damages -= armor.getProtection();
            }
            
            //On évite les dégats négatifs...
            if(damages<1)
                damages = 1;
            
            //test d'esquive
            double dext = targetCharacter.getCharacteritics().get(model.Characteristic.DEXTIRITY)*0.02;
            if(Math.random() < dext){
                //le personnage a esquivé
                System.out.println("\n----------------------------------------");
                System.out.println(targetCharacter.getName()+" esquive !");
                System.out.println("----------------------------------------");
                return null;
           
            }
            //on applique l'effet
            targetCharacter.applicateEffect(new Effect(model.Characteristic.LIFE, -damages,1));
            
        return null;
        
    }

    /**
     * Counting the success probability of the attack
     * @param srcCharacter the character who attack
     * @return the success probability
     */
    @Override
    public double successProbability(Personnage srcCharacter) {
        return 0.9;
    }

    /**
     * Get the skill name
     * @return "Attaque"
     */
    @Override
    public String getName() {
        return "Attaque";
    }
    
}
