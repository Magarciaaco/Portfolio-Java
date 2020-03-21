
/**
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 * 
 * Problem: Flavius Josephus was a famous historian of the first century, but apparently, he would not have
 * lived to become famous without the exercise of his computational and mathematical abilities. A legend
 * says that during the Jewish-Roman war he was part of a band of 41 rebels trapped in a cave by the Romans.
 * To avoid capture, the rebels decided to form a circle and proceeded to kill every third remaining person
 * until no one was left. However, Josephus quickly calculated where he and a friend should stand to avoid
 * all this non-sense.
 * 
 * 
 * Description / Potential Solution:
 *  START:
 *      - Ask for the total number of people in the circle
 *          - if it is not a positive number, it will ask again for a positive number input
 *      - Given the CLHelper class to operate easier, it will create a new Circular Linked List
 *          - if there is only one or two, it will return the same list and do nothing (end program)
 *      - Ask for the elimination number
 *          - if it is not a positive number, it will ask again for a positive number input
 *      - Operate the Josephus circle
 *          - It will Count until there are less elements than the elimination number provided  
 *              - Idea: use a Element.Next = Element.Next.Next  to eliminate (Will it work if it reaches the head ? OK : Develop Conditions)
 *              - Idea: It may be useful to turn the Circular Linked List to a standard Linked list to do elimination, and at the end of the
 *                      process, "Re-Connect" the Linked List to a Circular Linked list
 *      - Loop the step above until there is only one person standing
 *          - Displaying every new Circular Linked List
 *      - Return / Display the Last Standing Position Number
 *  END:
 */
import java.util.Scanner;

public class Josephus_Circle {

    /**
     * Node class: Linked List Node
     */
    public static class Node {
        int Dat;
        Node Next = null;
    
        /**
         * Empty Constructor
         */
        Node() {
    
        }
    
        /**
         * Input Constructor: Takes input item, and stores it in this.item
         * 
         * @param item input to be stored in Node ( this.item )
         */
        Node(int Dat) {
            this.Dat = Dat;
        }

        /**
         * Method add: Adds a New Node at the end of
         * a given Linked List Head Node
         * 
         * @param Node Input Linked List Head Node
         * @param item Input Element
         * @return return
         */
        Node add(Node Node, int item) {
            if (Node != null) {
                Node TemporalNode = Node;
                while (TemporalNode != null && TemporalNode.Next != null) {
                    TemporalNode = TemporalNode.Next;
                }
                TemporalNode.Next = new Node(item);
                return Node;
            } else
                return null;
        }
    }

    /**
     * CLHelper class: This class will manage the Node class
     */
    public static class CLHelper {
        private Node Head;
        private Node Next;

        /**
         * Base Constructor: Creates Head, and Next Nodes
         */
        CLHelper() {
            Head = new Node();
            Next = new Node();
        }

        /**
         * Method getHead: Returns Head Node
         * 
         * @return return
         */
        Node getHead() {
            return Head;
        }

        /**
         * Method getNext: Returns Next Node (Body of the Linked List)
         * 
         * @return
         */
        Node getNext() {
            return Next;
        }

        /**
         * Method setHead: Sets Head Node Data
         * 
         * @param Head Head Node Data
         */
        void setHead(int Head) {
            this.Head.Dat = Head;
        }

        /**
         * Method setNext: Sets Next Node (Body of the Linked List)
         * 
         * @param Next Body of the Linked List
         */
        void setNext(int Next) {
            this.Next = new Node(Next);
        }

        /**
         * Method append: Adds a New Node at the end of the given Linked List
         *  
         * @param Item New element to be added (Type int)
         */
        void append(int Item) {
            this.Next = this.Next.add(this.Next, Item);
        }

        /**
         * Method CreateCircular: Converts the given Linked List to
         * a Circular Linked List
         * 
         */
        void CreateCircular() {
            Head.Next = Next;

            Node Ref = Next;
            while (Ref.Next != null) {
                Ref = Ref.Next;
            }
            Ref.Next = Head;
        }

        /**
         * Method PrintAllCircular: Prints all elements of
         * the Circular Linked List
         */
        void PrintAllCircular() {
            Node Ref = Head;

            System.out.print("\nPositions | ");
            System.out.print(Ref.Dat + " ");
            Ref = Ref.Next;
            while (Ref != Head) {
                if(Ref.Next == Head) {
                    System.out.print(Ref.Dat);
                } else {
                    System.out.print(Ref.Dat + " ");
                }
                Ref = Ref.Next;
            }
            System.out.println();
        }

