
package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import model.Items.ArmorItem;
import model.Items.WeaponItem;

public abstract class Personnage {  
    
    public static final int MAX_WEIGHT = 100;  

        public enum Classes{
            GBM,
            INFO,
            MAM,
            MAT,
            MECA,
        }
    
    private String name;
    private Level level;
    private int maxHealth;
    
    private int actualLife;
    private int actualInUseWeight;
    
    private List<Item> allItems;
    private WeaponItem weapon;
    private ArmorItem armor;
    
    protected Map<Characteristic, Integer> characteritics;
    protected List<Skill> skills;
    private List<Effect> effects;

    public Personnage(String name, Level level) {
        this.name = name;
        this.level = level;
        
        this.initCharacteristics();
        this.initSkills();
     
        this.maxHealth = calcMaxHealth();
        this.allItems = new LinkedList<>();
        this.weapon = null;
        this.armor = null;
        this.actualLife = this.calcMaxHealth();
        this.actualInUseWeight = 0;
    }

    public Personnage(String name) {
        this.name = name;
        //this.maxWeight = maxWeight;
        this.level = new Level();
        
        this.initCharacteristics();
        this.initSkills();
        
        this.maxHealth = calcMaxHealth();
        this.allItems = new LinkedList<>();
        this.level = new Level();
        this.actualLife = this.calcMaxHealth();
        this.maxHealth = calcMaxHealth();
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
        if(e.getCharacteristicEffect().equals(model.Characteristic.LIFE)){
            this.actualLife += e.getValue();
        }else{
           this.characteritics.replace(e.getCharacteristicEffect(), e.getValue() + this.characteritics.getOrDefault(e.getCharacteristicEffect(),0));
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
    
    public void addItem(Item item) {
        allItems.add(item);
        actualInUseWeight = actualInUseWeight + item.getWeight();
    }
    
    public void equipWeapon(model.Items.WeaponItem weaponItem){
        if(this.weapon != null){
            unequipWeapon();
        }
        //equiper
        this.weapon = weaponItem;
        this.weapon.equiped = true;
        //code pour les effets de l'arme
    }
   
    public void unequipWeapon(){
        //enlever effet
        this.weapon.equiped = false;
        this.weapon=null;
    }
    
    public void equipArmor(model.Items.ArmorItem armorItem){
        if(this.armor != null){
            unequipArmor();
        }
        //equiper
        this.armor = armorItem; 
        this.armor.equiped = true;
        //code pour les effets de l'armure
    } 
    
     public void unequipArmor(){
         //enlever effet
         this.armor.equiped = false;
         this.armor = null;
    }
    
    private int calcMaxHealth(){
        if(this.characteritics.containsKey(Characteristic.HEALTH)){
            return this.characteritics.get(Characteristic.HEALTH);
        }
        return 20;
    }
    
    public void initSkills(){
        this.skills = new LinkedList<>();
        this.skills.add(new model.Skills.AttackSkill());
        this.skills.add(new model.Skills.HealSkill());
        this.skills.add(new model.Skills.ParadeSkill());
    }
    
    public List<Skill> getSkills(){
        return this.skills;
    }
    
    public int getActualInUseWeight() {
        return actualInUseWeight;
    }
    
    public String getName() {
        return name;
    }

    public List<Item> getItems(){
        return this.allItems;
    }

    public Level getLevel() {
        return level;
    }

    /***
     * Return the current life of the character. 0 if he is dead.
     * @return the current life of the character
     */
    public int getActualLife() {
        return actualLife;
    }
    
    public int getMaxHealth(){
        return this.maxHealth;
    }

    public WeaponItem getWeapon() {
        return weapon;
    }

    public ArmorItem getArmor() {
        return armor;
    }

    public Map<Characteristic, Integer> getCharacteritics() {
        return characteritics;
    }
    
    public void increaseCharacteristic(model.Characteristic charac){
        int val  = this.characteritics.getOrDefault(charac, 0);
        this.characteritics.replace(charac, val+1);
    }

    public List<Effect> getEffects() {
        return effects;
    }
    
    public abstract String getClassName();
    
    public String getBasicDescription(){
        String description = "";
        
        description += "Nom: " + this.name + "\n";
        description += "Classe: " + this.getClassName() + "\n";
        description += "Vie: " + this.actualLife + "/" + this.maxHealth + "\n"; 
        description += "Niveau: " + level.getLevelValue() + "\n";
        
        return description;
    }
}
