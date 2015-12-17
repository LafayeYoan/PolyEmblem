package model;


public class Effect {
    
    private Characteristic characteristicEffect;
    private int value;
    private int permanent;  // -1 est permanent (à chaque tours), 0 ataque unique, 1,2,3... noubre de tour d'effet
    
    public Effect(Characteristic characteristicEffect, int value, int permanent) {
        this.characteristicEffect = characteristicEffect;
        this.value = value;
    }

    public Characteristic getCharacteristicEffect() {
        return characteristicEffect;
    }

    public int getValue() {
        return value;
    }
    
    public void decrementPermanent(){
        this.permanent--;
    }

    public int getPermanent() {
        return permanent;
    }
    
    
}
