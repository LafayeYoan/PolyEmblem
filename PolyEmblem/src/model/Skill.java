package model;

import java.util.List;

public interface Skill {
    
    Effect[] useAbility(Personnage srcCharacter, Personnage targetCharacter);
    
    double successProbability(Personnage srcCharacter);
    
    public String getName();
}
