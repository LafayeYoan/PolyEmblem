package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Characteristic;
import model.Classes.Meca;
import model.Effect;
import model.Event.DiscoverPlaceEvent;
import model.Event.FightEvent;
import model.Events;
import model.Item;
import model.Items.EdibleItem;
import model.Level;
import model.Personnage;
import view.EventView;
import view.ItemDisplayView;
import view.PersonnageDisplay;
import view.SelectItem;

public class StoryController {

    /* Map with all events of the story and boolean. Boolean are setup at false.
    They become true when the event is playing by the player. */
    private static Map<Events, Boolean> event;
    public static List<Personnage> players;
    
    /***
     * Generate alls events for the current story.
     * WARNING : when running the game, the last event of the map is reading first 
     */
    public static void generateEvents() {
        
        event = new HashMap<Events, Boolean>();
        
        //TODO : add story events here
        
        event.put(new FightEvent("Heureux de cette nouvelle découverte,"
                + "vous ne sentez pas tout de suite cette main moite qui se pose "
                + "fermement sur votre épaule. \n C'est Charlie (aka le Kaid), une vermine"
                + "en Méca, qui sème la terreur et le chaos dans tout le réseau. \n Vous sentez dans son regard"
                + "la haine qu'il éprouve pour vous : \n - Ce sont mes tic tac, vermine. \n"
                + "Il va falloir vous battre pour conserver votre précieux butin... ",
                new Meca("Charlie le Kaid", new Level(10))), false);
        
        event.put(new DiscoverPlaceEvent("En route vers Polytech, votre très chère école, "
                + "vous vous retrouvez au milieu de tous les autres étudiants du campus "
                + "de l'université Lyon 1 dans le Tram menant à Condorcet. "
                + "\n Ils sentent la transpiration et l'alcool, ce qui ne vous gêne pas beaucoup... "
                + "\n Serré contre la porte, vous distinguez un paquet de tic tac au sol."
                + "Vous vous appretez à le saisir lorsque la voix suave du tram annonce votre arrêt :"
                + "Vous vous jetez dessus et passez la porte pile attend. "
                + "Une chance qu'il reste des tics tacs dans la boite...",
                new EdibleItem("Boite de tic tac entamée", 1, 
                        new Effect(Characteristic.STRENGHT, -2, 0),
                        new Effect(Characteristic.HEALTH, 2, 0))), false);
        
        System.out.println("---------------------------------------------------");
        System.out.println("---------- GENERATION DES EVENTS TERMINES ---------");
        System.out.println("---------------------------------------------------");
    }
    
    /***
     * Run the game. For each event (and as long as the event has not occurred),
     * display to the player the global menu. Call the correct view for each action
     * possible.
     * @param player the player
     */
    public static void runTheGame(Personnage player) {
        
        for(Map.Entry<Events, Boolean> currentEvent : event.entrySet()) {
            
            while(currentEvent.getValue() == false) {
                
                EventView eventView = new EventView(player);
                eventView.loadHUD();

                switch(Integer.parseInt(eventView.getResponse())){
                    case 1 : /* Execute the next event of the story */
                        eventView.showPlayer(currentEvent.getKey());
                        currentEvent.setValue(Boolean.TRUE);
                        break;
                    case 2 : /* Manage the bag */
                        SelectItem bagView = new SelectItem(player);
                        bagView.loadHUD();
                        break;
                    case 3 : /* Display characters details */
                        PersonnageDisplay playerView = new PersonnageDisplay(player);
                        playerView.loadHUD();
                        break;
                    case 4 : /* Load a game */
                        //TODO
                        break;
                    case 5 : /* Save the game */ 
                        //TODO
                        break;
                    case 6 : /* Exit */
                        System.exit(0);
                        break;
                    default: /* Show the main menu */
                        eventView.loadHUD();
                }
            }
        }
    }    
}
