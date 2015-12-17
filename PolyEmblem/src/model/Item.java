package model;

import java.util.HashMap;
import java.util.Map;

public class Item {
    
    private String name;
    private int weight; 
    private Map allEffects;
    
    public Item(String name, int weight, Map allEffects) {
        this.name = name; 
        this.weight = weight;
        this.allEffects = new HashMap();
        this.allEffects.putAll(allEffects);
    }
    
    private int getValueEffect(Characteristic characteristicEffect) {
        //TODO
        return 0;
    }
    
    private Item addEffect(Characteristic effectToAdd) {
        //TODO
        return this;
    }
}
