package model;

//Not sure if it's a correct implementation. 
//See Yoan for debug :D 
public class Fight {
    
    private Round zeRound;
    private Character player;
    private Character aICharacter;
    private Ability abilityToUse;
    
    private Fight(Character player, Character aICharacter, Ability abilityToUse) {
        this.zeRound = new Round(); //To increment ? 
        this.player = player;
        this.aICharacter = aICharacter;
        this.abilityToUse = abilityToUse;
    }
}
