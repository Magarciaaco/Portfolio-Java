/**
 * UNIVERSITY OF TEXAS AT EL PASO
 * CS1101 â€“ Computer Science
 * Instructor: Akbar
 * 
 * Fractal_FromCenter, Modified by: Miguel Angel Garcia Acosta
 * If included source code is to be used in another source code, give attribution to the source code as comment.
 * 
 * SOURCE CODE: UTEP's CS1101 Intro to Computer Science Lab Course: Instructor - Akbar
 * 
 */

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.Container;
import java.awt.Graphics2D;

public class Fractal_FromCenter extends JComponent{

	// JFrame Version
	private static final long serialVersionUID = 1L;

	private static JFrame frame;

	public static void main(String[] args) {
		drawCanvas();

		// Saving File
		System.out.println("Saving File");
		saveImage("fileName");

		// To compare a character under a scanner type using an if condition --> if ( Scanner.nextLine().equals("ANSWER_HERE_Yes_OR_No") ) { /* CODE HERE */ }

	}
	/**
	 * Draw a fractal image using recursion
	 * @param x      The x coordinate of the upper left corner of the oval to be drawn.
	 * @param y      The y coordinate of the upper left corner of the oval to be drawn.
	 * @param radius Radius of the circle
	 * @param g      Object used to draw on the canvas
	 */
	public static void drawFractalUsingRecursion(int x, int y, int radius, Graphics g){
		//Use the method "g.drawOval" to draw a circle
		//Parameters are x, y, width of the oval to draw, and height of the oval to draw
		//Use recursion to draw the rest of the circles
		g.drawOval(x, y, radius, radius);
		// Set Center
		x = (x + radius) - (3 * radius / 4);
		y = (y + radius) - (3 * radius / 4);
		// Condition
		if (radius > 20) {
			// Change Values of x, y to move the circles -- Method can be used multiple
			// times
			drawFractalUsingRecursion(x, y, radius / 2, g);
			/* CODE HERE */
		}
	}

	//Do not change anything below this line
	//
	//
	//Do not change anything below this line

	/**
	 * Paints the container
	 * @param g Auto-generated variable to paint to the container
	 */
	@Override
	public void paint(Graphics g) {
		int initialRadius = 300;
		int x = (int) (frame.getSize().getWidth() / 2 - initialRadius / 2);
		int y = (int) (frame.getSize().getHeight() / 2 - initialRadius / 2);
		drawFractalUsingRecursion(x, y, initialRadius, g);
	}

	/**
	 * This method will create a canvas with the given width and height
	 */
	public static void drawCanvas(){
		frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new Fractal_FromCenter());
        frame.pack();
        frame.setSize(700, 680);
		frame.setVisible(true);
	}
	/**
	 * This method saves a given image to disk
	 * 
	 * @param imagePixels Image to be saved
	 * @param fileName	  Name of the file
	 */
	public static void saveImage(String fileName) 
	{
		if(!fileName.endsWith(".jpg"))
			fileName += ".jpg";
		try {			
			Container content = frame.getContentPane();
            BufferedImage bi = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bi.createGraphics();
            content.printAll(g2d);
            g2d.dispose();

		    //Save file
		    File outputfile = new File(fileName);
		    ImageIO.write(bi, "jpg", outputfile);
		} catch (IOException e) {
		    System.out.println("Error: " + e.toString());
		}
	}
}
