/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.List;

/**
 *
 * @author Darkos
 */
public class Validator {
    
    
    public static boolean checkIsInteger(String input){
        try{
            Integer.parseInt(input);
        }catch(Exception e){
            System.out.println("La valeur entrée doit être un entier.");
            return false;
        }
        return true;
    }
    
    public static boolean checkRange(int val, int min, int max){
        boolean valid = true;
        if(val< min){
            System.out.println("La valeur entrée doit être supérieure ou égale à "+ min+ ".");
            valid = false;
        }
        if(val > max){
            System.out.println("La valeur entrée doit être inférieure ou égale à "+ max+ ".");
            valid = false;
        }
        return valid;
    }
    
    public static boolean checkInList(Object val, List<Object> vals){
        boolean valid = true;
        if(!vals.contains(val)){
            valid = false;
            System.out.println("La valeur entrée doit être incluse dans:");
            vals.stream().forEach((o) -> {
                System.out.println("\t- "+ o.toString());
            });
        }
        return valid;
    }
    
    public static boolean checkEmpty(String txt){
        boolean valid = true;
        if(txt.isEmpty()){
            valid = false;
            System.out.println("La chaine de caractère entrée est vide.");
        }
        return valid;
    }
}
