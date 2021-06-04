package Modulo3;

public class EsMassimoProdotto {
    public static void main(String[] args) {
        int[] array = {8, 3, 5};
        int prodotto = massimoProdotto(array);
        System.out.println(prodotto);
    }

    public static int massimoProdotto(int[] array) {
        int risultato;
        int prodotto = 0;
        for (int j : array) {
            for (int k : array) {
                risultato = j * k;
                System.out.println(risultato);
                if (risultato > prodotto) {
                    prodotto = risultato;
                }
            }
        }
        return prodotto;

    }
}
