package GestorePrenotazioni;


import java.util.Arrays;

public class MiniGestorePrenotazioni {
    private int postInterni;
    private int postEsterni;
    Prenotazioni[] prenotazioni;
    private boolean GruppoFuori;

    public boolean isGruppoFuori() {
        return GruppoFuori;
    }

    public void setGruppoFuori(boolean gruppoFuori) {
        GruppoFuori = gruppoFuori;
    }

    public MiniGestorePrenotazioni(int postInterni, int postEsterni) {
        this.postInterni = postInterni;
        this.postEsterni = postEsterni;
    }

    public int getPostInterni() {
        return postInterni;
    }

    public void setPostInterni(int postInterni) {
        this.postInterni = postInterni;
    }

    public int getPostEsterni() {
        return postEsterni;
    }

    public void setPostEsterni(int postEsterni) {
        this.postEsterni = postEsterni;
    }

    public void addPrenotazione(Prenotazioni prenotazione) {
        if (prenotazioni == null) {

            prenotazioni = new Prenotazioni[1];
            prenotazioni[0] = prenotazione;

        } else {
            Prenotazioni[] newPrenotazioni = Arrays.copyOf(prenotazioni, prenotazioni.length + 1);
            newPrenotazioni[prenotazioni.length] = prenotazione;
            prenotazioni = newPrenotazioni;
        }
    }

    /**
     * Classe visibile al programmatore che valuta i casi
     * @param prenotazione .
     * @return true se effettua le prenotazioni
     */
    public  boolean prenota(Prenotazioni prenotazione){
        if (prenotazione instanceof PrenotazioneSingola){
            return prenotazioneSingola((PrenotazioneSingola) prenotazione);
        }else {
            return prenotazioneDiGruppo((PrenotazioniGruppo) prenotazione);
        }
    }

    private boolean prenotazioneSingola(PrenotazioneSingola prenotazione) {
        if (prenotazione.getTipoPrenotazione().equals(TipoPrenotazione.esterno)) {
            if (getPostEsterni() >= 1) {
                System.out.println("Hai prenotato un posto fuori");
                setPostEsterni(getPostEsterni() - 1);
                addPrenotazione(prenotazione);
                return true;
            } else System.out.println("Posti non disponibili fuori");
        } else {
            if (getPostInterni() >= 1) {
                System.out.println("Hai prenotato un posto dentro");
                setPostInterni(getPostInterni() - 1);
                addPrenotazione(prenotazione);
                return true;
            } else System.out.println("posto non disponibile nemmeno dentro");
        }
        return false;
    }

    /**
     * - prenota: data una Prenotazione p in input, se c’è posto nel ristorante viene accettata
     * restituendo true (dando precedenza alla preferenza indicata), altrimenti viene rifiutata restituendo false
     *
     * @param prenotazione .
     * @return spiegato sopra.
     */
    private boolean prenotazioneDiGruppo(PrenotazioniGruppo prenotazione) {
        if (getPostInterni() >= prenotazione.getNumeroPosti()) {
            System.out.println("hai prenotato per " + prenotazione.getNumeroPosti() + " persone  all'interno ");
            setPostInterni(getPostInterni() - prenotazione.getNumeroPosti());
            setGruppoFuori(true);
            addPrenotazione(prenotazione);
            return true;
        } else System.out.println("Non ci sono posti dentro proviamo fuori");
        if (getPostEsterni() >= prenotazione.getNumeroPosti()) {
            System.out.println("hai prenotato per " + prenotazione.getNumeroPosti() + " persone all'esterno ");
            setPostEsterni(getPostEsterni() - prenotazione.getNumeroPosti());
            setGruppoFuori(false);
            addPrenotazione(prenotazione);
            return true;
        } else System.out.println("non ci sono posti fuori ");

        return false;
    }


    public void terminaPrenotazione(Prenotazioni prenotazione) {
        for (int i = 0; i < prenotazioni.length; i++) {
            if (prenotazioni[i].getCodice().equals(prenotazione.getCodice())) {
                if (prenotazione instanceof PrenotazioneSingola) {
                    {
                        if (((PrenotazioneSingola) prenotazione).getTipoPrenotazione().equals(TipoPrenotazione.interno)) {
                            setPostInterni(getPostInterni() + 1);
                            System.out.println("Hai liberato un nuovo posto interno, n° posti interni: " + getPostInterni());
                        } else {
                            setPostEsterni(getPostEsterni() + 1);
                            System.out.println("Hai liberato un nuovo posto interno, n° posti interni: " + getPostEsterni());
                        }
                        return;
                    }
                } else {
                    //caso della prenotazione di gruppo
                    int numPostiLiberati = (((PrenotazioniGruppo) prenotazione).getNumeroPosti());
                    if (isGruppoFuori()) {
                        setPostInterni(getPostInterni() + numPostiLiberati);
                        System.out.println("Hai liberato all' interno "+ numPostiLiberati +", posti disponibili: " + getPostInterni());
                    } else {
                        setPostEsterni(getPostEsterni() + numPostiLiberati);
                        System.out.println("Hai liberato all'esterno "+ numPostiLiberati + ", posti disponibili " + getPostEsterni());
                    }
                    return;
                }
            }
        }
    }
}



