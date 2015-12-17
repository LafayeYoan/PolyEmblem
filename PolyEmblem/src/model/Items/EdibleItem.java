package model.Items;

import java.util.Map;
import model.Item;

public class EdibleItem extends Item {

    public EdibleItem(String name, int weight, Map allEffects) {
        super(name, weight, allEffects);
    }
    
    private EdibleItem consume() {
        //TODO
        return this;
    }
    
}
