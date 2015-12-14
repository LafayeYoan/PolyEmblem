package model;

public interface Skill {
    
    Effects[] useAbility(Character srcCharacter, Character targetCharacter);
    
    double successProbability(Character srcCharacter);
}
