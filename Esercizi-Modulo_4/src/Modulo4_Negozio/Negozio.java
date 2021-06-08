package Modulo4_Negozio;

import java.util.Arrays;

public class Negozio {
    Prodotto[] prodotti ;
    Cliente[] clienti;

    /**
     * costruttore classe negozio
     * @param prodotti .
     * @param clienti .
     */
    public Negozio(Prodotto[] prodotti, Cliente[] clienti) {
        this.prodotti = prodotti;
        this.clienti = clienti;
    }

    public void stampaListaProdotti(){
        System.out.println("Lista Prodotti :");
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto.getNomeProdotto() + " , Quantità: " + prodotto.getQuantita());
        }
    }

    public void rimuoviQuantita(Prodotto prodotto,int quantitaDaTogliere) {
        if(quantitaDaTogliere > prodotto.getQuantita()){
            System.out.println("Non puoi togliere più di quanto hai ");
            return;
        }
        if (prodotto.getQuantita() > 1) {
            prodotto.setQuantita(prodotto.getQuantita() - quantitaDaTogliere);
            System.out.println("Ho rimosso una quantita al prodotto");
        } else {
            rimuoviProdotto(prodotto);
            System.out.println("Ho rimosso il prodotto");
        }
    }

    private void rimuoviProdotto(Prodotto prodotto) {
        int indice = ritornaIndiceProdotto(prodotto);
        Prodotto[] newProdotti = new Prodotto[prodotti.length - 1];
        System.arraycopy(prodotti, 0, newProdotti, 0, indice);
        System.arraycopy(prodotti, indice + 1, newProdotti, indice, prodotti.length - indice - 1);
        prodotti = newProdotti;
    }

    public int ritornaIndiceProdotto(Prodotto prodotto) {
        for (int i = 0; i < prodotti.length; i++) {
            if (prodotti[i].getNomeProdotto().equalsIgnoreCase(prodotto.getNomeProdotto())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * metodo che serve ad aggiungere un prodotto
     *
     * @param prodotto .
     */
    public void aggiungiProdotto(Prodotto prodotto) {
        if (prodotti == null) {

            prodotti = new Prodotto[1];
            prodotti[0] = prodotto;

        }
        //se il prodotto è gia presente aumentane solo la quantita
        if (checkProdotto(prodotto)) {
            aumentaQuantita(prodotto,prodotto.getQuantita());
        }
        //se il prodotto non è presente aggiungilo
        else {
            Prodotto[] newProdotti = Arrays.copyOf(prodotti, prodotti.length + 1);
            newProdotti[prodotti.length] = prodotto;
            prodotti = newProdotti;
        }
    }

    /**
     * metodo che controlla attraverso il nome se il prodotte è gia presente
     *
     * @param prodotto .
     * @return .
     */
    public boolean checkProdotto(Prodotto prodotto) {
        for (Prodotto value : prodotti) {
            if (value.getNomeProdotto().equalsIgnoreCase(prodotto.getNomeProdotto())) {
                System.out.println("Prodotto già presente");
                return true;
            }
        }
        return false;
    }

    /**
     * metodo che aumenta la quantita di prodotto
     *
     * @param prodotto .
     */
    public void aumentaQuantita(Prodotto prodotto, int numeroAumento) {
        prodotto.setQuantita(prodotto.getQuantita() + numeroAumento);
    }
}
