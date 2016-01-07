package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Level;

public class Gbm extends model.Personnage{
    public static int BASIC_STRENGHT = 1;
    public static int BASIC_HEALTH = 25;
    public static int BASIC_DEXTIRITY = 10;
    public static int BASIC_DEFENCE = 3;
    public static int BASIC_INTELIGENCE = 10;
    
    public Gbm(String name){
        super(name);
    }
    
    public Gbm(String name, Level level){
        super(name, level);
    }

    @Override
    protected void initCharacteristics() {
        this.characteritics=new HashMap<>();
        this.characteritics.put(Characteristic.HEALTH, BASIC_HEALTH);
        this.characteritics.put(Characteristic.STRENGHT, BASIC_STRENGHT);
        this.characteritics.put(Characteristic.DEXTIRITY, BASIC_DEXTIRITY);
        this.characteritics.put(Characteristic.DEFENCE, BASIC_DEFENCE);
        this.characteritics.put(Characteristic.INTELIGENCE, BASIC_INTELIGENCE);
    }

    @Override
    public String getClassName() {
        return "GBM";
    }

}
