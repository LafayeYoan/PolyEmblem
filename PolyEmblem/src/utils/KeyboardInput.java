/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Darkos
 */
public class KeyboardInput {
    private static Scanner sc;
    private static List<String> keywords;
    
    //init
    static{
        sc = new Scanner(System.in);
        keywords = new ArrayList<String>();
        
        //ajout des mots clefs
        keywords.add("moi");
        keywords.add("help");
    }
    
    public static String getInput(){
        String input = sc.nextLine();
        
        //Verification des keywords
        if(keywords.contains(input)){
            // do specific stuff linked to the keywords;
        }        
        
        return input;
    }
}
