package model.Items;

import java.util.Map;
import model.Item;

public class ArmorItems extends Item {
    
    private int protection;

    public ArmorItems(String name, int weight, int protection) {
        super(name, weight, null);
        this.protection = protection;
    }
    
}
