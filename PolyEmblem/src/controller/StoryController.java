package controller;

import java.util.LinkedList;
import java.util.List;
import model.Bag;
import model.Characteristic;
import model.Classes.Mat;
import model.Classes.Meca;
import model.Effect;
import model.Event.DiscoverPlaceEvent;
import model.Event.FightEvent;
import model.Events;
import model.IA.IAPersonnage;
import model.Item;
import model.Items.ArmorItem;
import model.Items.EdibleItem;
import model.Items.WeaponItem;
import model.Level;
import model.Personnage;
import view.EndOfGameView;
import view.EventView;
import view.Item.ItemDisplayView;
import view.Personnage.PersonnageDisplayView;
import view.Item.SelectItemView;

/***
 * Main Controller : Run the game !
 * @author Lafaye, Lhopital, Paccaud
 */
public class StoryController {

    /* Map with all events of the story and booleans. For each event, the boolean is setup at false.
    * It becomes true when the event is playing by the player. */
    private static List<Events> event;
    /* List of all characters of the player. */
    public static List<Personnage> players;
    
    /***
     * Generate all events for the game.
     */
    public static void generateEvents() {
        
        event = new LinkedList<>();
        
        //TODO : add story events here
        
        event.add(new DiscoverPlaceEvent("En route vers Polytech, votre très chère école,"
                + " vous vous retrouvez au milieu de tous les autres étudiants du campus"
                + "\nde l'université Lyon 1 dans le Tram menant à Condorcet. "
                + "\nIls sentent la transpiration et l'alcool, ce qui ne vous gêne pas beaucoup... "
                + "\nSerré contre la porte, vous distinguez un paquet de tic tac au sol."
                + "\nVous vous appretez à le saisir lorsque la voix suave du tram annonce votre arrêt :"
                + "\nVous vous jetez dessus et passez la porte pile attend. "
                + "\nUne chance qu'il reste des tics tacs dans la boite...",
                new EdibleItem("Boite de tic tac entamée", 1, 
                        new Effect(Characteristic.STRENGHT, -1, 0),
                        new Effect(Characteristic.HEALTH, 2, 0))));
        
        event.add(new FightEvent("Heureux de cette nouvelle découverte,"
                + "vous ne sentez pas tout de suite cette main moite qui se pose "
                + "fermement sur votre épaule.\nC'est Charlie (aka le Kaid), une vermine"
                + "en Méca, qui sème la terreur et le chaos dans tout le réseau.\nVous sentez dans son regard "
                + "la haine qu'il éprouve pour vous : \n- Ce sont mes tic tac, vermine."
                + "\nIl va falloir vous battre pour conserver votre précieux butin...",
                new IAPersonnage(
                        new Meca("Charlie le Kaid",new Level(3))
                        ,1)
                    )
        );
        
        event.add(new DiscoverPlaceEvent("C'est une première victoire qui vous fait chaud au coeur, et vous poursuivez votre route vers Polytech."
                + "\nIl y a presque une demi-minute que vous vous frayez un chemin parmi les autres étudiants lorsque vous entendez un battement d'ailes au-dessus des arbres."
                + "\nVous levez les yeux et vous distinguez la silhouette d'un membre du BDE qui accroche une affiche sur un prochain évènement alcoolisé."
                + "\nC'est l'un des amis de Charlie qui vous a attaqué plus tôt."
                + "\nSur sa tête vous distinguez une casquette Polytech, faiblement retenue."
                + "\nC'est une relique, et lorsqu'elle tombe à vos pieds, vous ne vous faite pas prier pour la saisir."
                + "\nL'élève du BDE se tourne vers vous, et voyant votre sourir radieux, il s'exclame : "
                + "\n- Ola camarade ! Tu peux garder ma casquette si tu veux, y en a plein d'autres dans la remise !",
                new ArmorItem("Poly'casquette", 10, 1)));
        
        event.add(new DiscoverPlaceEvent("Vous êtes à peine rentré dans le hall du batîment ISTIL lorsque vous entendez des cris et des bruits semblables au fracas du tonnerre."
                + "\nEn vous approchant, près de la machine à café située sous l'escalier, "
                + "vous apercevez bientôt un groupe d'étudiants que vous connaissez bien."
                + "\nVos cinq amis (car oui, ce sont vos amis) sont en train de discuter autour d'un boisson chaude."
                + "\nD'autres groupes sont disperçés ça et là parmi autour de vous."
                + "\nLorsque vous vous approchez, Esteban vous tend son cahier de mathématique : "
                + "\n- Tien salut ! Bien dormis ?", 
                new WeaponItem("Cahier de mathématiques très Rigide", 99, 5, 2, new Effect(Characteristic.STRENGHT, 2, 1))));
        
    }
    
    /***
     * Run the game. For each event (and as long as the event has not occurred),
     * display to the player the global menu. Call the correct view for each action
     * possible. At the end of the game, display the winning view.
     * @param allPlayers a list of all characters of the player
     */
    public static void runTheGame(List<Personnage> allPlayers) {
        
        Bag bag = new Bag(allPlayers);
        
        for(Events currentEvent : event) {
            
            while(currentEvent.isDone == false) {
                
                EventView eventView = new EventView(bag, allPlayers);
                eventView.loadHUD();

                switch(Integer.parseInt(eventView.getResponse())){
                    
                    case 1 : /* Execute the next event of the story */
                        eventView.showPlayer(currentEvent);
                        currentEvent.isDone = true;
                        break;
                        
                    case 2 : /* Manage the bag */
                        SelectItemView bagView = new SelectItemView(bag);
                        bagView.loadHUD();
                        if(bagView.getResponse().getClass().toString().equals("class java.lang.Integer")) {
                            //Do nothing, go back in the main menu
                        } else {
                            ItemDisplayView itemDisplayView = new ItemDisplayView((Item) bagView.getResponse());
                            itemDisplayView.loadHUD(); 
                        }
                        break;
                        
                    case 3 : /* Display characters details */
                        PersonnageDisplayView playerView = new PersonnageDisplayView(allPlayers);
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
        
        EndOfGameView.loadWinnerEnding();
    }    
}
