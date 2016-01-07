/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Classes;

import java.util.HashMap;
import model.Characteristic;
import model.Level;

/**
 *
 * @author Darkos
 */
public class Meca extends model.Personnage{
    public static int BASIC_STRENGHT = 3;
    public static int BASIC_HEALTH = 20;
    public static int BASIC_DEXTIRITY = 15;
    public static int BASIC_DEFENCE = 2;
    public static int BASIC_INTELIGENCE = 5;
    
    public Meca(String name){
        super(name);
    }
    
    public Meca(String name, Level level){
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
        return "MECA";
    }
}
