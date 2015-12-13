/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Classes;

/**
 *
 * @author Darkos
 */
public class Warrior extends model.Character{
    public static int BASIC_STRENGHT = 3;
    public static int BASIC_HEALTH = 20;
    public static int BASIC_DEXTIRITY = 1;
    public static int BASIC_DEFENCE = 1;
    
    public Warrior(String name, int maxWeight, int maxHealth, int maxDext, model.Characteristics characteristics){
        super(name,maxWeight,maxHealth,maxDext);
        this.setCharacteristics(characteristics);
    }
    
    @Override
    protected void setCharacteristics(){
        this.characteritics = new model.Characteristics(Warrior.BASIC_STRENGHT,Warrior.BASIC_HEALTH,Warrior.BASIC_DEXTIRITY,Warrior.BASIC_DEFENCE);
    }
    
    @Override
    protected void setCharacteristics(model.Characteristics characteristics){
        this.characteritics = characteristics;
    }
}
