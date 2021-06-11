package GestoreDiBevande;

public class Main {
    public static void main(String[] args) {
        Caffe caffe = new Caffe("Caffe", 0.5);
        Cappuccino cappuccino = new Cappuccino("Cappuccino", 1);
        DistributoreDiBevande distributoreDiBevande= new DistributoreDiBevande(10);
        distributoreDiBevande.caricaProdotto(caffe);
        distributoreDiBevande.caricaProdotto(cappuccino);
        distributoreDiBevande.inserisciImporto(5);
        distributoreDiBevande.scegliProdotto("caffe");
        distributoreDiBevande.saldoAttuale();
        distributoreDiBevande.getResto();

    }
}
