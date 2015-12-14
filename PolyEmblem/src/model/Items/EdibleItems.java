package model.Items;

import java.util.Map;
import model.Item;

public class EdibleItems extends Item {

    public EdibleItems(String name, int weight, Map allEffects) {
        super(name, weight, allEffects);
    }
    
    private EdibleItems consume() {
        //TODO
        return this;
    }
    
}
