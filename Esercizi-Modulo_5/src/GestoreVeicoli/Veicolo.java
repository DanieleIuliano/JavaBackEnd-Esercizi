package GestoreVeicoli;

public abstract class Veicolo {
    String targa;
    String marca;
    String modello;
    int numeroDiPosti;

    public Veicolo(String targa, String marca, String modello, int numeroDiPosti) {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.numeroDiPosti = numeroDiPosti;
    }

}
