package view;

//HUD : s'occupe des printLn et scanf pour afficher à l'utilisateur

import java.util.Scanner;


public interface HUD {
    
    public void loadHUD();
    public Object getResponse();
    
    public Scanner scanner = new Scanner(System.in);
    
    public void showPlayer(String message);

}
