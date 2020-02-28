/**
 * Node
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Node {
    // the digit
    int n;
    // the next
    Node next;

    Node() {

    }

    Node(int n) {
        this.n = n;
        next = null;
    }

    Node add(Node Node, String item) {
        if (Node != null) {
            Node TemporalNode = Node;
            while (TemporalNode != null && TemporalNode.next != null) {
                TemporalNode = TemporalNode.next;
            }
            TemporalNode.next = new Node(item);
            return Node;
        } else
            return null;
    }
}