package model.Items;

import java.util.List;
import java.util.Map;
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
