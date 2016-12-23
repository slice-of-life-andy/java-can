package name.yuhongliang.javase.image;

import org.imgscalr.Scalr;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.imgscalr.Scalr.OP_ANTIALIAS;

/**
 * Created by andy on 16-11-4.
 */
public class ImageManipulation {

    public static BufferedImage loadImage(String ref) {
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File(ref));
        } catch (Exception e) {
            System.out.println("exception:");
            e.printStackTrace();
        }
        System.out.print(bimg == null);

        return bimg;
    }

    public static BufferedImage createThumbnail(BufferedImage img) {
    // Create quickly, then smooth and brighten it.
    img = Scalr.resize(img, Scalr.Method.SPEED, 125, OP_ANTIALIAS);

    // Let's add a little border before we return result.
    return Scalr.pad(img, 4);
}
    public static void main(String[] args) throws IOException {
        BufferedImage loadImg = loadImage("/home/andy/Downloads/2008-music-at-southampton-stony-brook-university.jpg");
//        BufferedImage thumbnail = createThumbnail(loadImg);
        BufferedImage resizedImage = Scalr.resize(loadImg,300);

        File file = new File("/home/andy/Downloads/filename.jpg");
        ImageOutputStream ios = ImageIO.createImageOutputStream(file);

        ImageWriter writer = (ImageWriter) ImageIO.getImageWritersByFormatName("jpeg").next();

       /* ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(1.0f); // Change this, float between 0.0 and 1.0*/

        writer.setOutput(ios);
        writer.write(null, new IIOImage(resizedImage, null, null), null);
        writer.dispose();
    }
}
