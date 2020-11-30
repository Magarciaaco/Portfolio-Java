/**
 * LinkedList -- Doubly Linked List
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class LinkedList {

    // *********************
    // *     Node CLASS    *
    // *********************

    /**
     * TWO WAY NODE
     */
    private class Node {
        private String Data;
        public Node Next;
        public Node Previous;

        Node(String Data) {
            this.Data = Data;
        }

        /**
         * SET NODE DATA
         * 
         * @param data
         */
        public void setData(String data) {
            Data = data;
        }

        /**
         * SET NEXT NODE
         * 
         * @param next
         */
        public void setNext(Node next) {
            Next = next;
        }

        /**
         * SET PREVIOUS NODE
         * 
         * @param previous
         */
        public void setPrevious(Node previous) {
            Previous = previous;
        }

        /**
         * RETURN NODE DATA
         * 
         * @return
         */
        public String getData() {
            return Data;
        }
    }
    private Node List;

    // Empty Constructor
    public LinkedList() {

    }

    /**
     * Add
     * @param S String
     */
    public void Add(String S) {
        if (List == null) {
            List = new Node(S);
            return;
        }

        Node Reference = List;
        while (Reference.Next != null) {
            Reference.setPrevious(Reference);
            Reference = Reference.Next;
        }
        Reference.Next = new Node(S);
        Reference.Next.Previous = Reference;
    }

    /**
     * Terminal_Print Print Doubly Linked List to Console(Terminal)
     */
    public void Terminal_Print() {
        if (List == null)
            System.out.println("0: LINKED LIST EMPTY");

        Node Reference = List;
        while (Reference != null) {
            System.out.println(
                "Current: " +
                ((Reference != null) ? Reference.getData() : "NULL")
                + "\n" + "Next: " +
                ((Reference.Next != null) ? Reference.Next.getData() : "NULL")
                + "\n" + "Previous: " +
                ((Reference.Previous != null) ? Reference.Previous.getData() : "NULL")
                +"\n"
                );
            Reference = Reference.Next;
        }
    }

    /**
     * toString Returns all Linked List's data as String
     */
    public String toString() {
        if (List == null)
            System.out.println("0: LINKED LIST EMPTY");

        String S = "";
        Node Reference = List;
        while (Reference != null) {
            S = S + " " + Reference.getData();
            Reference = Reference.Next;
        }
        return S;
    }


    // ********************
    // ****    MAIN    ****
    // ********************

    public static void main(String[] args) {
        LinkedList LL = new LinkedList();

        LL.Add("Hello");
        LL.Add("World");

        LL.Add("I am");
        LL.Add("a Doubly");
        LL.Add("Linked List");

        System.out.println(LL.toString() + "\n");

        LL.Terminal_Print();
    }
}
