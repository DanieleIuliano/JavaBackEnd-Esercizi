package Modulo3;
/*
Esercizio Lista Ordinata 🛵

Progettare una classe ListaOrdinata, che implementa una lista di interi ordinata per grandezza. Gli interi sono memorizzati all’interno di un array

La classe deve implementare i metodi:

- insert(int x): deve inserire nell’array il valore passato, ma deve
 assicurarsi anche che l’array mantenga l’ordinamento per grandezza e deve gestire il caso in cui l’array si riempia e sia necessario inserire un elemento aggiuntivo
- indexOf(int x): deve tornare l’indice nel quale è presente l’intero x. Cercare di implementare il funzionamento mediante la ricerca binaria
- remove(int x): deve rimuovere l’intero x. Cercate di implementarlo nella maniera più efficiente

Esempio:
array: [40, 90, 130]
```
insert(100)
indexOf(130) = 3
```

Scrivere infine un main per testare le funzioni della classe
 */

import java.util.Arrays;

public class ListaOrdinata {
    int[] array;

    public ListaOrdinata(int[] array) {
        this.array = array;
    }

    public void insertArray(int x){

        int[] newArray = new int [array.length+1];
        int i = 0;

        while(i < array.length){

            if(array[i] >= x){

                newArray[i] = x;
                i++;
                break;

            }

            newArray[i] = array[i];
            i++;

        }

        if(i == array.length){

            newArray[i] = x;
            array = null;
            array = newArray;
            return;

        }
        //riparte dall'ultimo valore di i
        for(; i < array.length + 1; i++)

            newArray[i] = array[i - 1];

        array = null;
        this.array = newArray;

    }

    public int indexArray(int x) {
        return Arrays.binarySearch(array, x);
    }

    public void remove(int x) {
        int index = Arrays.binarySearch(array, x);
        int[] anotherArray = new int[array.length - 1];
        System.arraycopy(array, 0, anotherArray, 0, index);
        System.arraycopy(array, index + 1, anotherArray, index, array.length - index - 1);
        array = anotherArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        ListaOrdinata listaMia = new ListaOrdinata(array);
        System.out.println(listaMia.indexArray(4) + 1);
        listaMia.insertArray(4);
        System.out.println(Arrays.toString(listaMia.array));
        listaMia.remove(3);
        System.out.println(Arrays.toString(listaMia.array));

    }

}
