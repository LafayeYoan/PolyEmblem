package view.Personnage;

import java.util.List;
import java.util.Map;
import model.Personnage;
import view.HUD;

/**
 * View that display in detail all characters of the player.
 */
public class PersonnageDisplayView implements HUD{

    private List<Personnage> allPlayers;
    
    public PersonnageDisplayView (List<Personnage> allPlayers){
        this.allPlayers = allPlayers;
    }
    @Override
    public void loadHUD() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------- Fiche des Personnages de l'équipe -----------");
        System.out.println("------------------------------------------------------");
        
        for(Personnage aPlayer : this.allPlayers) {
            
            System.out.println("Nom: "+ aPlayer.getName());
            System.out.print("Classe: ");
            if(aPlayer instanceof model.Classes.Gbm){
                System.out.println("GBM");
            }else if(aPlayer instanceof model.Classes.Info){
                System.out.println("INFO");
            }else if(aPlayer instanceof model.Classes.Mam){
                System.out.println("MAM");
            }else if(aPlayer instanceof model.Classes.Mat){
                System.out.println("MAT");
            }else if(aPlayer instanceof model.Classes.Meca){
                System.out.println("MECA");
            }
            System.out.println("Points de Vie: "+ aPlayer.getActualLife() + "/" + aPlayer.getMaxHealth());

            //Level
            System.out.println("Niveau: " + aPlayer.getLevel().getLevelValue());

            //Caracteristics
            System.out.println("--------- Caracteristiques -------------");
            Map <model.Characteristic,Integer> caract = aPlayer.getCharacteritics();       
            System.out.println("Force: "+ caract.getOrDefault(model.Characteristic.STRENGHT, 0));
            System.out.println("Defence: "+ caract.getOrDefault(model.Characteristic.DEFENCE, 0));
            System.out.println("Dextiritée: "+ caract.getOrDefault(model.Characteristic.DEXTIRITY, 0));
            System.out.println("Inteligence: "+ caract.getOrDefault(model.Characteristic.INTELIGENCE, 0));
            System.out.println("Vie: "+ caract.getOrDefault(model.Characteristic.HEALTH, 0));
            System.out.println("----------------------------------------");
        
        }
    }

    @Override
    public Object getResponse() {
        return null;
    }

    
}
