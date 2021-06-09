package ModuloExtra;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.io.File;

public class TimeLapsWebcam {

    public void helloWorld() throws  Exception{
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
    }
}
