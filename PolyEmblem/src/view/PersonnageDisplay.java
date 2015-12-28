package view;

import java.util.Map;
/**
 *
 * @author Darkos
 */
public class PersonnageDisplay implements HUD{

    private model.Personnage perso;
    
    public PersonnageDisplay (model.Personnage perso){
        this.perso = perso;
    }
    @Override
    public void loadHUD() {
        System.out.println("----------------------------------------");
        System.out.println("-------- Fiche de Personnage -----------");
        System.out.println("----------------------------------------");
        System.out.println("Nom: "+ perso.getName());
        System.out.print("Classe: ");
        if(perso instanceof model.Classes.Gbm){
            System.out.println("GBM");
        }else if(perso instanceof model.Classes.Info){
            System.out.println("INFO");
        }else if(perso instanceof model.Classes.Mam){
            System.out.println("MAM");
        }else if(perso instanceof model.Classes.Mat){
            System.out.println("MAT");
        }else if(perso instanceof model.Classes.Meca){
            System.out.println("MECA");
        }
        System.out.println("Points de Vie: "+perso.getActualLife() + "/" + perso.getMaxHealth());
        //Niveau
        System.out.println("Niveau: " + perso.getLevel().getLevelValue());
        //Characteristiques
        System.out.println("--------- Caracteristiques -------------");
        Map <model.Characteristic,Integer> caract = perso.getCharacteritics();       
        System.out.println("Force: "+ caract.getOrDefault(model.Characteristic.STRENGHT, 0));
        System.out.println("Defence: "+ caract.getOrDefault(model.Characteristic.DEFENCE, 0));
        System.out.println("Dextiritée: "+ caract.getOrDefault(model.Characteristic.DEXTIRITY, 0));
        System.out.println("Inteligence: "+ caract.getOrDefault(model.Characteristic.INTELIGENCE, 0));
        System.out.println("Vie: "+ caract.getOrDefault(model.Characteristic.HEALTH, 0));
        System.out.println("----------------------------------------");
        
    }

    @Override
    public Object getResponse() {
        return null;
    }

    
}
