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
public class Characteristics {
    private int strength;
    private int health;
    private int dextirity;
    private int defence;
    

    public Characteristics(int strength, int health, int dextirity, int defence) {
        this.strength = strength;
        this.health = health;
        this.dextirity = dextirity;
        this.defence = defence;
    }
    
    public Characteristics(){
        this.strength = 0;
        this.health = 0;
        this.dextirity = 0;
        this.defence = 0;
    }
    
    
}
