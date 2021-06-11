package GestoreVeicoli;

public class Automobile extends Veicolo{
    int numeroPorte;

    public Automobile(String targa, String marca, String modello, int numeroDiPosti, int numeroPorte) {
        super(targa, marca, modello, numeroDiPosti);
        this.numeroPorte = numeroPorte;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "numeroPorte=" + numeroPorte +
                ", targa='" + super.targa + '\'' +
                '}';
    }
}
