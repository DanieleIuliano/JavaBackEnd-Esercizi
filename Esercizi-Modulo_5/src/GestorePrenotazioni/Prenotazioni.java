package GestorePrenotazioni;

public abstract class Prenotazioni {
    private String codice;

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Prenotazioni(String codice) {
        this.codice = codice;
    }


}
