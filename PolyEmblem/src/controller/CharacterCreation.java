package controller;

import java.util.ArrayList;
import java.util.List;
import model.Personnage;
import view.PersonnageNomView;
import view.PersonnageClasseView;
import view.PersonnageDisplayView;

public class CharacterCreation {
    
    private static final int NUMBER_OF_PLAYER = 3;
    
    public static List<Personnage> start(){
        ArrayList<Personnage> players = new ArrayList<>();
        for(int i = 0 ; i< NUMBER_OF_PLAYER; i++){
            PersonnageNomView nom = new PersonnageNomView();
            nom.loadHUD();
            PersonnageClasseView classe = new PersonnageClasseView();
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
            new PersonnageDisplayView(players).loadHUD();            
        }
        return players;
    }
}
