package org.example.CallApp;

import org.example.Iphone.Iphone;
import org.example.MusicPlayer.Music;

import java.util.Scanner;

public class CallApp implements CallAppInterface {

    Contact[] agenda = new Contact[2];
    Contact[] mail = new Contact[1];

    public void CallApp(){
        agenda[0] = new Contact("Manoel", "123456789");
        agenda[1] = new Contact("Rodolfo", "987654321");
        mail[0] = new Contact("Manoel", "123456789");

        Scanner terminal = new Scanner(System.in);
        System.out.println("App de chamadas");
        System.out.println("0 - Voltar");
        System.out.println("1 - Fazer chamada");
        System.out.println("2 - Ver correio de voz");
        int opcao = terminal.nextInt();

        switch (opcao){
            case 0:
                Iphone.Home();
                break;
            case 1:
                System.out.println("Digite o número");
                String number = terminal.next();
                callNumber(number);
                break;
            case 2:
                voiceMail(mail);
                break;
            default:
                System.out.println("Comando não reconhecido");
                CallApp();
                break;
        }
    }

    @Override
    public void callNumber(String number) {
        System.out.println("Fazendo chamada...");
        answerCall(false);
    }

    @Override
    public void answerCall(boolean atender) {
        if(atender){
            System.out.println("Chamada atendida");
            CallApp();
        } else {
            System.out.println("Chamada recusada");
            CallApp();
        }
    }

    @Override
    public void voiceMail(Contact[] mail) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Correio de voz");
        System.out.println("0 - Voltar");
        for(var i=0; i<mail.length; i++){
            System.out.println((i+1)+" - Retornar " + mail[i].getName());
        }
        int opcao = terminal.nextInt();

        if(opcao == 0){
            CallApp();
        } else {
            callNumber(mail[opcao-1].getNumber());
        }
    }
}
