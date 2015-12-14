package model.Item;

import java.util.Map;
import model.Items;

public class armorItems extends Items {
    
    private int protection;

    public armorItems(String name, int weight, int protection) {
        super(name, weight, null);
        this.protection = protection;
    }
    
}
