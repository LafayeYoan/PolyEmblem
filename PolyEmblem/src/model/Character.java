
package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.Items.ArmorItem;
import model.Items.WeaponItem;

public abstract class Character {     
    private String name;
    private Level level;
    private int maxWeight;
    private int maxHealth;
    
    private int actualLife;
    
    private List<Item> allItems;
    private WeaponItem weapon;
    private ArmorItem armor;
    
    protected Map<Characteristic, Integer> characteritics;
    protected List<Skill> skills;
    private List<Effect> effects;

    public Character(String name, Level level, int maxWeight, int maxHealth) {
        this.name = name;
        this.level = level;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.allItems = new LinkedList<>();
        this.weapon = null;
        this.armor = null;
        this.initCharacteristics();
        this.actualLife = this.calcMaxHealth();
    }

    public Character(String name, int maxWeight, int maxHealth) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.maxHealth = maxHealth;
        this.level = new Level();
        this.initCharacteristics();
        this.actualLife = this.calcMaxHealth();
        
    }
    
    protected abstract void initCharacteristics();
    
    
    public void addEffect(Effect effect){
        this.effects.add(effect);
    }
    
    public void runEffects(){
        for(Effect e: this.effects)
        {
            this.applicateEffect(e);
        }
    }
    
    public void applicateEffect(Effect e){
        if(Characteristic.LIFE.equals(e.getCharacteristicEffect())){
            
        }
    }
    
    public void removeItem(Item item){
        if(allItems.contains(item)) {
            if(item==this.weapon){
                unequipWeapon();
            }
            else if(item==this.armor)
                unequipArmor();
            allItems.remove(item);
        }    
    }
    
    public void equipWeapon(model.Items.WeaponItem weaponItem){
        if(!this.weapon.equals(null)){
            unequipWeapon();
        }
        //equiper
        this.weapon = weaponItem;
        //code pour les effets de l'arme
    }
   
    public void unequipWeapon(){
        //enlever effet
        this.weapon=null;
    }
    
    public void equipArmor(model.Items.ArmorItem armorItem){
        if(!this.armor.equals(null)){
            unequipArmor();
        }
        //equiper
        this.armor = armorItem; 
        //code pour les effets de l'armure
    } 
    
     public void unequipArmor(){
         //enlever effet
         this.armor=null;
    }
    
    public int calcMaxHealth(){
        if(this.characteritics.containsKey(Characteristic.HEALTH)){
            return this.characteritics.get(Characteristic.HEALTH);
        }
        return 20;
    }
}
