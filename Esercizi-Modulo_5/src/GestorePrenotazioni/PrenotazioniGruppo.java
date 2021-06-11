package GestorePrenotazioni;

public class PrenotazioniGruppo extends Prenotazioni{
    private int numeroPosti;

    public PrenotazioniGruppo(String codice, int numeroPosti) {
        super(codice);
        this.numeroPosti = numeroPosti;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }
}
