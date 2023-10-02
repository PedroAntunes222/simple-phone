package org.example.Browser;

import org.example.Iphone.Iphone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Browser implements BrowserInterface {

    List<Page> paginas = new ArrayList<>();
    public void Browser(){
        paginas.add(new Page("google.com"));

        seePage(paginas.get(0));
    }

    @Override
    public void seePage(Page pagina) {
        System.out.println("Vendo a pagina " + pagina.getUrl());

        Scanner terminal = new Scanner(System.in);
        System.out.println("0 - Voltar para o início");
        System.out.println("1 - Abrir nova aba");
        System.out.println("2 - Atualizar pagina");
        if(paginas.size()>1){
            System.out.println("3 - Ver todas as paginas");
            System.out.println("4 - Remover pagina");
        }
        int opcao = terminal.nextInt();

        switch (opcao){
            case 0:
                Iphone.Home();
                break;
            case 1: newPage();
                break;
            case 2: reloadPage(pagina);
                break;
            case 3: seeAllPages(paginas);
                break;
            case 4: removePage();
                break;
            default:
                System.out.println("Comando não reconhecido");
                seePage(paginas.get(0));
                break;
        }
    }

    @Override
    public void newPage() {
        System.out.println("Abrindo nova aba...");

        Scanner terminal = new Scanner(System.in);
        System.out.println("Abrir qual página?");
        String newurl = terminal.next();

        paginas.add(new Page(newurl));

        seePage(paginas.get(paginas.size()-1));
    }

    @Override
    public String reloadPage(Page pagina) {
        System.out.println();

        String txt = "Atualizando a pagina " + pagina.getUrl();
        return txt;
    }

    @Override
    public void seeAllPages(List<Page> paginas) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Qual página deseja ver?");
        for (var i=0; i<paginas.size(); i++) {
            System.out.println((i+1) + " - " + paginas.get(i).getUrl());
        }
        int opcao = terminal.nextInt();

       if(opcao == 0){
           Iphone.Home();
       } else {
           seePage(paginas.get(opcao-1));
       }
    }

    @Override
    public void removePage() {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Qual página deseja remover?");
        System.out.println("0 - Ver todas as páginas");
        for (var i=0; i<paginas.size(); i++) {
            System.out.println((i+1) + " - " + paginas.get(i).getUrl());
        }
        int opcao = terminal.nextInt();

        if(opcao == 0){
            Iphone.Home();
        } else {
            paginas.remove(paginas.get(opcao-1));
        }
        System.out.println("Aba removida");
        seeAllPages(paginas);
    }
}
