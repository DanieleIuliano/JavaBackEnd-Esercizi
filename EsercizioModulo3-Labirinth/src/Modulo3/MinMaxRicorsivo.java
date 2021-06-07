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
        int max = 0;
        max = maxRicorsivo(array, 0, max);
        System.out.println(max);
        int min = array[0];
        min = minRicorsivo(array, 0, min);
        System.out.println(min);
    }

    public static int maxRicorsivo(int[] array, int pos, int max) {
        if (pos >= array.length) {
            return max;
        }
        if (array[pos] > max) {
            max = array[pos];
        }

        return maxRicorsivo(array, pos + 1, max);
    }

    public static int minRicorsivo(int[] array, int pos, int min) {
        if (pos >= array.length) {
            return min;
        }
        if (array[pos] < min) {
            min = array[pos];
        }

        return minRicorsivo(array, pos + 1, min);
    }
}

