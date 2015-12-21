package controller;

import java.util.ArrayList;
import java.util.List;
import model.Personnage;
import view.PersonnageNom;
import view.PersonnageClasse;

/**
 *
 * @author Darkos
 */
public class CharacterCreation {
    public static List<Personnage> start(){
        ArrayList<Personnage> players = new ArrayList<>();
        for(int i = 0 ; i< Controller.NUMBER_OF_PLAYER; i++){
            PersonnageNom nom = new PersonnageNom();
            nom.loadHUD();
            PersonnageClasse classe = new PersonnageClasse();
            classe.loadHUD();            
            switch(classe.getResponse()){
                case "GBM":
                    players.add(new model.Classes.Gbm(nom.getResponse()));
                    break;
                case "INFO":
                    players.add(new model.Classes.Info(nom.getResponse()));
                    break;
                case "MAM":
                    players.add(new model.Classes.Mam(nom.getResponse()));
                    break;
                case "MAT":
                    players.add(new model.Classes.Mat(nom.getResponse()));
                    break;
                case "MECA":
                    players.add(new model.Classes.Meca(nom.getResponse()));
                    break;
                default:
                    //DO Nothing
                    //The player loose a character
            }
        }
        return players;
    }
}
