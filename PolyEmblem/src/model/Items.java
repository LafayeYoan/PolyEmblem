package model;

import java.util.HashMap;
import java.util.Map;

public class Items {
    
    private String name;
    private int weight; 
    private Map allEffects;
    
    public Items(String name, int weight, Map allEffects) {
        this.name = name; 
        this.weight = weight;
        this.allEffects = new HashMap();
        this.allEffects.putAll(allEffects);
    }
    
    private int getValueEffect(Characteristics characteristicEffect) {
        //TODO
        return 0;
    }
    
    private Items addEffect(Characteristics effectToAdd) {
        //TODO
        return this;
    }
}
