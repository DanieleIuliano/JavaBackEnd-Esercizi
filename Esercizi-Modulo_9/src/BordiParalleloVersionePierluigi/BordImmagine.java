package BordiParalleloVersionePierluigi;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class BordImmagine extends Thread{
    private final BufferedImage input;
    private final BufferedImage output;
    private final int leftCol;
    private final int rightCol;

    public BordImmagine(BufferedImage inputImage, BufferedImage outputImage, int startCol, int endCol) {
        this.input = inputImage;
        this.output = outputImage;
        this.leftCol = startCol;
        this.rightCol = endCol;
    }

    @Override
    public void run() {
        for(int row = leftCol; row < rightCol; row++)
            for(int col = 0; col < input.getHeight(); col++) {
                double sumNeighboors = 0;
                Color currentPixel = new Color(input.getRGB(row,col));

                /*
                      | n | n | n |
                      | n | p | n |
                      | n | n | n |
                      In questo loop calcolo la distanza del pixel con ogni suo vicino e sommo
                 */
                for(int internalX = -1; internalX < 2; internalX++)
                    for(int internalY = -1; internalY < 2; internalY++) {
                        if(internalX == 0 && internalX == internalY)
                            continue;
                        int neighboorI = row + internalX;
                        if(neighboorI < 0 || neighboorI >= input.getWidth())
                            continue;
                        int neighboorJ = col + internalY;
                        if(neighboorJ < 0 || neighboorJ >= input.getHeight())
                            continue;

                        Color pendingPixel = new Color(input.getRGB(neighboorI,neighboorJ));
                        sumNeighboors += colorDistance(currentPixel, pendingPixel);
                    }

                if (sumNeighboors > 255)
                    output.setRGB(row,col, new Color(0,0,0).getRGB());
                else
                    output.setRGB(row,col, new Color(255,255,255).getRGB());
            }
    }

    private static double  colorDistance(Color c1, Color c2){
        int redDifference = c1.getRed() - c2.getRed();
        int greenDifference = c1.getGreen() - c2.getGreen();
        int blueDifference = c1.getBlue() - c2.getBlue();
        return Math.sqrt(Math.pow(redDifference, 2) + Math.pow(greenDifference, 2) + Math.pow(blueDifference, 2));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedImage input = ImageIO.read(new File("gris.png"));
        BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        int imgWidth = input.getWidth();

        int[] threads = {1, 2, 4, 8, 16, 32, 64};

        for (int i : threads) {
            long startTime = System.currentTimeMillis();
            int u = imgWidth / i;
            BordImmagine[] arr = new BordImmagine[i];

            for (int j = 1; j <= arr.length; j++) {
                arr[j-1] = new BordImmagine(input, output, u * (j - 1), u * j);
                arr[j-1].start();
            }
            for (int j = 1; j <= arr.length; j++)
                arr[j-1].join();

            ImageIO.write(output, "png", new File("borderGris.png"));
            System.out.print("\nTempo di elaborazione con " + i + " threads: ");
            System.out.print(System.currentTimeMillis() - startTime);
            System.out.print(" ms");
        }
    }
}
