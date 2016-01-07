package view.Fight;

import java.util.List;
import view.HUD;
import model.IA.IAPersonnage;
import model.Personnage;

/**
 * View that display the details of a fight.
 */
public class RoundView implements HUD{

    private List<model.Personnage> players;
    private List<model.IA.IAPersonnage> badGuys;
    
    public RoundView(List<model.Personnage> players,List<model.IA.IAPersonnage> badGuys){
        this.players = players;
        this.badGuys = badGuys;
    }
    
    @Override
    public void loadHUD() {
        System.out.println("\n-------------------------------------------");
        System.out.println("-------- Un combat est en cours -----------");
        System.out.println("-------------------------------------------");
        
        System.out.println("Il oppose votre équipe aux méchants");
        
        System.out.println("Votre équipe se compose de:");
        for(model.Personnage p:players){
            System.out.println(p.getBasicDescription());
        }
        
        System.out.println("L'équipe adverse se compose de:");
        for(model.IA.IAPersonnage p:badGuys){
            System.out.println(p.getPersonnage().getBasicDescription());
        }
    }
    
    public static void IAAttackDisplay(IAPersonnage source, Personnage target){
        System.out.println("-------------------------------------------");
        System.out.println(source.getPersonnage().getName()+ " attaque "+ target.getName());
        System.out.println("-------------------------------------------");
    }

    @Override
    public Object getResponse() {
        return null;
    }
    
}
