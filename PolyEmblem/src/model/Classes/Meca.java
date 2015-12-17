/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Classes;

import java.util.HashMap;
import model.Characteristic;

/**
 *
 * @author Darkos
 */
public class Meca extends model.Character{
    public static int BASIC_STRENGHT = 1;
    public static int BASIC_HEALTH = 20;
    public static int BASIC_DEXTIRITY = 1;
    public static int BASIC_DEFENCE = 1;
    public static int BASIC_INTELIGENCE = 1;
    
    public Meca(String name, int maxWeight, int maxHealth, int maxDext){
        super(name,maxWeight,maxHealth,maxDext);
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
}
