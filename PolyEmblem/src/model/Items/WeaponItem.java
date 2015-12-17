package model.Items;

import java.util.Map;
import model.Item;

public class WeaponItem extends Item {
    
    private int damage;
    private int heal;

    public WeaponItem(String name, int weight, int damage, int heal) {
        super(name, weight, null);
        this.damage = damage;
        this.heal = heal;
    }
    
}
