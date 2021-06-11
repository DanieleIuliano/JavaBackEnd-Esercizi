package GestoreVeicoli;

public class Autocarro extends Veicolo {
    int caricoPortabile;

    public Autocarro(String targa, String marca, String modello, int numeroDiPosti, int caricoPortabile) {
        super(targa, marca, modello, numeroDiPosti);
        this.caricoPortabile = caricoPortabile;
    }

    @Override
    public String toString() {
        return "Autocarro{" +
                "caricoPortabile=" + caricoPortabile +
                ", targa='" + super.targa + '\'' +
                '}';
    }
}
