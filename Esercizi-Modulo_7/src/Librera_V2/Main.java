package Librera_V2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Libro lib1 = new Libro("Libro bello","bel libro che abbiamo");
        Libro lib2 = new Libro("libro brutto", "libro brutto");
        Autore aut1 = new Autore("Daniele","Iuliano",new HashSet<Libro>());
        Biblioteca bib1 = new Biblioteca();
        bib1.addLibro(aut1,lib1);
        bib1.addLibro(aut1,lib2);
        System.out.println(lib1.getIdUnivoco());

    }
}
