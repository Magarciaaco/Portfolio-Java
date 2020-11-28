
/**
 * Miguel Angel Garcia Acosta
 * University of Texas at El Paso
 * 
 * Description: This class will store String elements into a Binary Tree, 
 * and will search for specific elements (words) required, returning true for found and false for not found.
 * Thus, the handle operation will be manipulated with a queue Qn.
 */

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTree {

    private Node Node;
    private Queue<Node> Qn;

    /**
     * Adds elements from a type String array to the tree, checks for: non-null
     * elements in the input String array
     * 
     * @param Transfer String type array input
     */
    BinarySearchTree(String[] Transfer) {
        for (String Transfered : Transfer) {
            if (Transfered != null) {
                System.out.println("Transfering: " + Transfered);
                B_add(Transfered);
            }
        }
    }

    /**
     * Adds a new element in the tree using a queue, and a String type input
     * 
     * @param word String input
     */
    private void B_add(String word) {
        if (Node == null)
            Node = new Node(word);

        Node Temp = Node;
        Qn = new LinkedList<Node>(); // Queue initialized with Linked List - Node

        Qn.add(Temp);

        while (!Qn.isEmpty()) {

            Temp = Qn.peek(); // Get Head or null if empty
            Qn.remove(); // Get Head and Remove it

            if (Temp.getLeft() == null) {
                Temp.setLeft(new Node(word));
                break;
            } else {
                Qn.add(Temp.getLeft());
            }
        }
    }

    /**
     * Returns true if there is an element in the tree that matches with the input
     * String given a Node input, else returns false if not found or there are no
     * more elements left to search
     * 
     * @param Temp Node input
     * @param word String input
     * @return return
     */
    private Boolean inOrder(Node Temp, String word) {
        if (Temp == null)
            return false;

        if (Temp.getData().equals(word))
            return true;

        return (inOrder(Temp.getLeft(), word) || inOrder(Temp.getRight(), word));
    }

    /**
     * Searches for an String input element in the tree, if not found returns false
     * else return true
     * 
     * @param word String input
     * @return return
     */
    Boolean Search(String word) {
        return (inOrder(Node, word) == true) ? true : false;
    }
}
