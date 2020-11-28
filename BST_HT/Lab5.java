import java.io.File;
import java.util.Scanner;

/**
 * Miguel Angel Garcia Acosta
 * University of Texas at El Paso
 * 
 * Description: This class will be the main operator between the Binary Tree and Hash Table searches. It will prompt a menu to select the file to load, then select the type
 * of search that the user wants to do, and search for a word given by the user in the selected type of search. Finally, it will ask if the user wants to search for another
 * word.
 */
public class Lab5 {
    public static String name;

    /**
     * Main method, operates the menu and Hash table or Binary Tree word search with a menu, and a menu case selector
     * 
     * @param args args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        File File;
        Scanner SC = new Scanner(System.in);
        int i = 0;

        System.out.println("Welcome to Word File Searcher:\n\n");

        System.out.println("1: Select a file name to load: ");
        name = SC.next();
        File = new File(name + ".txt");

        while (!File.exists()) {
            System.out.println("Select a file name: ");
            name = SC.next();
            File = new File(name + ".txt");
        }

        Menu();
        i = SC.nextInt();
        boolean Check = CheckEntry(i);

        while (!Check) {
            System.out.println("Please, select a valid number for the menu: " + "\nSelect an option:\n"
                    + "\n2: Search via Binary Search Tree\n" + "\n3: Search via Hash Table");
            i = SC.nextInt();
            Check = CheckEntry(i);
        }

        Select_i(i);
    }

    /**
     * Prints the options menu
     * 
     */
    private static void Menu() {
        System.out.println(
                "\nSelect an option:\n" + "\n2: Search via Binary Search Tree\n" + "\n3: Search via Hash Table");

        System.out.print("\n Selection: ");
    }

    /**
     * Selects a specific case given a user option in the menu
     * 
     * @param in case selector
     * @throws Exception
     */
    public static void Select_i(int in) throws Exception {
        Scanner Select_ = new Scanner(System.in);
        String[] Transfer;
        String N = null;
        char n;

        switch (in) {
        case 2:  

            System.out.print("Transfering Hash Table data to Binary Tree:\n");
            HashTable HashTable = new HashTable(name + ".txt");
            Transfer = HashTable.Transfer();
            System.out.print(" Done\n");

            System.out.print("Loading " + name + " data:\n");
            BinarySearchTree BinarySearchTree = new BinarySearchTree(Transfer);
            System.out.print(" Done\n");

            System.out.print("\nSet a Word to Search: ");
            N = Select_.next();

            if (BinarySearchTree.Search(N)) {
                System.out.println(N + " is present on " + name);
            } else {
                System.out.println(N + " is not present on " + name);
            }

            System.out.print("Search for another word ? (Y/N):  ");
            N = Select_.next();
            n = N.toLowerCase().charAt(0);

            if (n == 'y') {
                do {
                    System.out.print("\nSet a Word to Search: ");
                    N = Select_.next();

                    if (BinarySearchTree.Search(N)) {
                        System.out.println(N + " is present on " + name);
                    } else {
                        System.out.println(N + " is not present on " + name);
                    }
                    System.out.print("Search for another word ? (Y/N):  ");
                    N = Select_.next();
                    n = N.toLowerCase().charAt(0);

                } while (n == 'y');
            }

            break;

        case 3:

            System.out.print("Loading " + name + " data:\n");
            HashTable HashTable0 = new HashTable(name + ".txt");
            // hTable.Print();
            System.out.print(" Done\n");
            System.out.print("\nSet a Word to Search: ");
            N = Select_.next();

            if (HashTable0.Search(N)) {
                System.out.println(N + " is present on " + name);
            } else {
                System.out.println(N + " is not present on " + name);
            }

            System.out.print("Search for another word ? (Y/N):  ");
            N = Select_.next();
            n = N.toLowerCase().charAt(0);

            if (n == 'y') {
                do {
                    System.out.print("\nSet a Word to Search: ");
                    N = Select_.next();

                    if (HashTable0.Search(N)) {
                        System.out.println(N + " is present on " + name);
                    } else {
                        System.out.println(N + " is not present on " + name);
                    }
                    System.out.print("Search for another word ? (Y/N):  ");
                    N = Select_.next();
                    n = N.toLowerCase().charAt(0);
                    
                } while (n == 'y');
            }

            break;

        default:
            System.out.println("Error");
            break;
        }
    }

    /**
     * Returns true if a selection for the menu exists else returns false
     * 
     * @param i int input
     * @return return
     */
    public static boolean CheckEntry(int i) {
        boolean OK;

        if (i == 2 || i == 3) {
            OK = true;
        } else
            OK = false;

        return OK;
    }

}