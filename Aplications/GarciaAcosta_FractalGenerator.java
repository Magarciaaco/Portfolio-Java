/* CS1101 â€“ Intro to Computer Science 
Instructor: Akbar
Recursion
By including my name below I confirm that:
-	I am submitting my original work.
-	If I include code obtained from another source or I received help I am giving attribution to those sources as comments.
-	This submission does not incur in any academic dishonesty practice as described in the course syllabus.
Modified and submitted by: [Miguel Angel Garcia Acosta] 
*/ 

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.Container;
import java.awt.Graphics2D;

public class GarciaAcosta_FractalGenerator extends JComponent{

	// JFrame Version
	private static final long serialVersionUID = 1L;

	private static JFrame frame;

	public static void main(String[] args){
		drawCanvas();
		Scanner SC = new Scanner(System.in);
		String FileName = null;
		System.out.print("Do you want to save the image? [Y/N]: ");
		if (SC.nextLine().equals("y")) {
			System.out.println("What is the name of the file: ");
			FileName = SC.nextLine();
			System.out.println("Saving: " + FileName);
			saveImage(FileName);
		} else if (SC.nextLine().equals("n")) {
			System.out.println("Not Saving: ");
		} else
		System.out.println("Thanks for using the fractal generator!");

		SC.close();
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
		//Set Center
		x = x + radius/4;
		y = y + radius/4;
		// Condition
		if(radius>20){
			// Set Half value for radius
			radius = radius/2;
			drawFractalUsingRecursion(x + radius, y, radius, g); // Draw to the Right
			drawFractalUsingRecursion(x - radius, y, radius, g); // Draw to the Left
			drawFractalUsingRecursion(x, y + radius, radius, g); // Draw Bottom
			drawFractalUsingRecursion(x, y - radius, radius, g); // Draw Top
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
        frame.getContentPane().add(new GarciaAcosta_FractalGenerator());
        frame.pack();
        frame.setSize(700, 680);
		frame.setVisible(true);
		// Prevent from Resize --> BUG if not implemented: Moving the Jframe size in a Circle Pattern
		frame.setResizable(false);
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
