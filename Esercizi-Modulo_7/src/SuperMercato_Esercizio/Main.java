package SuperMercato_Esercizio;

public class Main {
    public static void main(String[] args) {
        Cliente num1 = new Cliente("Daniele","Iuliano",18);
        Cliente num2 = new Cliente("Raffa","Pellecchia",20);
        Cliente num3 = new Cliente("gaio","Pisello",30);
        Supermercato sisa = new Supermercato();
        sisa.addCliente(num1);
        sisa.addCliente(num2);
        sisa.addCliente(num3);
        sisa.stampaCoda();
        sisa.removeCliente();
        sisa.stampaCoda();

    }
}
