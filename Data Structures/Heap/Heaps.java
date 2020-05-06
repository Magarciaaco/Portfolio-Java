/**
 * Heaps
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

public class Heaps {
    public static void main(String[] args) {
        Heap Heap = new Heap();

        System.out.println("HEAP:\n");

        for (int i = 0; i < 25; i++) {
            Heap.Insert(i);
        }

        Heap.print();

        System.out.println("\n\nTO MAX HEAP:\n");

        Heap.toMax();
        Heap.print();
    }
}
