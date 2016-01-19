package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Level;

/**
 * Character class : MECA 
 * @author Lafaye, Lhopital, Paccaud
 */
public class Meca extends model.Personnage{

    public static int BASIC_STRENGHT = 14;
    public static int BASIC_HEALTH = 100;
    public static int BASIC_DEXTIRITY = 12;
    public static int BASIC_DEFENCE = 2;
    public static int BASIC_INTELIGENCE = 10;
    
    /**
     * Constructor for player
     * @param name the name of the character
     */
    public Meca(String name){
        super(name);
    }
    
    /**
     * Constuctor for PNJ
     * @param name the name of the character
     * @param level the level of the character
     */
    public Meca(String name, Level level){
        super(name, level);
    }
    
    /**
     * Initialize characteristics of the MECA
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
     * Get class Name
     * @return "MECA"
     */
    @Override
    public String getClassName() {
        return "MECA";
    }
}
