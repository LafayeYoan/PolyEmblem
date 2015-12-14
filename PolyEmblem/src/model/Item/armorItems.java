package model.Item;

import java.util.Map;
import model.Items;

public class ArmorItems extends Items {
    
    private int protection;

    public ArmorItems(String name, int weight, int protection) {
        super(name, weight, null);
        this.protection = protection;
    }
    
}
