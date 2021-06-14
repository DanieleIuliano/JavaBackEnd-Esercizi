package ClassificaSerieA;

public class Main {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Mark","Iuliano");
        Giocatore g2 = new Giocatore("Melvin","differenzaTraUnPalo");

        Giocatore g3 = new Giocatore("Pazzo","Cane");
        Giocatore g4 = new Giocatore("Raf","bananone96");
        System.out.println(g3.getIdGiocatore());
        System.out.println(g4.getIdGiocatore());
        Giocatore[] giocatoriAtalanta = {g1,g2};
        Squadra s1 = new Squadra("Atalanta",giocatoriAtalanta);

        Giocatore[] giocatoriJuve = {g3,g4};
        Squadra s2 = new Squadra("Juventus",giocatoriJuve);

        Squadra s3 = new Squadra("Milan",giocatoriAtalanta);
        Squadra s4 = new Squadra("Inter",giocatoriJuve);

        Squadra[] squadreSerieA = {s1,s2,s3,s4};
        Classifica serieA = new Classifica(squadreSerieA);

        serieA.esitoPartita(s2,3,s4,5);
        serieA.esitoPartita(s1,2,s3,3);
        serieA.esitoPartita(s1,2,s4,2);
        serieA.stampaClassifica();
        serieA.stampaMigliorAttacco();
        serieA.stampaPeggiorDifesa();


    }
}
