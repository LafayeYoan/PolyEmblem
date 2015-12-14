package model;

public interface Ability {
    
    Effects[] useAbility(Character srcCharacter, Character targetCharacter);
    
    double successProbability(Character srcCharacter);
}
