package model;

public interface Skill {
    
    Effect[] useAbility(Personnage srcCharacter, Personnage targetCharacter);
    
    double successProbability(Personnage srcCharacter);
    
    public String getName();
}
