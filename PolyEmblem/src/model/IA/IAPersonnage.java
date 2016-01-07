/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.IA;

/**
 *
 * @author Darkos
 */
public class IAPersonnage{

    private int LEVEL_IA_MAX = 3;
    private int LEVEL_IA_MIN = 1;
    private model.Personnage personnage;
    private int levelIA;
    public IAPersonnage(model.Personnage personnnage, int levelIA) {
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
        return null;
    }
}
