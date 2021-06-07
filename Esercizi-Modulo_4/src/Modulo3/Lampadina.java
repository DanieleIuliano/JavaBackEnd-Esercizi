package Modulo3;

public class Lampadina {
    private statoLampadina stato;
    private int contatore;

    public int getContatore() {
        return contatore;
    }

    public void setContatore(int contatore) {
        this.contatore = contatore;
    }

    //costruttore
    public Lampadina() {
        setStato(statoLampadina.spento);
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
        if(getStato().equals(statoLampadina.spento)){
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

    public void checkStatus(){
        System.out.println(getStato());
    }
}

enum statoLampadina {
    acceso, spento, rotto;
}
