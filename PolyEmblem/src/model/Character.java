package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Items.ArmorItem;
import model.Items.WeaponItem;

public abstract class Character { 
    
    private static final int MAX_NUMBER_OF_WEAPONS = 2;
    
    private String name;
    private Level level;
    private int maxWeight;
    private int maxHealth;
    private int maxDext;
    private Map <Integer,Item> allItems;
    private WeaponItem[] weapons;
    private ArmorItem armor;
    
    protected Map<Characteristic, Integer> characteritics;
    protected List<Skill> skills;

    public Character(String name,Level level, int maxWeight, int maxHealth, int maxDext) {
        this.name = name;
        this.level = level;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDext = maxDext;
        this.allItems = new HashMap<>();
        this.weapons = new WeaponItem[MAX_NUMBER_OF_WEAPONS];
        this.armor = null;
        this.initCharacteristics();
    }

    public Character(String name, int maxWeight, int maxHealth, int maxDext) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.maxDext = maxDext;
        this.level = new Level();
        this.initCharacteristics();
    }
    
    protected abstract void initCharacteristics();
    
    
    public void putEffect(Effect effect){
        
    }
    
    public void equuipWeapon(model.Items.WeaponItem weaponItem){
        
    }
    
}