        /**
         * Method toNode: Transforms the current Circular Linked List to a Standard Linked List
         * returned as Head Node
         * 
         * @return return
         */
        Node toNode() {
            Node toNode = new Node(Head.Dat);
            Node Ref = Next;
            while(Ref != Head) {
                toNode = toNode.add(toNode, Ref.Dat);
                Ref = Ref.Next;
            }

            return toNode;
        }

        /**
         * Method Elements: Returns the total number of elements in the Linked List
         * 
         * @return return
         */
        int Elements() {
            Node Ref = this.toNode();
            int elem = 0;
            
            while (Ref != null) {
                elem++;
                Ref = Ref.Next;
            }
            return elem;
        }
    }

    /**
     * Method toString: Returns a string with the contents of Node,
     * surrounded by parenthesis
     * Examples: (1), (15), (368)
     * 
     * @param INode Input Circular Linked List
     * @return return
     */
    public static String toString(CLHelper INode) {
        Node Ref = INode.Next;
        String strNode ="(" +  INode.getHead().Dat + ")";

        do {
            strNode = strNode + " (" + Ref.Dat + ")";
            Ref = Ref.Next;
        } while (Ref != INode.getHead());

        return strNode;
    }

    /**
     * Method JosephusCircle: Operates the structure of the Josephus Circle
     * 
     * @param list Input Circular Linked List
     * @param n nth element / Elimination number
     */
    public static CLHelper JosephusCircle(CLHelper list, int n) {
        CLHelper Josephus = new CLHelper();
        Node Ref = list.toNode();
        Node toJosephus = null;
        int i = 0;

        
        while (Ref != null) {
            if (i == n - 1) {
                PrintLine("Killing: " + Ref.Dat);
                i = 0;
            } else {
                PrintLine("Jump: " + Ref.Dat);
                if (toJosephus == null)
                    toJosephus = new Node(Ref.Dat);
                else
                    toJosephus = toJosephus.add(toJosephus, Ref.Dat);
                    i++;
            }

            Ref = Ref.Next;
        }

        Josephus.setNext(toJosephus.Dat);
        toJosephus = toJosephus.Next;

        while (toJosephus.Next != null) {
            Josephus.append(toJosephus.Dat);
            toJosephus = toJosephus.Next;
        }

        Josephus.setHead(toJosephus.Dat);

        Josephus.CreateCircular();
        Josephus.PrintAllCircular();

        if(Josephus.Elements() == 2)
            return Josephus;

        if(Josephus.Elements() >= n)
            Josephus = JosephusCircle(Josephus, n);


        return Josephus;
    }

    /**
     * Method append: appends/adds a new node given a Head Node (Operated by the Helper class), to the last entry of the list
     * 
     * @param list Input List, as Linked List
     * @param newItem Input Element as type int
     */
    public static void append(CLHelper list, int newItem) {
        list.append(newItem);
    }

    /**
     * Method printStrArray: Prints All The elements of a given String array
     * 
     * @param array Input String Array to be printed
     */
    public static void printStrArray(String[] array) {
        for (String e : array) {
            Print(e + " ");
        }
    }

    /**
     * Method PrintLine: Performs a System.out.println(), given a String
     * 
     * @param x Input String to be printed
     */
    public static void PrintLine(String x) {
        System.out.println(x);
    }

    /**
     * Method Print: Performs a System.out.print(), given a String
     * 
     * @param x Input String to be printed
     */
    public static void Print(String x) {
        System.out.print(x);
    }
    public static void main(String[] args) {
        // 1. Ask the user for the Number of people in the circle
        Scanner SC = new Scanner(System.in);
        Print("Welcome to Josephus Circle Operator:\nSelect the number of people in the circle: ");
        int n = SC.nextInt();
        while (n < 3) {
            PrintLine("Please Select a positive number bigger than 2");
            Print("Input:");
            n = SC.nextInt();
        }

        // 2. Create circular Linked List
        CLHelper list = new CLHelper();
        list.setHead(1);
        list.setNext(2);
        
        for (int i = 3; i <= n; i++) {
            list.append(i);
        }
        list.CreateCircular();
        list.PrintAllCircular();

        // 3. Ask the user for the elimination number n
        Print("\nSet the elimination number: ");
        n = SC.nextInt();
        while (n < 2) {
            PrintLine("Please Select a positive number bigger than 1");
            Print("Input:");
            n = SC.nextInt();
        }
        // 4. Do the elimination until there are
        //    less than n people
        PrintLine("Eliminating until there are less people than the elimination number");
        list = JosephusCircle(list, n);
        System.out.println();

        // 5. Print the remaining people
        if(list.Elements() == 2 && n % 2 == 0) {
            list.Head.Next = null;
            list.Next = null;

            PrintLine("Last Standing: " + "(" + list.Head.Dat + ")");
        } else {
            PrintLine("Last Standing:");
            printStrArray(toString(list).split(" ") );
        }
    }
}