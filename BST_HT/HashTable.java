
/**
 * Miguel Angel Garcia Acosta
 * University of Texas at El Paso
 * 
 * Description: This class will load a given file, read it and compute it with
 * a hash value function that will limitedly do recursive calls if there is a collision in a hash table to store string elements with no punctuations,
 * and will search for specific elements (words) required, returning true for found and false for not found.
 * Thus, the hash function will handle the collisions in a different way if it reaches certain number of recursive calls.
 */

import java.io.File;
import java.util.Scanner;

public class HashTable {

    private String[] Table;

    /**
     * Initializes the Hash Table to Null entries before being populated given a String input equivalent to an existing file name
     * 
     * @param name String input
     * @throws Exception
     */
    HashTable(String name) throws Exception {
        this.Table = new String[Size(name)];

        for (int i = 0; i < Table.length; i++) {
            Table[i] = null;
        }

        this.Table = File(name, Table);
    }

    /**
     * Returns an int size equivalent to the total words in given File (if existent)
     * 
     * @param filename String input
     * @return return
     * @throws Exception
     */
    private int Size(String filename) throws Exception {
        File nameOfFile = new File(filename);
        Scanner fileScnr = new Scanner(nameOfFile);

        int i = 0;
        while (fileScnr.hasNextLine()) {
            String T = fileScnr.nextLine();
            Scanner SC = new Scanner(T);

            while (SC.hasNext()) {
                SC.next();
                i++;
            }
        }

        fileScnr.close();
        return i;
    }

    /**
     * Reads an existing file (if existent), and locates every scanned word to a String Array with no punctuations
     * 
     * @param filename String input
     * @param toStore String Array input
     * @return return
     * @throws Exception
     */
    private String[] File(String filename, String[] toStore) throws Exception {
        File nameOfFile = new File(filename);
        Scanner fileScnr = new Scanner(nameOfFile);

        while (fileScnr.hasNextLine()) {

            String T = fileScnr.nextLine();
            // System.out.println(T);
            Scanner SC = new Scanner(T);

            while (SC.hasNext()) {
                String Temp = SC.next();

                Temp = Temp.toLowerCase();
                Temp = filter(Temp);

                if (!isRepeated(Temp)) {
                    System.out.println("Placing: " + Temp);
                    Handle(Temp, 0, 0);
                }
            }
        }

        fileScnr.close();
        return toStore;
    }

    /**
     * Transforms a String type input to an integer, returning the String integer equivalent (String Key)
     * 
     * @param Temp String input
     * @return return
     */
    private int key(String Temp) {
        int n = 0;
        char[] TempChar = Temp.toCharArray();
        for (char x : TempChar) {
            n = (int) x + n;
        }

        return n;
    }

    /**
     * Handles a collision with limited recursive calls, if the calls are bigger or
     * equal to 30, it will handle the collision in a different way
     * 
     * @param Temp String input
     * @param i    Linear Hash Function modifier
     * @param e    Number of Recursive Calls
     */
    private void Handle(String Temp, int i, int e) {

        if (e >= 30) {
            Handle(Temp);
            return;
        }

        if ((key(Temp) + i) % Table.length <= Table.length && (key(Temp) + i) % Table.length >= 0) {
            if (Table[(key(Temp) + i) % Table.length] == null) {
                if (isRepeated(Temp))
                    return;

                Table[(key(Temp) + i) % Table.length] = Temp;
            } else {
                Handle(Temp, i + 1, e + 1);
            }
        }
    }

    /**
     * Searches for and element in the Hash Table, if existent return true else return false
     * 
     * @param Temp input String
     * @return return
     */
    private Boolean Locate(String Temp) {

        for (String var : this.Table) {
            if (var != null && var.equals(Temp))
                return true;
        }

        return false;
    }

    /**
     * Handles Hash function in Powers of i^3, and stores an empty space (if found) with a given String input
     * 
     * @param Temp String input
     */
    private void Handle(String Temp) {

        int i = 0;
        Boolean Empty = true;

        for (int C = 0; C < this.Table.length; C++) {
            if (Table[i] == null) {
                Empty = false;
            }
        }

        if (!Empty) {
            while (((key(Temp) + Math.pow(i, 3)) % Table.length >= 0
                    && (key(Temp) + Math.pow(i, 3)) % Table.length <= Table.length - 1) || i >= 5) {

                if ((key(Temp) + (int) Math.pow(i, 3)) % Table.length >= 0) {

                    if (Table[(key(Temp) + (int) Math.pow(i, 3)) % Table.length] == null) {

                        Table[(key(Temp) + (int) Math.pow(i, 3)) % Table.length] = Temp;
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }

    }

    /**
     * Checks if there are repeated elements in the Hash Table, returns true for repeated, and false if not repeated
     * 
     * @param e String input
     * @return return
     */
    private Boolean isRepeated(String e) {

        for (int i = 0; i < this.Table.length; i++) {
            if (this.Table[i] != null)
                if (this.Table[i].equals(e))
                    return true;
        }

        return false;
    }

    /**
     * Removes all punctuations from a given String input, and returns a non-punctuated String (with spaces if they exist)
     * 
     * @param T String input
     * @return return
     */
    private String filter(String T) {
        String tofilter = "";

        for (char x : T.toCharArray()) {
            Boolean range = false;

            if ((int) x == 32)
                range = true;

            for (int i = 97; i < 122; i++) {
                if ((int) x == i)
                    range = true;
            }

            if (range)
                tofilter = tofilter + x;
        }

        return tofilter;
    }

    /**
     * Prints the Hash Table
     * 
     */
    void Print() {
        int k = 0;
        for (int i = 0; i < this.Table.length; i++) {
            if (Table[i] == null) {
                System.out.print("[" + i + "]" + "null");
            } else {
                System.out.println("[" + i + "]" + Table[i]);
            }

            if (k > 1) {
                System.out.println();
                k = 0;
            } else {
                System.out.print("\t\t\t");
                k++;
            }

        }
    }

    /**
     * Searches for a word(String) in the Hash Table given a String input
     * 
     * @param word String input
     * @return return
     */
    Boolean Search(String word) {

        if (key(word) % this.Table.length >= 0 && key(word) % this.Table.length < this.Table.length) {
            if(Table[key(word) % Table.length] != null)
                if (Table[key(word) % Table.length].equals(word)) 
                    return true;
        }

        return (Locate(word) == true) ? true : false;
    }

    /**
     * Returns the Hash Table String Array
     * 
     * @return return
     */
    String[] Transfer() {
        return this.Table;
    }
}
