package Modulo4_Negozio;

public class Main {
    public static void main(String[] args) {
        Prodotto[] prodotti = new Prodotto[5];
        prodotti[0] = new Prodotto(3, "Biscotti", 2, TipoProdotto.alimentari);
        prodotti[1] = new Prodotto(3, "Divano", 15, TipoProdotto.nonAlimentari);
        prodotti[2] = new Prodotto(5, "Pasta", 3, TipoProdotto.alimentari);
        prodotti[3] = new Prodotto(30, "Sedia", 10, TipoProdotto.nonAlimentari);
        prodotti[4] = new Prodotto(6, "Sofficini", 2.50f, TipoProdotto.alimentari);
        Cliente[] clienti = new Cliente[3];
        clienti[0] = new Cliente("Coglionazzo", 32, 0);
        clienti[1] = new Cliente("Matrialone", 65, 100);
        clienti[2] = new Cliente("Pisellone", 40, 10);

        Negozio negozio = new Negozio(prodotti, clienti);
        // rimuove il divano (quindi rimuovi prodotto funziona)
        negozio.rimuoviQuantita(prodotti[1], 1);
        // rimuove il sofficino (quindi toglie la quantita);
        negozio.rimuoviQuantita(prodotti[4], 3);
        negozio.aggiungiProdotto(new Prodotto(3, "calzone", 3, TipoProdotto.nonAlimentari));
        negozio.aumentaQuantita(prodotti[0], 3);
        negozio.stampaListaProdotti();

        //esempio cliente che compra un prodotto
        clienti[0].acquistaProdotto(negozio, prodotti[3]);
        negozio.stampaListaProdotti();
        clienti[1].acquistaProdotto(negozio, prodotti[3]);

    }
}
