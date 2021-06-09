package ModuloExtra;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GreenScreen {
    public void SovrapponiImmagini() throws Exception {
        BufferedImage imageIniziale = ImageIO.read(new File("image/zeb89.jpg"));
        BufferedImage imageDaSovrapporre = ImageIO.read(new File("image/aot.jpg"));

        //creo l'immagine finale
        BufferedImage immagineFinale = new BufferedImage(imageIniziale.getWidth(), imageIniziale.getHeight(), BufferedImage.TYPE_3BYTE_BGR);


        for (int x = 0; x < imageIniziale.getWidth(); x++) {
            for (int y = 0; y < imageIniziale.getHeight(); y++) {
                Color coloreImmIniziale = new Color(imageIniziale.getRGB(x, y));
                Color coloreImmSovrapp = new Color(imageDaSovrapporre.getRGB(x, y));

                //colori Immagine iniziale
                int r = coloreImmIniziale.getRed();
                int b = coloreImmIniziale.getBlue();
                int g = coloreImmIniziale.getGreen();

                //170 è stato scelto con vari tentativi
                if (checkDistanza(r,b,g,48,17,255) < 170 ) {
                    Color nuovoColore = new Color(coloreImmSovrapp.getRGB());
                    immagineFinale.setRGB(x, y, nuovoColore.getRGB());
                } else {
                    Color coloreIniziale = new Color(coloreImmIniziale.getRGB());
                    immagineFinale.setRGB(x, y, coloreIniziale.getRGB());
                }

            }
        }
        ImageIO.write(immagineFinale, "jpg", new File("image/GreenScreenMeme.jpg"));
    }

    public int checkDistanza(int r,int b, int g, int rI, int bI, int gI) {

        int distanza = (int) Math.sqrt(Math.pow(r - rI, 2) + Math.pow(b - bI, 2) + Math.pow(g - gI, 2));
            return distanza;
    }


}
