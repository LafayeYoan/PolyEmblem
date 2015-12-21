package controller;

import java.util.ArrayList;
import java.util.List;
import model.Characteristic;
import model.Classes.Info;
import model.Effect;
import model.Event.DiscoverPlaceEvent;
import model.Event.FightEvent;
import model.Events;
import model.Items.EdibleItem;
import model.Level;
import model.Personnage;
import view.EventView;

public class Controller {

    private static List<Events> event;
    public static List<Personnage> players;
    
    /* Generate alls events for the current story */
    public static void generateEvents() {
        
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
    
    public static void runTheGame(Personnage player) {
        
        for(Events currentEvent : event) {
            EventView eventView = new EventView(player);
            eventView.loadHUD();
            
            switch(Integer.parseInt(eventView.getResponse())){
                case 1 : /* Poursuivre le jeu */
                    currentEvent.act(player);
                    break;
                case 2 : /* Utiliser un consommable */
                    //TODO
                    break;
                case 3 : /* Voir les détails du personnage */
                    //TODO
                    break;
                case 4 : /* Sauvegarder */ 
                    //TODO
                    break;
                case 5 : /* Quitter le jeu */
                    //TODO
                    break;
                default: /* Proposer de nouveau le menu event */
                    //TODO
            }
        }
    }    
}
