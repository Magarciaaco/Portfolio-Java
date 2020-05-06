/**
 * Heap
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Heap {
private final int Capacity = 25; // Heap Max_Capacity
private int Size;
private int[] Heap;

    // Empty Heap - Size 100
    Heap() {
        this.Heap = new int[this.Capacity];
        this.Size = 0;

        for (int i = 0; i < this.Capacity; i++) {
            this.Heap[i] = -1; // Empty space
        }
    }

    // Insert a number e to the heap
    void Insert(int e) {

        if (this.Size == Capacity) {
            System.out.println("Heap is FULL");
            return;
        }

        for (int j = 0; j < this.Capacity; j++) {
            if (this.Heap[j] == -1) {
                this.Heap[j] = e;

                this.Size++;
                break;
            }
        }
    }

    // Delete All the Heap Data
    void Delete() {
        this.Size = 0;

        for (int i = 0; i < this.Capacity; i++) {
            this.Heap[i] = -1; // Empty space
        }
    }

    // Transform Heap to Max Heap -- !MAX_HEAP_SORT
    private int[] to_Max() {
        int[] Max_Heap = new int[this.Capacity];
        int i = 0;

        while (i != this.Size) {
            Max_Heap[i] = this.Heap[i];

            int Curr = i;
            while (Max_Heap[Curr] > Max_Heap[Parent(Curr)]) {

                Max_Heap = Swap(Max_Heap, Curr, Parent(Curr));
                Curr = Parent(Curr);
            }

            i++;
        }

        return Max_Heap;
    }

    void toMax() {
        this.Heap = to_Max();
    }

    /**
     * ===========
     * = HELPERS =
     * ===========
     **/

    // parent index
    private int Parent(int i) {
        return i/2;
    }

    // index Left Child
    private int Left_Child(int i) {
        // Base Case
        if (i < 0)
            return -15; // Error: index error, no negative numbers allowed (-15)

            try {
               return this.Heap[(2 * i) + 1]; 
            } catch (Exception e) {
                return -9;
            }
    }

    // index Right Child
    private int Right_Child(int i) {
        // Base Case
        if (i < 0)
            return -15; // Error: index error, no negative numbers allowed (-15)

            try {
                return this.Heap[(2 * i) + 2]; 
             } catch (Exception e) {
                 return -9;
             }
    }

    private boolean Leaf(int i) {
        return ( i >= (this.Size / 2) && i <= this.Size ) ? true : false;
    }

    // Swap elements in Heap Array
    private int[] Swap(int[] Max_Heap, int A, int B) {
        int T = Max_Heap[A];

        Max_Heap[A] = Max_Heap[B];
        Max_Heap[B] = T;

        return Max_Heap;
    }

    // Method that prints an array of integers.
    private void printArr(){ 
        for (int i = 0; i < this.Capacity; ) {
            for (int j = 0; j < 5; j++) {
                System.out.print("[");
                if(this.Heap[i] > 9) {
                    System.out.print(" " + this.Heap[i]);
                }
                else {
                    System.out.print("  " + this.Heap[i]);
                }
                System.out.print(" ]");

                i++;
            }
            System.out.println();
        }
    }

    // Print Heap Array, and Heap
    void print() {

        System.out.println("\nHeap Array Data: \n");
        printArr();
        int o = 0;

        System.out.println("\nHeap Data: \n");

        do {
            if (Leaf(o)) break;

            System.out.print("[ Parent:" + ((this.Heap[o] > 9) ? " " : "  ") + this.Heap[o] + " ]");
            System.out.print(" [ Left Child:" + ((Left_Child(o) > 9) ? " " : "  ") + (Left_Child(o) == -9 ? "Null" : Left_Child(o)) + " ]");
            System.out.print(" [ Right Child:" + ((Right_Child(o) > 9 ? " " : "  ")) + (Right_Child(o) == -9 ? "Null" : Right_Child(o)) + " ]\n");

            o++;
        } while (o < this.Capacity && o <= this.Size);
    }
}
