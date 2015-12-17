/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Darkos
 */
public class Level {
    public static int MAXLEVEL=60;
    
    private int level;
    private int exp;
    private int step;
    
    public Level(){
        this.level = 0;
        this.exp = 0;
        this.step = this.getStep();
    }
    
    public Level(int lv) {
        level = lv;
        exp = 0;
        step = 0;
    }
    
    private int getStep(){
        return this.level * 50 +50;
    }
    
    public boolean addXP(int xp){
        this.exp +=xp;
        if(this.exp>=this.step){
            this.levelUp();
            return true;
        }
        return false;
    }
    
    private void levelUp(){
        this.level++;
        this.exp = 0;
        this.step = this.getStep();
    }
    
    public int getLevelValue(){
        return this.level;
    }
    
    public int getExp(){
        return this.exp;
    }
}
