package model.Items;

import java.util.Map;
import model.Item;

public class ArmorItem extends Item {
    
    private int protection;

    public ArmorItem(String name, int weight, int protection) {
        super(name, weight, null);
        this.protection = protection;
    }
    
    public int getProtection(){
        return this.protection;
    }
    
}
