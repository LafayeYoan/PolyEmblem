package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Level;

/**
 * Character class : MAT. 
 * @author Lafaye, Lhopital, Paccaud
 */
public class Mat extends model.Personnage{

    public static int BASIC_STRENGHT = 7;
    public static int BASIC_HEALTH = 20;
    public static int BASIC_DEXTIRITY = 1;
    public static int BASIC_DEFENCE = 4;
    public static int BASIC_INTELIGENCE = 1;
    
    private boolean tired;
    
    /**
     * Constructor for player
     * @param name the character name
     */
    public Mat(String name){
        super(name);
        tired = false;
    }
    
    /**
     * Constructor for PNJ
     * @param name the name of the character
     * @param level the level of the character
     */
    public Mat(String name, Level level){
        super(name, level);
    }

    /**
     * Initialize characteristics of the MAT
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
     * @return "MAT"
     */
    @Override
    public String getClassName() {
        return "MAT";
    }
    
    /**
     * To balance the game, MAT can only attack a ride on two. 
     * @return true if the character can't attack - false otherwise
     */
    public boolean isTired(){
        return tired;
    }
    
    /**
     * Set tired for the next turn
     * @param tired 
     */
    public void setTired(boolean tired){
        this.tired = tired;
    }
    
}
