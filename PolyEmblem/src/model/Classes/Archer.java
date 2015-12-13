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
public class Archer extends model.Character{
    public static int BASIC_STRENGHT = 1;
    public static int BASIC_HEALTH = 15;
    public static int BASIC_DEXTIRITY = 2;
    public static int BASIC_DEFENCE = 3;
    
    public Archer(String name, int maxWeight, int maxHealth, int maxDext, model.Characteristics characteristics){
        super(name,maxWeight,maxHealth,maxDext);
        this.setCharacteristics(characteristics);
    }
    
    @Override
    protected void setCharacteristics(){
        this.characteritics = new model.Characteristics(Thief.BASIC_STRENGHT,Thief.BASIC_HEALTH,Thief.BASIC_DEXTIRITY,Thief.BASIC_DEFENCE);
    }
    
    @Override
    protected void setCharacteristics(model.Characteristics characteristics){
        this.characteritics = characteristics;
    }
    
}
