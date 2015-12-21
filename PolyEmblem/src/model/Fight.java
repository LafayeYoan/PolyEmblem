package model;

//Not sure if it's a correct implementation. 
//See Yoan for debug :D 
public class Fight {
    
    private Round zeRound;
    private Personnage player;
    private Personnage aICharacter;
    private Skill abilityToUse;
    
    private Fight(Personnage player, Personnage aICharacter, Skill abilityToUse) {
        this.zeRound = new Round(); //To increment ? 
        this.player = player;
        this.aICharacter = aICharacter;
        this.abilityToUse = abilityToUse;
    }
}
