package controller;

import java.util.ArrayList;
import java.util.List;
import model.Characteristic;
import model.Classes.Info;
import model.Effect;
import model.Events.DiscoverPlaceEvent;
import model.Events.FightEvent;
import model.Event;
import model.Fight;
import model.Items.EdibleItem;
import model.Personnage;

public class Controller {
    public static int NUMBER_OF_PLAYER = 3;
    public static List <Personnage> players;
    private static List<Event> event;
    
    public static void main(String[] args) {
        generateEvents();
    }
    
    /* Generate alls events for the current story */
    public static void generateEvents() {
        
        event = new ArrayList<Event>();
        
        event.add(new DiscoverPlaceEvent("En route vers Polytech, votre très chère école, "
                + "vous vous retrouvez au milieu de tous les autres étudiants du campus "
                + "de l'université Lyon 1 dans le Tram menant à Condorcet. "
                + "\n Ils sentent la transpiration et l'alcool, ce qui ne vous gêne pas beaucoup... "
                + "\n Serré contre la porte, vous distinguez un paquet de tic tac au sol."
                + "Vous vous appretez à le saisir lorsque la voix suave du tram annonce votre arrêt :"
                + "Vous vous jetez dessus et passez la porte pile a temps. "
                + "Une chance qu'il reste des tic-tacs dans la boite...",
                new EdibleItem("Boite de tic tac entamée", 1, new Effect(Characteristic.STRENGHT, 2, 0))));
        
        /*event.add(new FightEvent("En route vers Polytech, votre très chère école, "
                + "vous vous retrouvez au milieu de tous les autres étudiants du campus "
                + "de l'université Lyon 1 dans le Tram menant à Condorcet. "
                + "\n Ils sentent la transpiration et l'alcool, ce qui ne vous gêne pas beaucoup... "
                + "\n Serré contre la porte, vous distinguez un paquet de tic tac au sol."
                + "Vous vous appretez à le saisir lorsque la voix suave du tram annonce votre arrêt :"
                + "Vous vous jetez dessus et passez la porte pile attend. "
                + "Une chance qu'il reste des tics tacs dans la boite...", new Info("Charlie le Kaid", 0, 10)));*/
        
        //TODO : add more events
        System.out.println("---------------------------------------------------");
        System.out.println("---------- GENERATION DES EVENTS TERMINES ---------");
        System.out.println("---------------------------------------------------");
    }
}
