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
public class Info extends model.Character{
    public static int BASIC_STRENGHT = 1;
    public static int BASIC_HEALTH = 15;
    public static int BASIC_DEXTIRITY = 3;
    public static int BASIC_DEFENCE = 2;
    
    public Info(String name, int maxWeight, int maxHealth, int maxDext, model.Characteristics characteristics){
        super(name,maxWeight,maxHealth,maxDext);
        this.setCharacteristics(characteristics);
    }
    
    @Override
    protected void setCharacteristics(){
        this.characteritics = new model.Characteristics(Info.BASIC_STRENGHT,Info.BASIC_HEALTH,Info.BASIC_DEXTIRITY,Info.BASIC_DEFENCE);
    }
    
    @Override
    protected void setCharacteristics(model.Characteristics characteristics){
        this.characteritics = characteristics;
    }
}
