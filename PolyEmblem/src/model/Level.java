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
    
    private int getStep(){
        return 400;
    }
}
