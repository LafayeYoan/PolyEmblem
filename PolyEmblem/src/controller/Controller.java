package controller;

import java.util.ArrayList;
import java.util.List;
import model.Characteristic;
import model.Classes.Info;
import model.Effect;
import model.Event.DiscoverPlaceEvent;
import model.Event.FightEvent;
import model.Events;
import model.Fight;
import model.Items.EdibleItem;
import model.Level;
import view.HUD;

public class Controller {

    private HUD zeMenu;
    private Character player;
    private static List<Events> event;
    
    public static void main(String[] args) {
        
        generateEvents();
        runEvents();
        
    }
    
    /* Generate alls events for the current story */
    private static void generateEvents() {
        
        event = new ArrayList<Events>();
        
        event.add(new DiscoverPlaceEvent("En route vers Polytech, votre très chère école, "
                + "vous vous retrouvez au milieu de tous les autres étudiants du campus "
                + "de l'université Lyon 1 dans le Tram menant à Condorcet. "
                + "\n Ils sentent la transpiration et l'alcool, ce qui ne vous gêne pas beaucoup... "
                + "\n Serré contre la porte, vous distinguez un paquet de tic tac au sol."
                + "Vous vous appretez à le saisir lorsque la voix suave du tram annonce votre arrêt :"
                + "Vous vous jetez dessus et passez la porte pile attend. "
                + "Une chance qu'il reste des tics tacs dans la boite...",
                new EdibleItem("Boite de tic tac entamée", 1, new Effect(Characteristic.STRENGHT, -2, 0),
                                                            new Effect(Characteristic.HEALTH, 2, 0))));
        
        event.add(new FightEvent("En route vers Polytech, votre très chère école, "
                + "vous vous retrouvez au milieu de tous les autres étudiants du campus "
                + "de l'université Lyon 1 dans le Tram menant à Condorcet. "
                + "\n Ils sentent la transpiration et l'alcool, ce qui ne vous gêne pas beaucoup... "
                + "\n Serré contre la porte, vous distinguez un paquet de tic tac au sol."
                + "Vous vous appretez à le saisir lorsque la voix suave du tram annonce votre arrêt :"
                + "Vous vous jetez dessus et passez la porte pile attend. "
                + "Une chance qu'il reste des tics tacs dans la boite...", new Info("Charlie le Kaid", new Level(10))));
        
        //TODO : add story events here
        
        System.out.println("---------------------------------------------------");
        System.out.println("---------- GENERATION DES EVENTS TERMINES ---------");
        System.out.println("---------------------------------------------------");
    }
    
    private static void runEvents() {
        for(Events currentEvent : event) {
            currentEvent.execute();
            //Quand event fini, proposer le menu contextuel OU next event.
        }
    }
    
    
    //TO REMOVE ?
    private Fight act() {
        //TODO
        return null;
    }
    
}
