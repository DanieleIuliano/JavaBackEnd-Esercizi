package GestorePrenotazioni;

public class Main {
    public static void main(String[] args) {
        Prenotazioni p1 = new PrenotazioneSingola("12",TipoPrenotazione.esterno);
        Prenotazioni p2 = new PrenotazioneSingola("23", TipoPrenotazione.esterno);
        Prenotazioni p3 = new PrenotazioneSingola("34", TipoPrenotazione.interno);
        Prenotazioni p4 = new PrenotazioneSingola("56", TipoPrenotazione.interno);
        Prenotazioni p5 = new PrenotazioneSingola("23", TipoPrenotazione.esterno);

        MiniGestorePrenotazioni ristorante = new MiniGestorePrenotazioni(10,10);


        ristorante.prenota(p1);
        ristorante.prenota(p3);
        ristorante.prenota(p2);
        ristorante.prenota(p5);

        PrenotazioniGruppo g1 = new PrenotazioniGruppo("44",3);

        ristorante.prenota(g1);

        ristorante.terminaPrenotazione(g1);

        System.out.println(ristorante.getPostEsterni());
        System.out.println(ristorante.getPostInterni());

    }
}
