package Modulo4_Lampadina;

public class Lampadina {
    private statoLampadina stato;
    private int contatore;
    static boolean corrente;


    //costruttore
    public Lampadina() {
        setStato(statoLampadina.spento);
        setCorrente(true);
    }

    public  boolean isCorrente() {
        return corrente;
    }

    public void setCorrente(boolean corrente) {
        Lampadina.corrente = corrente;
    }

    public int getContatore() {
        return contatore;
    }

    public void setContatore(int contatore) {
        this.contatore = contatore;
    }

    // get stato della lampadina
    public statoLampadina getStato() {
        return stato;
    }

    // set stato della lampadina
    public void setStato(statoLampadina stato) {
        this.stato = stato;
    }

    //metodi
    public void click(){
        if(getStato().equals(statoLampadina.spento) && corrente){
            System.out.println("Hai acceso la lampadina");
            setStato(statoLampadina.acceso);
            setContatore(contatore = contatore+1);
        }
        else if(getStato().equals(statoLampadina.acceso)) {
            System.out.println("Hai spento la lampadina");
            setStato(statoLampadina.spento);
            setContatore(contatore = contatore+1);
        }
        if(contatore >= 5){
            System.out.println("Hai rotto la lampadina");
            setStato(statoLampadina.rotto);
        }
    }

    public boolean checkStatusRotto(){
        if(stato.equals(statoLampadina.rotto)){
            return true;
        }else return false;
    }
}

 enum statoLampadina {
    acceso, spento, rotto;
}
