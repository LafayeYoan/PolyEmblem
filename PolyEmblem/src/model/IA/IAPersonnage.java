/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.IA;

import java.util.List;
import model.Skill;

/**
 *
 * @author Darkos
 */
public class IAPersonnage{

    private int LEVEL_IA_MAX = 2;
    private int LEVEL_IA_MIN = 1;
    private model.Personnage personnage;
    private int levelIA;
    
    private String lastAction;
    
    public IAPersonnage(model.Personnage personnage, int levelIA) {
        this.personnage = personnage;
        if(levelIA<LEVEL_IA_MIN){
            levelIA = LEVEL_IA_MIN;
        }else if(levelIA>LEVEL_IA_MAX){
            levelIA = LEVEL_IA_MAX;
        }else{
            this.levelIA = levelIA;
        }        
    }
    
    public model.Skill getSkill(){
        model.Skills.AttackSkill attack = null;
        model.Skills.HealSkill heal = null;
        
        List<Skill> skills  = this.personnage.getSkills();
        for(Skill s:skills){
            if(s instanceof model.Skills.AttackSkill){
                attack = (model.Skills.AttackSkill)s;
            }
            
            if(s instanceof model.Skills.HealSkill){
                heal = (model.Skills.HealSkill)s;
            }
        }
        
        if(levelIA == 1){
            return attack;
        }
        
        if(levelIA == 2){
            if (personnage.getActualLife()> personnage.getMaxHealth()/2){
                lastAction = "heal";
                return heal;
            }
            else{
                return attack;
            }
        }
        return null;
    }
    
    public model.Personnage getTarget(List<model.Personnage> potentialTarget, List <IAPersonnage> IAs){
        //si on heal
        if(this.lastAction == "heal"){
            lastAction = "";
            model.Personnage target = IAs.get(0).personnage;
            for(IAPersonnage ia : IAs){
                if(target.getActualLife()> ia.personnage.getActualLife()){
                    target = ia.personnage;
                }
            }
            return target;
        }
    
        //choisis de maniere random
        if(levelIA == 1){
            double random = (Math.random()*potentialTarget.size());
            return potentialTarget.get((int)random);            
        }
        //choisi de maniere inteligente
        if(levelIA == 2){
            model.Personnage target = potentialTarget.get(0);
            for(model.Personnage p : potentialTarget){
                if(target.getActualLife()> p.getActualLife()){
                    target = p;
                }
            }
            return target;
        }
        return null;
    }
    
    public model.Personnage getPersonnage(){
        return personnage;
    }
}

