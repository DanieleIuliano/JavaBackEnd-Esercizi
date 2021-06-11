package GestoreDiBevande;

import java.util.Arrays;
import java.util.Scanner;

public class DistributoreDiBevande {
    private int numProdotti;
    Prodotti[] prodotti;
    private double importo;

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }


    public DistributoreDiBevande(int numProdotti) {
        this.numProdotti = numProdotti;
    }

    /**
     * caricaProdotto: dato un Prodotto p in input, lo carica nel distributore
     *
     * @param prodotto .
     */
    public void caricaProdotto(Prodotti prodotto) {
        if (prodotti == null) {

            prodotti = new Prodotti[1];
            prodotti[0] = prodotto;

        } else {
            Prodotti[] newProdotti = Arrays.copyOf(prodotti, prodotti.length + 1);
            newProdotti[prodotti.length] = prodotto;
            prodotti = newProdotti;
        }
    }

    /**
     * inserisciImporto: permette di inserire un importo nella macchinetta
     *
     * @param importoIns .
     */
    public void inserisciImporto(double importoIns) {
        setImporto(importo + importoIns);
        System.out.println("Importo attuale: " + getImporto());
    }

    /**
     * scegliProdotto: dato in ingresso un codice di prodotto, restituisca il prodotto associato a
     * quel numero (se l’importo inserito lo consente) e decrementi il saldo disponibile nel distributore
     *
     * @param codice
     */
    public void scegliProdotto(String codice) {
        for (int i = 0; i < prodotti.length; i++) {
            if (prodotti[i].codice.equalsIgnoreCase(codice)) {
                if (prodotti[i].prezzo < getImporto()) {
                    System.out.println("Hai scelto il prodotto");
                    double nuovoImporto = getImporto() - prodotti[i].prezzo;
                    setImporto(nuovoImporto);
                    return;
                } else System.out.println("Non hai abbastanza soldi");
            } else System.out.println("codice Sbagliato");
        }
    }

    /**
     * - saldoAttuale: restituisce il saldo attuale del distributore
     */
    public void saldoAttuale() {
        System.out.println(getImporto());
    }

    public void getResto() {
        if(getImporto() != 0){
            System.out.println("erogazione resto " + getImporto());
            setImporto(0);
        }else System.out.println("Non ci sta resto ");
    }
}
