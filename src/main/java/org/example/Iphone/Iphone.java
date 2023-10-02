package org.example.Iphone;

import org.example.Browser.Browser;
import org.example.CallApp.CallApp;
import org.example.MusicPlayer.MusicPlayer;

import java.util.Scanner;

public class Iphone {
    public static void Home() {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Home - Escolha seu app");
        System.out.println("1 - Música");
        System.out.println("2 - Chamada");
        System.out.println("3 - Navegador");
        int parametro = terminal.nextInt();

        switch (parametro){
            case 1:
                MusicPlayer player = new MusicPlayer();
                player.MusicPlayer();
                break;
            case 2:
                CallApp callapp = new CallApp();
                callapp.CallApp();
                break;
            case 3:
                Browser browser = new Browser();
                browser.Browser();
                break;
            default:
                System.out.println("App desconhecido");
                Home();
        }
    }
}
