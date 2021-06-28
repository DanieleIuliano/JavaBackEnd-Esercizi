package SommaThread;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        Generatore gen = new Generatore(array);
        gen.addElementi(array);
        Sommatore s1 = new Sommatore(array,0,500000);
        Sommatore s2 = new Sommatore(array,500000,1000000);
        s1.start();
        s2.start();
        System.out.println(s1.somma);
        System.out.println(s2.somma);
        int sommaFinale = s1.somma+ s2.somma;
        System.out.println(sommaFinale);
    }
}
