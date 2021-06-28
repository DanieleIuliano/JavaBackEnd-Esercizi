package Tinder;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Interesse inter1 = new Interesse("calcio");
        Interesse inter2 = new Interesse("basket");
        Interesse inter3 = new Interesse("serie Tv");
        Interesse inter4 = new Interesse("film");
        Interesse inter5 = new Interesse("cazzeggio");
        //Prima Lista interessi(calcio/basket/serie TV)
        HashSet<Interesse> lista1 = new HashSet<>();
        lista1.add(inter1);
        lista1.add(inter2);
        lista1.add(inter3);
        //Seconda Lista interessi(calcio/film/cazzeggio)
        HashSet<Interesse> lista2 =new HashSet<Interesse>();
        lista2.add(inter1);
        lista2.add(inter4);
        lista2.add(inter5);
        //Terza Lista interessi(basker/serie tv / cazzeggio)
        HashSet<Interesse> lista3 = new HashSet<Interesse>();
        lista3.add(inter2);
        lista3.add(inter5);
        lista3.add(inter4);
        //creazione Utenti
        Utente u1 = new Utente("Daniele","Iuliano",20,Sesso.MASCHIO,lista1);
        Utente u2 = new Utente("Raff","Pellecchia",18,Sesso.FEMMINA,lista2);
        Utente u3 = new Utente("Giovanni","Cidu",30,Sesso.NONSPECIFICATO,lista3);
        Tinder tinder = new Tinder();
        tinder.addUtente(u1);
        tinder.addUtente(u2);
        tinder.addUtente(u3);
        tinder.stampaUtenti();
        tinder.cercaUtenteAffine(u2);
    }
}
