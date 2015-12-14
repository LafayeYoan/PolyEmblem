package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Character {  
    
    private String name;
    private Level level;
    private int maxWeight;
    private int maxHealth;
    private int maxDext;
    private Map allItems;
    protected Characteristics characteritics;
    protected List<Skill> skills;

    public Character(String name,Level level, int maxWeight, int maxHealth, int maxDext) {
        this.name = name;
        this.level = level;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDext = maxDext;
        this.characteritics = new Characteristics();
        this.allItems = new HashMap();
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
