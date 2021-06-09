package ModuloExtra;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Shadow_Gray {

    public void Creashadow_Gray() throws Exception{
        //crea un immagine
        BufferedImage outputImage = new BufferedImage(256, 256, BufferedImage.TYPE_3BYTE_BGR);

        for (int i = 0; i < outputImage.getWidth(); i++){

            for(int j = 0; j < outputImage.getHeight(); j++){

                if(i <= j){

                    Color pixel = new Color(j, j, j);
                    outputImage.setRGB(j, i, pixel.getRGB());
                    continue;

                }

                Color pixel = new Color(i, i, i);
                outputImage.setRGB(j, i, pixel.getRGB());

            }

        }

        //salva l'immagine
        ImageIO.write(outputImage, "jpg", new File("image/immagineRossa.jpg"));
    }


}
