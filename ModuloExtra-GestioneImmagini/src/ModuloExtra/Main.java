package ModuloExtra;

public class Main {

    public static void main(String[] args) throws Exception {
    //Primo programma che crea l'immagine grigia
        Shadow_Gray immagine1 = new Shadow_Gray();
        immagine1.Creashadow_Gray();
        FiltriImmagini immagin2 = new FiltriImmagini();
        immagin2.FiltroBiancoNero();
        immagin2.filtroAspecchio();
        immagin2.filtroGBR();
        immagin2.filtroNegativo();
        immagin2.filtroposterize(3);

    }
}
