package view;

import controller.ItemController;
import controller.KeyboardInput;
import model.Event.DiscoverPlaceEvent;
import model.Event.FightEvent;
import model.Events;
import model.Personnage;

/**
 *
 * @author lhopital
 */
public class EventView implements HUD {
    
    private static final int NB_OPTIONS = 6;
    
    private Personnage player;
    private String nextAction;
    
    public EventView(Personnage player){
        this.player = player;
    }
    
    @Override 
    public void loadHUD() {
        System.out.println("----------------------------------------");
        System.out.println("\n Quelle est votre prochaine action ?");
        System.out.println("\n 1 : Poursuivre ma route "
                + "\n 2 : Utiliser un consommable"
                + "\n 3 : Voir les détails de mon personnage"
                + "\n 4 : Sauvegarder"
                + "\n 5 : Quitter" );
        do{
            nextAction = KeyboardInput.getInput();
        }while(!isValid());
    }
    
    private boolean isValid(){
        boolean valid = true;
        if(nextAction.isEmpty()){
            System.out.println("Veuillez entrer une valeur.");
            valid = false;
            return valid;
        }
        int i;
        try{
            i = Integer.parseInt(nextAction);         
        }catch(Exception e){
            System.out.println("Veuillez entrer un chiffre.");
            valid = false;
            return valid;
        }
        
        if(i >= NB_OPTIONS ||i <= 0){
            System.out.println("Veuillez entrer un chiffre compris entre 1 et " + NB_OPTIONS + ".");
            valid = false;
            return valid;
        }
        
        return valid;
    }
    
    @Override
    public String getResponse() {
        return nextAction;
    }

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
            
            itemController.findItem(player, event.getTreasure());       
        } else if(currentEvent.getClass() == FightEvent.class){
            
            FightEvent event = (FightEvent) currentEvent; 
            
            for(Personnage badGuy : event.getAllBadGuys()) {
                System.out.println(badGuy.getName() + " "); 
            }
            
            if(event.getAllBadGuys().size()==1) {
                System.out.println(" veux se battre !"); 
            } else {
                System.out.println(" veulent se battre !"); 
            }
        }
        System.out.println("----------------------------------------");
    }
}
