package view;

import java.util.List;

/**
 * View that display the details of a fight.
 */
public class RoundView implements HUD{

    public List<model.Personnage> players;
    public List<model.Personnage> badGuys;
    
    @Override
    public void loadHUD() {
        System.out.println("-------------------------------------------");
        System.out.println("-------- Un combat est en cours -----------");
        System.out.println("-------------------------------------------");
        
        System.out.println("Il oppose votre équipe aux méchants");
        
        System.out.println("Votre équipe se compose de:");
        for(model.Personnage p:players){
            System.out.println(p.getBasicDescription());
        }
        
        System.out.println("L'équipe adverse se compose de:");
        for(model.Personnage p:badGuys){
            System.out.println(p.getBasicDescription());
        }
    }

    @Override
    public Object getResponse() {
        return null;
    }
    
}
