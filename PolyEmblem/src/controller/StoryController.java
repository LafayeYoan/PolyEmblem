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
import model.Items.ArmorItem;
import model.Items.EdibleItem;
import model.Level;
import model.Personnage;
import view.EventView;
import view.PersonnageDisplayView;
import view.SelectItemView;

/***
 * Main Controller : Run the game ! 
 */
public class StoryController {

    /* Map with all events of the story and booleans. For each event, the boolean is setup at false.
    It becomes true when the event is playing by the player. */
    private static Map<Events, Boolean> event;
    public static List<Personnage> players;
    
    /***
     * Generate all events for the game.
     * WARNING : when running the game, don't know what is the first event to be running ?...
     */
    public static void generateEvents() {
        
        event = new HashMap<Events, Boolean>();
        
        //TODO : add story events here
        
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
        
        event.put(new FightEvent("Heureux de cette nouvelle découverte,"
                + "vous ne sentez pas tout de suite cette main moite qui se pose "
                + "fermement sur votre épaule. \n C'est Charlie (aka le Kaid), une vermine"
                + "en Méca, qui sème la terreur et le chaos dans tout le réseau. \n Vous sentez dans son regard"
                + "la haine qu'il éprouve pour vous : \n - Ce sont mes tic tac, vermine. \n"
                + "Il va falloir vous battre pour conserver votre précieux butin... ",
                new Meca("Charlie le Kaid", new Level(10))), false);
        
        event.put(new DiscoverPlaceEvent("C'est une première victoire qui vous fait chaud au coeur, et vous poursuivez votre route vers Polytech. \n"
                + "Il y a presque une demi-minute que vous vous frayez un chemin parmi les autres étudiants lorsque vous entendez un battement d'ailes au-dessus des arbres. \n"
                + "Vous levez les yeux et vous distinguez la silhouette d'un membre du BDE qui accroche une affiche sur un prochain évènement alcoolisé. \n"
                + "C'est l'un des amis de Charlie qui vous a attaqué plus tôt. \n"
                + "Sur sa tête vous distinguez une casquette Polytech, faiblement retenue. \n"
                + "C'est une relique, et lorsqu'elle tombe à vos pieds, vous ne vous faite pas prier pour la saisir. \n"
                + "L'élève du BDE se tourne vers vous, et voyant votre sourir radieux, il s'exclame : \n"
                + " - Ola camarade ! Tu peux garder ma casquette si tu veux, y en a plein d'autres dans la remise ! \n",
                new ArmorItem("Poly'casquette", 10, 1)), false);
        
        event.put(new DiscoverPlaceEvent("Vous êtes à peine rentré dans le hall du batîment ISTIL lorsque vous entendez des cris et des bruits semblables au fracas du tonnerre. \n"
                + "En vous approchant, près de la machine à café située sous l'escalier, vous apercevez bientôt un groupe d'étudiants que vous connaissez bien. \n"
                + "Vos cinq amis (car oui, ce sont vos amis) sont en train de discuter autour d'un boisson chaude. \n"
                + "D'autres groupes sont disperçés ça et là parmi autour de vous. \n"
                + "Lorsque vous vous approchez, Esteban vous tend un café tout chaud : \n"
                + " - Tien salut ! Bien dormis ? \n", 
                new EdibleItem("Café (bien) chaud", 5, new Effect(Characteristic.DEXTIRITY, 5, 3))), false);
        
        
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
        //TODO : passer une liste de personnage en paramètre
        
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
                        SelectItemView bagView = new SelectItemView(player);
                        bagView.loadHUD();
                        break;
                        
                    case 3 : /* Display characters details */
                        PersonnageDisplayView playerView = new PersonnageDisplayView(player);
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
