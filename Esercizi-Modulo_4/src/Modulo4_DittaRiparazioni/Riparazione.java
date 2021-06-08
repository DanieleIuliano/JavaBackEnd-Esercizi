package Modulo4_DittaRiparazioni;

public class Riparazione {
    private String indirizzo;
    private int prioritaIntervento;
    private StatoRiparazione stato;

    /**
     * Costruttore classe riparazione
     *
     * @param indirizzo          .
     * @param prioritaIntervento .
     * @param stato              .
     */
    public Riparazione(String indirizzo, int prioritaIntervento, StatoRiparazione stato) {
        this.indirizzo = indirizzo;
        this.prioritaIntervento = prioritaIntervento;
        this.stato = stato;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getPrioritaIntervento() {
        return prioritaIntervento;
    }

    public void setPrioritaIntervento(int prioritaIntervento) {
        this.prioritaIntervento = prioritaIntervento;
    }

    public StatoRiparazione getStato() {
        return stato;
    }

    public void setStato(StatoRiparazione stato) {
        this.stato = stato;
    }


}
