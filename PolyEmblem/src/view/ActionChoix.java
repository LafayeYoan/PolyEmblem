/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Darkos
 */
public class ActionChoix implements HUD{
    
    private model.Personnage personnage;
    ActionChoix(model.Personnage chararcter){
        this.personnage = chararcter;
    }
    @Override 
    public void loadHUD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getResponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
