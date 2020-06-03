package renderer;

import org.junit.Test;
import renderer.ImageWriter;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * test for image write
 */
public class ImageWriterTest {
    /**
     * Test methods for image writer
     * {@link renderer.ImageWriter#writePixel(int, int, Color), writeToImage()}.
     */
    @Test
    public void testFirstImage() {
        // Test create new image (10*16 squares) and paint by write pixel
        ImageWriter imageWriter = new ImageWriter("myImage", 1600, 1000, 800, 500);
        for (int i = 0; i < 800; i++)
            for (int j = 0; j < 500; j++) {
                if (i % 50 == 0 || j % 50 == 0)
                    imageWriter.writePixel(i, j, Color.black);
                else
                    imageWriter.writePixel(i, j, Color.BLUE);
            }
        imageWriter.writeToImage();
    }
}