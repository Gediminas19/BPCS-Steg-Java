import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class StegResultProcessor {
    private Pixel[][] pixels;
    private int width, height;
    private String name;

    public StegResultProcessor(String name) {
        this.name = "StegResults/" + name;
    }

    public StegResultProcessor() {
        this("Result.png");
    }

    public void processPlanes(Plane[] planes) {
        height = planes[0].getHeight();
        width = planes[0].getWidth();
        pixels = new Pixel[height][width];

        for(int j = 0; j < height; j++) {
            for(int k = 0; k < width; k++) {
                int[] temp = new int[24];
                for(int i = 23; i >= 0; i--) temp[i] = (i > 20)? planes[i].getCGCBit(j, k) : planes[i].getCGCBit(j, k) ^ temp[i + 3]; //convert from CGC to BPC (must go from MSB to LSB)
                pixels[j][k] = new Pixel(temp);
            }
        }
    }

    public void constructImage() throws IOException {
        BufferedImage img = new BufferedImage(width, height, 2);

        for(int j = 0; j < height; j++) for(int k = 0; k < width; k++) img.setRGB(k, j, pixels[j][k].getRGB());
        //for every pixel, sets RGB to be based on our pixel array

        ImageIO.write(img, "png", new File(name));
    }
}
