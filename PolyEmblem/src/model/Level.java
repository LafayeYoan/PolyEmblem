package model;

public class Level {
    public static int MAXLEVEL=60;
    
    private int level;
    private int exp;
    private int step;
    
    public Level(){
        level = 1;
        exp = 0;
        step = this.getStep();
    }
    
    public Level(int lv) {
        level = lv;
        exp = 0;
        step = this.getStep();
    }
    
    private int getStep(){
        return level * 50 +50;
    }
    
    public boolean addXP(int xp){
        exp += xp;
        if(exp >= step){
            levelUp();
            return true;
        }
        return false;
    }
    
    private void levelUp(){
        level++;
        exp = 0;
        step = this.getStep();
    }
    
    public int getLevelValue(){
        return level;
    }
    
    public int getExp(){
        return exp;
    }
}
