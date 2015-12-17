package model;

public interface Skill {
    
    Effect[] useAbility(Character srcCharacter, Character targetCharacter);
    
    double successProbability(Character srcCharacter);
}
