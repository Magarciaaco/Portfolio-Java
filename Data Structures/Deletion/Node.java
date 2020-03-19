/**
 * Node
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Node {
    // the digit
    int n = -24;
    // the next
    Node next;

    Node() {

    }

    Node(int n) {
        this.n = n;
        next = null;
    }

    // Delete Head Node
    Node Delete_Head(Node Node) {
        if(Node == null) return Node;
        Node = Node.next;

        return Node;
    }

    // Delete Tail Node
    Node Delete_Tail(Node Node) {
        if(Node == null || Node.next == null) return Node;
        
        for (Node index = Node; index.next != null; index = index.next) {
            if (index.next.next == null) {
                index.next = null;
                break;
            }
        }

        return Node;
    }

    // Locate Last Node
    private Node Goto_End(Node Node) {
        if(Node == null || Node.next == null) return Node;

        do {
            Node = Node.next;
        }while(Node.next != null);

        return Node;
    }

    // Delete Body of Node
    Node Delete_Body(Node Node) {
        if(Node == null || Node.next == null) return Node;

        Node.next = Goto_End(Node);

        return Node;
    }

    // Delete Data & Node
    Node Delete_Element(Node Node, int Element) {
        if(Node == null) return Node;
            else if (Node.next == null) {
                Node = new Node();
                return Node;
            }

        Node Prev = Node, Curr = Node;
        
        do {
            Prev = Curr;
            Curr = Curr.next;
        }while(Curr.next.next != null || Curr.n != Element);

        Prev.next = Curr.next;
        
        return Node;
    }

    // Delete All
    Node Delete_All() {
        Node Node = new Node();

        return Node;
    }
}