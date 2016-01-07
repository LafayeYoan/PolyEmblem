package model.Items;

import java.util.Map;
import model.Effect;
import model.Item;

public class WeaponItem extends Item {
    
    private int damage;
    private int heal;

    public WeaponItem(String name, int weight, int damage, int heal, Effect... effects) {
        super(name, weight, effects);
        this.damage = damage;
        this.heal = heal;
    }
    
    public int getDamage(){
        return this.damage;
    }
    
    public int getHeal(){
        return this.heal;
    }
    
}
