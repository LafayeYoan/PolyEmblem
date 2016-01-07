package model;

import java.util.ArrayList;
import java.util.List;

public class Item {
    
    private String name;
    private int weight; 
    private List<Effect> allEffects;
    public boolean equiped;
    
    public Item(String name, int weight, Effect... effects) {
        this.name = name; 
        this.weight = weight;
        this.allEffects = new ArrayList();
        for (int i = 0; i < effects.length; i++) {
            this.allEffects.add(effects[i]);
        }
        equiped = false;
    }
    
    private int getValueEffect(Characteristic characteristicEffect) {
        //TODO
        return 0;
    }
    
    private Item addEffect(Characteristic effectToAdd) {
        //TODO
        return this;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        String effectString = "";
        for (Effect anEffect : allEffects) {
            effectString = effectString + "\n >> " + anEffect.toString();
        }
        
        return  name.toUpperCase() + " : " 
                + "\n POIDS : " + weight + " g"
                + "\n EFFETS : " + effectString;
    }

    public int getWeight() {
        return weight;
    }
    
}
