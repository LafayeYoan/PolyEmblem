package model.Items;

import model.Characteristic;
import model.Effect;
import model.Item;

public class ArmorItem extends Item {
    
    private final int protection;

    public ArmorItem(String name, int weight, int protection) {
        super(name, weight, new Effect(Characteristic.DEFENCE, protection, -1));
        this.protection = protection;
    }
    
    public int getProtection(){
        return this.protection;
    }
    
}
