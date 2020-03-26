/**
 * Heap
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Heap {
    int[] Heap;
    private int size;

    Heap(int size) {
        this.size = size;
        this.Heap = new int[size];

        for (int i = 0; i < this.size; i++) {
            Heap[i] = 1234567891;
        }
    }

    void Add(int e) {
        for (int i = 0; i < this.size; i++) {
            if ( i == this.size) break;
                else if (Heap[i] == 1234567891) {
                    Heap[i] = e;
                    break;
                }
        }
    }

    private void Parent(int e) {
        System.out.println("\nParent: " + (this.Heap[e / 2]) );
    }

    private void Child(int e) {
        try {
            System.out.println("Left Child: " + this.Heap[e / 2 + 1] );
        System.out.println("Right Child: " + this.Heap[e / 2 + 2] );
        } catch (Exception o) {
            System.out.println("Child: No child or Empty Leaf | Null ( " + o.getLocalizedMessage() + o.getMessage() + ")");
        }
    }

    // Print() helper
    private void PrintHeap() {
        for (int i = 0; i < this.size; i++) {
            Parent(i); Child(i);
        }
    }

    void Print(int[] arr) {
        System.out.print("[ ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");

        PrintHeap();
    }
}