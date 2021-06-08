package Modulo4_Biblioteca;

public class Main {
    public static void main(String[] args) {
        Libro[] libri = new Libro[7];
        libri[0]= new Libro(123);
        libri[1]= new Libro (4);
        libri[2]= new Libro(98);
        libri[3]=new Libro(33);
        libri[4]=new Libro(76);
        libri[5]=new Libro(2);
        libri[6]=new Libro(235);
        Biblioteca library = new Biblioteca(libri);
        library.esisteLibro(150);
        library.esisteLibro(4);
        library.ordinaLibri();
        library.stampaLibri();
    }
}
