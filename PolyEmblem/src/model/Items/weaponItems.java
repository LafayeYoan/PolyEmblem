package model.Items;

import java.util.Map;
import model.Item;

public class WeaponItems extends Item {
    
    private int damage;
    private int heal;

    public WeaponItems(String name, int weight, int damage, int heal) {
        super(name, weight, null);
        this.damage = damage;
        this.heal = heal;
    }
    
}
