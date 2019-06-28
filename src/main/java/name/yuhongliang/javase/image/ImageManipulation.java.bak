package name.yuhongliang.javase.image;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * Created by andy on 16-11-4.
 */
public class ImageManipulation {
    public static BufferedImage loadImage(String ref) {
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(new File(ref));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimg;
    }

    public void loadAndDisplayImage(JFrame frame) {
        // Load the img
        //imagetest.gif
        BufferedImage loadImg = loadImage("/home/andy/Downloads/java-performance.jpg");
        frame.setBounds(0, 0, loadImg.getWidth(), loadImg.getHeight());
        // Set the panel visible and add it to the frame
        frame.setVisible(true);
        // Get the surfaces Graphics object
//        Graphics2D g = (Graphics2D)frame.getRootPane().getGraphics();
        // Now draw the image
//        g.drawImage(loadImg, 0, 0, null);



        BufferedImage aimg = new BufferedImage(loadImg.getWidth(), loadImg.getHeight(), BufferedImage.TRANSLUCENT);
        // Get the images graphics
        Graphics2D g = aimg.createGraphics();
        // Set the Graphics composite to Alpha
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        // Draw the LOADED img into the prepared reciver image
        g.drawImage(loadImg, null, 0, 0);
        // let go of all system resources in this Graphics
        g.dispose();

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(aimg, 0, 0, null);
            }
        };

        frame.add(pane);
    }

    public void resize(JFrame frame, int newW, int newH) {
        BufferedImage loadImg = loadImage("/home/andy/Downloads/java-performance.jpg");
        frame.setBounds(0, 0, loadImg.getWidth(), loadImg.getHeight());
        // Set the panel visible and add it to the frame
        frame.setVisible(true);


        int w = loadImg.getWidth();
        int h = loadImg.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, loadImg.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(loadImg, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(dimg, 0, 0, null);
            }
        };

        frame.add(pane);

    }

    public static void main(String[] args) throws IOException {
//        ImageManipulation ia = new ImageManipulation();
//        JFrame frame = new JFrame("Tutorials");
////        ia.loadAndDisplayImage(frame);
//        ia.resize(frame,100,200);

//        File input = new File("/home/andy/Downloads/imagetest.gif");
//        BufferedImage image = ImageIO.read(input);

        /*File compressedImageFile = new File("/home/andy/Downloads/compress.gif");
        OutputStream os =new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers =  ImageIO.getImageWritersByFormatName("gif");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.05f);
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();*/

        int width = 200, height = 200;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D ig2 = bi.createGraphics();
        ig2.fillRect(0, 0, width - 1, height - 1);

        Iterator imageWriters = ImageIO.getImageWritersByFormatName("GIF");
        ImageWriter imageWriter = (ImageWriter) imageWriters.next();
        File file = new File("/home/andy/Downloads/filename.gif");
        ImageOutputStream ios = ImageIO.createImageOutputStream(file);
        imageWriter.setOutput(ios);
        imageWriter.write(bi);

        resize(100,200);

    }



    /**
     * 强制压缩/放大图片到固定的大小
     * @param w int 新宽度
     * @param h int 新高度
     */
    public static void resize(int w, int h) throws IOException {
        File input = new File("/home/andy/Downloads/main-qimg-fe0721372b54f83d55bbc60a723235b5.png");
        BufferedImage img = ImageIO.read(input);
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        File destFile = new File("/home/andy/Downloads/compress.png");
        FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
        // 可以正常实现bmp、png、gif转jpg
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image); // JPEG编码
        out.close();
    }

}
