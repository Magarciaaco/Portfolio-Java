
/**
 * UNIVERSITY OF TEXAS AT EL PASO
 * CS1101 â€“ Computer Science
 * Instructor: Akbar
 * 
 * Screen_Replacer, Modified by: Miguel Angel Garcia Acosta
 * If included source code is to be used in another source code, give attribution to the source code as comment.
 * 
 * SOURCE CODE: UTEP's CS1101 Intro to Computer Science Lab Course: Instructor - Akbar, File Name: LastName_AwesomeGreenScreenReplacer.java
 * 
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;

public class Screen_Replacer {
    public static void main(String[] args) throws Exception {

        replaceGreenPixels(readImage("GreenScreen.jpg"), readImage("Background.jpg"));

    }

    public static boolean isGreenPixel(int red, int green, int blue) {
        if (red >= 50 && green >= 150 && blue >= 0) {
            return true;
        } else
            return false;
    }

    public static Color[][] replaceGreenPixels(Color[][] greenScreenImg, Color[][] backgroundImg) {
        Color[][] TemporalArray = new Color[backgroundImg.length][backgroundImg[0].length];

        for (int Rows = 0; Rows < backgroundImg.length; Rows++) {
            for (int Columns = 0; Columns < backgroundImg[0].length; Columns++) {
                if (isGreenPixel(greenScreenImg[Rows][Columns].getRed(), greenScreenImg[Rows][Columns].getGreen(),
                        greenScreenImg[Rows][Columns].getBlue())) {
                    TemporalArray[Rows][Columns] = backgroundImg[Rows][Columns];
                } else {
                    TemporalArray[Rows][Columns] = greenScreenImg[Rows][Columns];
                }
            }
        }

        displayImage(TemporalArray);

        return null;
    }

    public static void displayImage(Color[][] imagePixels) {
        BufferedImage image = createImageFromPixelArray(imagePixels);

        ImageIcon icon = new ImageIcon(image);

        JFrame frame = new JFrame();
        frame.setTitle("WoW");
        frame.setLayout(new FlowLayout());
        frame.setSize(590, 350);

        JLabel lbl = new JLabel();
        lbl.setIcon(icon);

        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }

    public static Color[][] readImage(String filePath) throws Exception {
        File imageFile = new File(filePath);
        BufferedImage image = ImageIO.read(imageFile);
        Color[][] colors = new Color[image.getWidth()][image.getHeight()];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                colors[x][y] = new Color(image.getRGB(x, y));
            }
        }
        return colors;
    }

    public static BufferedImage createImageFromPixelArray(Color[][] imagePixels) {
        BufferedImage image = new BufferedImage(imagePixels.length, imagePixels[0].length, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.setRGB(x, y, imagePixels[x][y].getRGB());
            }
        }
        return image;
    }
}
