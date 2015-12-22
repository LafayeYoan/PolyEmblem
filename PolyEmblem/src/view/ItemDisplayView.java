package view;

import java.util.Scanner;
import model.Item;

/**
 *
 * @author lhopital
 */
public class ItemDisplayView implements HUD {
    
    private Item item;
    
    public ItemDisplayView(Item itemToDisplay){
        this.item = itemToDisplay;
    }

    @Override
    public void loadHUD() {
        System.out.println("----------------------------------------");
        System.out.println("--------- Details de l'objet -----------");
        System.out.println("----------------------------------------");
        System.out.println(item.getDescription());
    }

    @Override
    public Object getResponse() {
        return 0;
    }
    
}
