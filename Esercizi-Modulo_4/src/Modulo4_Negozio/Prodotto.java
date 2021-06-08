package Modulo4_Negozio;

public class Prodotto {
    private int quantita;
    private String nomeProdotto;
    private TipoProdotto tipo; //alimentari o non alimentari
    private float Prezzo;

    public Prodotto(int quantita, String nomeProdotto,float prezzo, TipoProdotto tipo) {
        this.quantita = quantita;
        this.nomeProdotto = nomeProdotto;
        this.tipo = tipo;
        this.Prezzo = prezzo;
    }

    public float getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(int prezzo) {
        Prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public TipoProdotto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProdotto tipo) {
        this.tipo = tipo;
    }
}
