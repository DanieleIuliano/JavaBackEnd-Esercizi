package Dizionario_Esercizio;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Dizionario dizionario1 = new Dizionario();
        dizionario1.addLettere();
        dizionario1.aggiungiParole("pallavolo",Arrays.asList("sport di squadra"));
        dizionario1.aggiungiParole("catafratto",new ArrayList<>());
        dizionario1.aggiungiParole("zanzibar",new ArrayList<>());
        dizionario1.aggiungiParole("calcio",new ArrayList<>());
        dizionario1.aggiungiParole("vita",new ArrayList<>());
        dizionario1.aggiungiSignificato("calcio","sportFigo");
        dizionario1.aggiungiSignificato("calcio","elemento chimico");
        dizionario1.aggiungiSignificato("zanzibar","sportFigo");
        dizionario1.rimuoviSignificato("calcio","sportFigo");
        dizionario1.rimuoviSignificato2("sportFigo");
        dizionario1.rimuoviParola("catafratto");
        dizionario1.stampaDizionario();
    }
}
