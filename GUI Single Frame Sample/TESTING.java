/**
 * UNIVERSITY OF TEXAS AT EL PASO
 * CS1101 â€“ Intro to Computer Science
 * Instructor: Akbar
 * 
 * GUI Example, Coded by: Miguel Angel Garcia Acosta
 * If included source code is to be used in another source code, give attribution to the source code as comment.
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 * Program Description:
 * 
 * public class TESTING  extends JFrame --> Implements GUI Main Frame
 *      -TESTING() --> GUI Elements
 * public static void main(String[] args) --> Main Void
 *      -Loads TESTING --> GUI
 */

public class TESTING  extends JFrame {

    private JLabel TLabel;
    // Implement Version --> JFrame
    public static final long serialVersionUID = 1L;

    TESTING() {
        // Used to specify GUI component layout
        GridBagConstraints LayoutConstructor = null;

        // Set Frame Title
        setTitle("TEST TITLE");

        // Use Layout GridBag
        setLayout(new GridBagLayout());
        LayoutConstructor = new GridBagConstraints();

        // Set Elements Labels and Operators
        TLabel = new JLabel();
        TLabel.setText("TEST LABEL");

        /* ELEMENTS HERE: Child Elements */
        
        // Child 1 -- User Name 0,0
        LayoutConstructor.gridx = 0;
        LayoutConstructor.gridy = 0;
        LayoutConstructor.insets = new Insets(10, 10, 10, 10); // Padding of Grid Element -- 10 pixels
        add(TLabel, LayoutConstructor);

        // Prevent from resizing
        setResizable(false);

        // Resize Window to fit
        pack();
        setSize(500, 500);
        setResizable(true);

        // Set determinant when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    public static void main(String[] args) {
        // Initialize Main Frame --> JFrame from: TESTING class
        System.out.println("Initializing: Main Frame Window");
        TESTING TESTING = new TESTING();
        // Set Visibility || Display: Enabled
        TESTING.setVisible(true);
    }
}