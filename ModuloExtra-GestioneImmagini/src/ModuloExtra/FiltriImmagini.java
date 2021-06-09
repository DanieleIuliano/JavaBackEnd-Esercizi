package ModuloExtra;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class FiltriImmagini {

    public void FiltroBiancoNero() throws Exception {
        //apre un immagine e la mette in immagineIniziale
        BufferedImage immagineIniziale = ImageIO.read(new File("image/freaked.jpg"));

        BufferedImage immagineModificata = new BufferedImage(immagineIniziale.getWidth(), immagineIniziale.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        int red;
        int blue;
        int green;
        int luma;
        //luma = 77R + 150G + 28B

        for (int x = 0; x < immagineModificata.getWidth(); x++) {
            for (int y = 0; y < immagineModificata.getHeight(); y++) {

                Color myColor = new Color(immagineIniziale.getRGB(x, y));
                red = (((myColor.getRed() * 77) / 255));
                blue = (((myColor.getGreen() * 150 / 255)));
                green = (((myColor.getBlue() * 28) / 255));

                //creo la tonalità di grigio (luma)
                luma = red + green + blue;
                Color newColor = new Color(luma, luma, luma);
                immagineModificata.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(immagineModificata, "jpg", new File("image/immagineFiltroBiancoNero.jpg"));
    }

    public void filtroAspecchio() throws Exception {
        //apre un immagine e la mette in immagineIniziale
        BufferedImage immagineIniziale = ImageIO.read(new File("image/freaked.jpg"));

        BufferedImage immagineModificata = new BufferedImage(immagineIniziale.getWidth(), immagineIniziale.getHeight(), BufferedImage.TYPE_3BYTE_BGR);


        for (int x = 0; x < immagineModificata.getWidth(); x++) {
            for (int y = 0; y < immagineModificata.getHeight(); y++) {
                Color myColor = new Color(immagineIniziale.getRGB(x, y));
                //parto dall'ultima posizione e sottraggo ogni pixel fino all'ultimo (-1) solo per le x
                immagineModificata.setRGB((immagineIniziale.getWidth() - x - 1), y, myColor.getRGB());
            }
        }
        ImageIO.write(immagineModificata, "jpg", new File("image/immagineFiltroaSpecchio.jpg"));
    }

    public void filtroGBR() throws Exception {
        //apre un immagine e la mette in immagineIniziale
        BufferedImage immagineIniziale = ImageIO.read(new File("image/freaked.jpg"));

        BufferedImage immagineModificata = new BufferedImage(immagineIniziale.getWidth(), immagineIniziale.getHeight(), BufferedImage.TYPE_3BYTE_BGR);


        for (int x = 0; x < immagineModificata.getWidth(); x++) {
            for (int y = 0; y < immagineModificata.getHeight(); y++) {
                Color myColor = new Color(immagineIniziale.getRGB(x, y));

                //creo la tonalità di grigio (luma)
                Color newColor = new Color(myColor.getGreen(), myColor.getBlue(), myColor.getRed());
                immagineModificata.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(immagineModificata, "jpg", new File("image/immagineFiltroGBR.jpg"));
    }

    public void filtroNegativo() throws Exception {
        //apre un immagine e la mette in immagineIniziale
        BufferedImage immagineIniziale = ImageIO.read(new File("image/freaked.jpg"));

        BufferedImage immagineModificata = new BufferedImage(immagineIniziale.getWidth(), immagineIniziale.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        int red = 0;
        int blue = 0;
        int green = 0;

        for (int x = 0; x < immagineModificata.getWidth(); x++) {
            for (int y = 0; y < immagineModificata.getHeight(); y++) {
                Color myColor = new Color(immagineIniziale.getRGB(x, y));

                red = 255 - myColor.getRed();
                blue = 255 - myColor.getBlue();
                green = 255 - myColor.getGreen();

                Color newColor = new Color(red, blue, green);
                immagineModificata.setRGB(x, y, newColor.getRGB());
            }
        }
        ImageIO.write(immagineModificata, "jpg", new File("image/immagineFiltroNegativo.jpg"));

    }

    public void filtroposterize(int num) throws Exception {
        //crea immagine
        BufferedImage imageIniziale = ImageIO.read(new File("image/freaked.jpg"));

        int y;
        int x;
        if (num > 255) {
            System.out.println("Hai inserito un livello troppo alto");
        } else {
            int dim = 255 / num;
            for (y = 0; y < imageIniziale.getHeight(); y++) {

                for (x = 0; x < imageIniziale.getWidth(); x++) {

                    Color color = new Color(imageIniziale.getRGB(x, y));


                    int r = getColorRedPosterize(color.getRed(), dim);
                    int g = getColorGreenPosterize(color.getGreen(), dim);
                    int b = getColorBluePosterize(color.getBlue(), dim);

                    Color newColor = new Color(r, g, b);

                    imageIniziale.setRGB(x, y, newColor.getRGB());

                }

            }
            ImageIO.write(imageIniziale, "jpg", new File("image/immaginePosterize.jpg"));
        }
    }

    private int getColorRedPosterize(int r, int dim) {
        int num = 0;
        for (int i = 0; i < 255; i++) {//i=0 num=4 -> 0
            //i=1 dim ->dim
            //
            if (i * dim <= r) {
                num = dim * i;

            }
        }
        return num;

    }

    private int getColorGreenPosterize(int g, int dim) {
        int num = 0;
        for (int i = 0; i < 255; i++) {//i=0 num=4 -> 0
            //i=1 dim ->dim
            //
            if (i * dim <= g) {
                num = dim * i;

            }
        }
        return num;

    }

    private int getColorBluePosterize(int b, int dim) {
        int num = 0;
        for (int i = 0; i < 255; i++) {//i=0 num=4 -> 0
            //i=1 dim ->dim
            //
            if (i * dim <= b) {
                num = dim * i;
            }
        }
        return num;

    }
}
