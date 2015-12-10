/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author p1504274
 */
public class Character {
    private String name;
    private Level level;
    private int maxWeight;
    private int maxHealth;
    private int maxDext;

    public Character(String name,Level level, int maxWeight, int maxHealth, int maxDext) {
        this.name = name;
        this.level = level;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDext = maxDext;
    }

    public Character(String name, int maxWeight, int maxHealth, int maxDext) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDext = maxDext;
        this.level = new Level();
    }
    
    

    
    
    
    
}
