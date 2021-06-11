package ClassificaSerieA;

public class Main {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Mark","Iuliano");
        System.out.println(g1.getIdGiocatore());
        Giocatore g2 = new Giocatore("Melvin","differenzaTraUnPalo");
        System.out.println(g2.getIdGiocatore());

        Giocatore g3 = new Giocatore("Pazzo","Cane");
        System.out.println(g3.getIdGiocatore());
        Giocatore g4 = new Giocatore("Raf","bananone96");

        Giocatore[] giocatoriAtalanta = {g1,g2};
        Squadra s1 = new Squadra("Atalanta",giocatoriAtalanta);

        Giocatore[] giocatoriJuve = {g3,g4};
        Squadra s2 = new Squadra("Juventus",giocatoriJuve);
        System.out.println(s1.getIdSquadra());
        System.out.println(s2.getIdSquadra());

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
