package Modulo3;

/*
Esercizio Minimo e Massimo Ricorsivo 🛵

Scrivere una funzione ricorsiva che, dato un array a non ordinato di interi positivi e
negativi, trovi e stampi il minimo elemento e il massimo elemento dell'array a.

Esempio:
array: [40, 90, 130]
minMaxRecursive(array) deve stampare 40 e 130

 */
public class MinMaxRicorsivo {
    public static void main(String[] args) {
        int[] array = {40, 90, 130};
        int max = maxRicorsivo(array, 0);

        int min = minRicorsivo(array,0);
        System.out.println("Massimo e minimo : " + max + " , " +min);

    }

    //chiamata Ricorsiva
    public static int maxRicorsivo(int[] array, int pos) {
        if (pos == array.length - 1) {
            return array[pos];
        }
        return Math.max(array[pos], maxRicorsivo(array, pos + 1));

    }

    public static int minRicorsivo(int[] array, int pos) {
        if (pos == array.length - 1) {
            return array[pos];
        }
        return Math.min(array[pos], maxRicorsivo(array, pos + 1));

    }
}

