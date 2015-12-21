package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public String getName(){
        return this.name;
    }
}
