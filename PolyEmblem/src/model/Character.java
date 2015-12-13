/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;

/**
 *
 * @author p1504274
 */
public abstract class Character {    
    private String name;
    private Level level;
    private int maxWeight;
    private int maxHealth;
    private int maxDext;
    protected Characteristics characteritics;
    protected List<Skill> skills;

    public Character(String name,Level level, int maxWeight, int maxHealth, int maxDext) {
        this.name = name;
        this.level = level;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDext = maxDext;
        this.characteritics = new Characteristics();
    }

    public Character(String name, int maxWeight, int maxHealth, int maxDext) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDext = maxDext;
        this.level = new Level();
        this.characteritics = new Characteristics();
    }
    
    protected abstract void setCharacteristics();
    protected abstract void setCharacteristics(Characteristics characteristics);
    
    

    
    
    
    
}
