package ModuloExtra;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
    //Primo programma che crea l'immagine grigia
        Shadow_Gray immagine1 = new Shadow_Gray();
        immagine1.Creashadow_Gray();
        FiltriImmagini immagine2 = new FiltriImmagini();
        /*
        immagine2.FiltroBiancoNero();
        immagine2.filtroAspecchio();
        immagine2.filtroGBR();
        immagine2.filtroNegativo();
        immagine2.filtroposterize(3);
        */
        GreenScreen immagine3 = new GreenScreen();
        immagine3.SovrapponiImmagini();




    }
}
