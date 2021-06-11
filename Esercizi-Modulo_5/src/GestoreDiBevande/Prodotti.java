package GestoreDiBevande;

public abstract class  Prodotti {
     String codice;
     double prezzo;

    public Prodotti(String codice, double prezzo) {
        this.codice = codice;
        this.prezzo = prezzo;
    }

}
