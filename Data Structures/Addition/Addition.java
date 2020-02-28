/**
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 * 
 * Data Range: Refer to out of range variables
 * 
 * What we need is to be able to hold two things at a time:
 *      1) the digit : int
 *      2) the next  : a pointer -- VIEW class Node
 * 
 * We will create a list that holds the following:
 * S |  0 -> 1 -> 2 -> 3 -> 4 -> 5 ... -> n
 */
public class Addition {
    private static Node Node = new Node(0);

    // Populate Node Helper
    private static void Populate_Node() {
        // Head of Node
        System.out.print(Node.n + " -> ");

        // Elements of Node
        for (int i = 1; i < 6; i++) {
            add(Node, i);
            System.out.print(i + " -> ");

        } System.out.println("|||");
    }

    // Adition Helper for Populate_Node
    private static Node add(Node TNode, int item) {
        if (Node != null) {
            Node TemporalNode = TNode;
            while (TemporalNode != null && TemporalNode.next != null) {
                TemporalNode = TemporalNode.next;
            }
            TemporalNode.next = new Node(item);
            return TNode;
        } else
            return null;
    }

    // Addition Node Helper
    private static void Print_Addition(Node N) {
        // Print Head Node
        System.out.print(N.n + " -> ");

        // Iterate to Print Node Body until it reaches the Tail element
        N = N.next;
        while(N != null) {
            System.out.print(N.n + " -> ");

            N = N.next;
        } System.out.print("|||\n");
    }

    public static void main(String[] args) {
        System.out.println("POPULATING NODE:");
        Populate_Node();
        System.out.println("POPULATED NODE:");
        Print_Addition(Node);
    }
}