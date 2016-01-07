package model;

import java.util.LinkedList;
import java.util.List;

/***
 * Represent the bag of the adventure. All items of the player team are inside the bag.
 * @author Lafaye, Lhopital, Paccaud
 */
public class Bag {
    
    public List<Item> allItems;
    public int maxWeight;
    
    public Bag(List<Personnage> allPlayers) {
        allItems = new LinkedList<Item>();
        maxWeight = 0;
        for(Personnage player : allPlayers) {
            maxWeight += Personnage.MAX_WEIGHT;
        }
    }
    
    public void removeItem(Item item){
        if(allItems.contains(item)) {
            allItems.remove(item);
        }   
    }
    
    public void addItem(Item item) {
        allItems.add(item);
    }
    
    public int getActualInUseWeight() {
        int actualInUseWeight = 0;
        for(Item item : allItems) {
            actualInUseWeight += item.getWeight();
        }
        return actualInUseWeight;
    }
    
}
