package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Item.armorItems;
import model.Item.weaponItems;

public abstract class Character { 
    
    private static final int MAX_NUMBER_OF_WEAPONS = 2;
    
    private String name;
    private Level level;
    private int maxWeight;
    private int maxHealth;
    private int maxDext;
    private Map allItems;
    private weaponItems[] weapons;
    private armorItems armor;
    
    protected Characteristics characteritics;
    protected List<Skill> skills;

    public Character(String name,Level level, int maxWeight, int maxHealth, int maxDext) {
        this.name = name;
        this.level = level;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDext = maxDext;
        this.allItems = new HashMap();
        this.weapons = new weaponItems[MAX_NUMBER_OF_WEAPONS];
        this.armor = null;
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
