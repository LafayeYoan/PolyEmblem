package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Level;

public class Mam extends model.Personnage{
    public static int BASIC_STRENGHT = 2;
    public static int BASIC_HEALTH = 20;
    public static int BASIC_DEXTIRITY = 10;
    public static int BASIC_DEFENCE = 2;
    public static int BASIC_INTELIGENCE = 15;
    
    public Mam(String name){
        super(name);
    }
    
    public Mam(String name, Level level){
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
        return "MAM";
    }
    
}
