package org.example.MusicPlayer;

import org.example.Iphone.Iphone;

import java.util.Scanner;

public class MusicPlayer implements MusicPlayerInterface {

    Music[] playlist = new Music[2];

    public void MusicPlayer() {
        playlist[0] = new Music("Talking to the moon", "/not/a/real/patch");
        playlist[1] = new Music("Beat it", "/not/a/real/patch");

        System.out.println("Player de músicas");
        this.SelectMusic(playlist);
    }

    @Override
    public void PlayMusic(String music) {
        System.out.println("Tocando " + music);

        Scanner terminal = new Scanner(System.in);
        System.out.println("0 - Voltar para o início");
        System.out.println("1 - Pausar música");
        System.out.println("2 - Selecionar música");
        int opcao = terminal.nextInt();

        switch (opcao){
            case 0:
                Iphone.Home();
                break;
            case 1:
                PauseMusic(music);
                break;
            case 2:
                SelectMusic(playlist);
                break;
            default:
                System.out.println("Comando não reconhecido");
                PlayMusic(music);
                break;
        }
    }

    @Override
    public void PauseMusic(String music) {
        System.out.println(music + " foi pausada");

        Scanner terminal = new Scanner(System.in);
        System.out.println("0 - Voltar para o início");
        System.out.println("1 - Tocar música");
        System.out.println("2 - Selecionar música");
        int opcao = terminal.nextInt();

        switch (opcao){
            case 0:
                Iphone.Home();
                break;
            case 1:
                PlayMusic(music);
                break;
            case 2:
                SelectMusic(playlist);
                break;
            default:
                System.out.println("Comando não reconhecido");
                PauseMusic(music);
                break;
        }
    }

    @Override
    public void SelectMusic(Music[] playlist) {
        Scanner terminal = new Scanner(System.in);

        System.out.println("Selecione sua música");
        System.out.println("0 - Voltar para o início");
        for(var i=0; i<playlist.length; i++){
            System.out.println((i+1)+" - " + playlist[i].getName());
        }
        int selecao = terminal.nextInt();

        if(selecao == 0){
            Iphone.Home();
        } else {

            if(selecao-1 < playlist.length){
                PlayMusic(playlist[selecao-1].getName());

            } else {
                System.out.println("Musica não encontrada");
                SelectMusic(playlist);
            }

        }
    }
}
