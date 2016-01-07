package view;

import controller.FightController;
import controller.ItemController;
import utils.KeyboardInput;
import model.Event.DiscoverPlaceEvent;
import model.Event.FightEvent;
import model.Events;
import model.Personnage;

/**
 * View that manage the main menu of the game. 
 * Give to the controller the next action of the player.
 */
public class EventView implements HUD {
    
    private static final int NB_OPTIONS = 6;
    
    private final Personnage player;
    private String nextAction;
    
    public EventView(Personnage player){
        this.player = player;
    }
    
    @Override 
    public void loadHUD() {
        System.out.println("----------------------------------------");
        System.out.println("\n Quelle est votre prochaine action ?");
        System.out.println("\n 1 : Poursuivre ma route "
                            + "\n 2 : Voir le contenu du sac"
                            + "\n 3 : Voir les détails de mon personnage"
                            + "\n 4 : Charger une partie déjà existante"
                            + "\n 5 : Sauvegarder"
                            + "\n 6 : Quitter" );
        do{
            nextAction = KeyboardInput.getInput();
        }while(!isValid());
    }
    
    private boolean isValid(){
        if(!utils.Validator.checkEmpty(nextAction)){
            return false;
        }
        int i = 0;
        try{
            i = Integer.parseInt(nextAction);         
        }catch(Exception e){
        }
        if(!utils.Validator.checkRange(i, 1, NB_OPTIONS)){
            return false;
        }
        return true;
    }
    
    @Override
    public String getResponse() {
        return nextAction;
    }

    /***
     * Display to the player an event and redirects to the proper controller.
     * @param currentEvent the event to display
     */
    public void showPlayer(Events currentEvent) {
        System.out.println("----------------------------------------");
        System.out.println("------ Un Evènement se produit ! -------");
        System.out.println("----------------------------------------");
        System.out.println("\n " + currentEvent.getDescriptionEvent() + " \n");
        
        if(currentEvent.getClass() == DiscoverPlaceEvent.class) {
            
            DiscoverPlaceEvent event = (DiscoverPlaceEvent) currentEvent;
            ItemController itemController = new ItemController();
            
            System.out.println("\n Vous trouvez : " + event.getTreasure().getName() 
                    + ". \n" + event.getTreasure().getDescription());     
            
            itemController.itemFound(player, event.getTreasure()); 
            
        } else if(currentEvent.getClass() == FightEvent.class){
            
            FightEvent event = (FightEvent) currentEvent;
            FightController fightController = new FightController();
            
            for(Personnage badGuy : event.getAllBadGuys()) {
                System.out.println(badGuy.getName() + " "); 
            }
            
            if(event.getAllBadGuys().size() == 1) {
                System.out.println(" veux se battre !"); 
            } else {
                System.out.println(" veulent se battre !"); 
            }
            
            fightController.runTheFight(player, event.getAllBadGuys());
        }
        System.out.println("----------------------------------------");
    }
}
