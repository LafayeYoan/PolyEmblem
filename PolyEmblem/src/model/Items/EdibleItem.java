package model.Items;

import model.Effect;
import model.Item;

public class EdibleItem extends Item {

    public EdibleItem(String name, int weight, Effect... effects) {
        super(name, weight, effects);
    }
    
    private EdibleItem consume() {
        //TODO
        return this;
    }
    
}
