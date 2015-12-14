package model.Item;

import java.util.Map;
import model.Items;

public class weaponItems extends Items {
    
    private int damage;
    private int heal;

    public weaponItems(String name, int weight, int damage, int heal) {
        super(name, weight, null);
        this.damage = damage;
        this.heal = heal;
    }
    
}
