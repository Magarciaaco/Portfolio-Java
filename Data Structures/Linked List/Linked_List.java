import java.util.Random;

/**
 * Linked_List
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Linked_List {

    // ********************
    // **** NODE CLASS ****
    // ********************

    public static class Node {
        Object Data;
        Node Next;

        Node() {

        }

        Node(Object Data) {
            this.Data = Data;
        }
    }

    // *********************
    // * LINKED LIST CLASS *
    // *********************

    public static class LinkedList {
        Node List;

        LinkedList() {

        }

        void Append(Object o) {
            if (List == null) List = new Node(o);
                else this.List = Add(o, List);
        }
    }

    // ********************
    // ****   HELPERS  ****
    // ********************

    // Append Helper
    public static Node Add(Object o, Node List) {
        Node Reference = List;

        if (List.Next != null) {
            do {
                Reference = Reference.Next;
            } while (Reference != null && Reference.Next != null);
            Reference.Next = new Node(o);
        } else List.Next = new Node(o);

        return List;

    }

    // Print Helper
    public static void Print(Node N) {
        if (N.Data == null) {
            System.out.println("Empty List");
            return;
        }

        System.out.print(N.Data + " -> ");

        N = N.Next;
        while (N != null) {
            System.out.print(N.Data + " -> ");

            N = N.Next;
        }
        System.out.print("|||\n\n");
    }

    // ********************
    // ****    MAIN    ****
    // ********************
    
    public static void main(String[] args) {
        LinkedList LinkedList = new LinkedList();
        Random Rand = new Random();
        int TR;

        for (int i = 0; i < 10; i++) {
            TR = Rand.nextInt(1000);

            System.out.println("Appending: " + TR + "\n");
            LinkedList.Append(TR);
            Print(LinkedList.List);
        }
    }
}