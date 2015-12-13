/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Darkos
 */
public abstract class Skill {
    private String name;
    
    public Skill(String name){
        this.name = name;
    }
    
    public abstract void effect(model.Character src, model.Character target);
    
}
