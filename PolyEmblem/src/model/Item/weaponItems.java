package model.Item;

import java.util.Map;
import model.Items;

public class WeaponItems extends Items {
    
    private int damage;
    private int heal;

    public WeaponItems(String name, int weight, int damage, int heal) {
        super(name, weight, null);
        this.damage = damage;
        this.heal = heal;
    }
    
}
