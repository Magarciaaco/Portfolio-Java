/**
 * Deletion
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Deletion {
    private static Node Node = new Node(0);

    // Populate Node Helper
    private static void Populate_Node() {
        // Head of Node
        System.out.print(Node.n + " -> ");

        // Elements of Node
        for (int i = 1; i < 6; i++) {
            add(Node, i);
            System.out.print(i + " -> ");

        }
        System.out.println("|||");
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

    // Print Helper
    public static void Print(Node N) {
        if (N.n == -24)  {
            System.out.println("Empty Node");
            return;
        }

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
        System.out.println("DELETING HEAD NODE:");
        Node = Node.Delete_Head(Node);
        Print(Node);
        System.out.println("DELETING TAIL NODE:");
        Node = Node.Delete_Tail(Node);
        Print(Node);
        System.out.println("DELETING ELEMENT 3 NODE:");
        Node = Node.Delete_Element(Node, 3);
        Print(Node);
        System.out.println("DELETING BODY NODE:");
        Node = Node.Delete_Body(Node);
        Print(Node);
        System.out.println("DELETING ALL NODE:");
        Node = Node.Delete_All();
        Print(Node);
    }
}