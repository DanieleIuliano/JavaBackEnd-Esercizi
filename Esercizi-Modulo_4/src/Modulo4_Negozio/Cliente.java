package Modulo4_Negozio;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Cliente {
    private String nomeCliente;
    private int puntiCartaFedelta;
    private int eta;

    public Cliente(String nomeCliente, int eta, int puntiCartaFedelta) {
        this.nomeCliente = nomeCliente;
        this.eta = eta;
        this.puntiCartaFedelta = puntiCartaFedelta;
    }

    /**
     * Metodo che vede se è possibile fare lo sconto anziani, usa la libreria calendare per vedere
     * se il giorno == 1(lunedi) o == 3 (mercoledi)
     * @param prodotto .
     * @return
     */
    public boolean ScontoAnziani(Prodotto prodotto){
        Calendar cal = Calendar.getInstance();
        if(getEta() > 60 && prodotto.getTipo().equals(TipoProdotto.alimentari)){
            if(cal.get(Calendar.DAY_OF_WEEK) == 1 || cal.get(Calendar.DAY_OF_WEEK) == 3){
                System.out.println("Hai diritto allo sconto anziani del lunedi/mercoledi ");
                return true;
            }
        }return false;
    }


    public void acquistaProdotto(Negozio negozio, Prodotto prodotto) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Quante ne vuoi comprare ");
        int quantita = scan.nextInt();

        if (quantita <= prodotto.getQuantita()) {

            float somma = prodotto.getPrezzo() * quantita;

            if (usiCarataFedelta()) {
                // controllo se posso fare lo sconto anziani
                if(ScontoAnziani(prodotto)){
                    somma = somma-((somma*20)/100);
                }
                float sconto = usaPuntiCartafedelta();
                System.out.println("Devi pagare " + (somma - sconto));
                aumentoCartaFedelta((somma - sconto));
                System.out.println(getPuntiCartaFedelta());
                rateizzaIltuoPagamento((somma - sconto));

            } else {
                //controllo se posso fare lo sconto anziani
                if(ScontoAnziani(prodotto)){
                    somma = somma-((somma*20)/100);
                }
                System.out.println("Devi pagare " + somma);
                negozio.rimuoviQuantita(prodotto, quantita);
                aumentoCartaFedelta(somma);
                System.out.println("Punti attuali " + getPuntiCartaFedelta());
                rateizzaIltuoPagamento((somma));
            }

        } else System.out.println("Non abbiamo tutto questo prodotto");

    }

    public boolean usiCarataFedelta() {
        Scanner scan = new Scanner(System.in);
        System.out.print("vuoi usare la carta fedeltà 1(si) 2(no) default (no)");
        int scelta = scan.nextInt();

        if (scelta == 1) {
            return true;
        } else return false;

    }

    public void aumentoCartaFedelta(float somma) {
        while (somma >= 10) {
            setPuntiCartaFedelta(getPuntiCartaFedelta() + 1);
            somma = somma - 10;
        }
    }

    public float usaPuntiCartafedelta() {
        float sconto = 0;

        while (getPuntiCartaFedelta() > 10) {
            sconto = sconto + 1;
            setPuntiCartaFedelta(getPuntiCartaFedelta() - 10);
        }

        return sconto;
    }

    public void rateizzaIltuoPagamento(float somma) {
        Scanner scan = new Scanner(System.in);
        System.out.print("vuoi rateizzare il tuo pagamento 1(si) 2(no) default (no)");
        int scelta = scan.nextInt();

        if (scelta == 1) {
            System.out.println("Scegli in quanti mesi pagare (max 12) : ");
            int sceltaMesi = scan.nextInt();

            if (sceltaMesi <= 12 && sceltaMesi > 0) {
                calcolaInteressi(sceltaMesi, somma);
            } else System.out.println("inserito valore scorretto");
        } else return;
    }

    public void calcolaInteressi(int mesi, float somma) {
        somma = (somma / mesi) + ((((0.5f * somma) / 100)) * mesi);
        System.out.println("Dovrai pagarmi ogni mese : " + somma + " per un totale di " + mesi);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getPuntiCartaFedelta() {
        return puntiCartaFedelta;
    }

    public void setPuntiCartaFedelta(int puntiCartaFedelta) {
        this.puntiCartaFedelta = puntiCartaFedelta;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
