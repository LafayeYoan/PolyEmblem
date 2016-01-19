package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Level;
import model.Personnage;

/**
 * Character class : INFO 
 * @author Lafaye, Lhopital, Paccaud
 */
public class Info extends Personnage {

    public static int BASIC_STRENGHT = 5;
    public static int BASIC_HEALTH = 15;
    public static int BASIC_DEXTIRITY = 15;
    public static int BASIC_DEFENCE = 3;
    public static int BASIC_INTELIGENCE = 10;
    
    /**
     * Constructor for player
     * @param name the name of the character
     */
    public Info(String name){
        super(name);
    }
    
    /**
     * Constructor for PNJ
     * @param name the name of the character
     * @param level the level of the character
     */
    public Info(String name, Level level){
        super(name, level);
    }

    /** 
     * Initialize characteristics of the INFO
     */
    @Override
    protected void initCharacteristics() {
        this.characteritics=new HashMap<>();
        this.characteritics.put(Characteristic.HEALTH, BASIC_HEALTH);
        this.characteritics.put(Characteristic.STRENGHT, BASIC_STRENGHT);
        this.characteritics.put(Characteristic.DEXTIRITY, BASIC_DEXTIRITY);
        this.characteritics.put(Characteristic.DEFENCE, BASIC_DEFENCE);
        this.characteritics.put(Characteristic.INTELIGENCE, BASIC_INTELIGENCE);
    }

    /**
     * Get the class name 
     * @return "INFO"
     */
    @Override
    public String getClassName() {
        return "INFO";
    }
}
