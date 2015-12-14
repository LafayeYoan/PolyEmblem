package model.Item;

import java.util.Map;
import model.Items;

public class EdibleItems extends Items {

    public EdibleItems(String name, int weight, Map allEffects) {
        super(name, weight, allEffects);
    }
    
    private EdibleItems consume() {
        //TODO
        return this;
    }
    
}
