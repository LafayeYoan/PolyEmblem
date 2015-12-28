package model.Skills;

import java.util.List;
import model.Skill;
import model.Personnage;
import model.Effect;

public class HealSkill implements Skill {

    @Override
    public Effect[] useAbility(Personnage srcCharacter, List<Personnage> targetCharacter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double successProbability(Personnage srcCharacter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return "Soin";
    }
    
}
