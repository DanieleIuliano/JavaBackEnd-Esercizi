package ModuloExtra;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TimeLapsWebcam {
    public static void main(String[] args) throws Exception {
        Filtraggio filtra = new Filtraggio();
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        webcam.open();
        BufferedImage [] immagini = new BufferedImage[3];
        for(int i = 0; i < 3 ;i++){
            immagini[i] = webcam.getImage();
        }
        filtra.filtroGBR(immagini[0]);
        writeGif(immagini,500,"image/gifCreata.gif");
    }


    private static boolean writeGif(BufferedImage[] captures, int millisPerFrame, String filename) {
        ImageOutputStream output;
        try {
            output = new FileImageOutputStream(new File(filename));
            GifSequenceWriter writer =
                    new GifSequenceWriter(output, 5, millisPerFrame, true);
            for (BufferedImage image : captures)
                writer.writeToSequence(image);
            writer.close();
            output.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }



}


