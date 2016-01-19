package model;

/**
 * Interface to implement skills
 * @author Lafaye, Lhopital, Paccaud
 */
public interface Skill {
    
    /**
     * Execute the skill
     * @param srcCharacter the character who use the skill
     * @param targetCharacter the target of the skill
     * @return an effects table
     */
    Effect[] useAbility(Personnage srcCharacter, Personnage targetCharacter);
    
    /**
     * Counting the success probability of the skill
     * @param srcCharacter the character who use the skill
     * @return the probability of success
     */
    double successProbability(Personnage srcCharacter);
    
    /**
     * Get the name of the skill
     * @return the name of the skill
     */
    public String getName();
}
