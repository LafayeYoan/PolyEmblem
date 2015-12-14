package model;


public class Effect {
    
    private Characteristic characteristicEffect;
    private int value;
    private int permanent;  //WHAT IS IT FOR ???
    
    public Effect(Characteristic characteristicEffect, int value) {
        this.characteristicEffect = characteristicEffect;
        this.value = value;
    }
}
