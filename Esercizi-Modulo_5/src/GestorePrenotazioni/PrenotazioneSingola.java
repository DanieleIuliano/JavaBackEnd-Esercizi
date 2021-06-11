package GestorePrenotazioni;

public class PrenotazioneSingola extends Prenotazioni{
    private TipoPrenotazione tipoPrenotazione;

    public TipoPrenotazione getTipoPrenotazione() {
        return tipoPrenotazione;
    }

    public void setTipoPrenotazione(TipoPrenotazione tipoPrenotazione) {
        this.tipoPrenotazione = tipoPrenotazione;
    }

    public PrenotazioneSingola(String codice, TipoPrenotazione tipoPrenotazione) {
        super(codice);
        this.tipoPrenotazione = tipoPrenotazione;
    }
}
