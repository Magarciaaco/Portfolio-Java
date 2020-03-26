import java.util.Random;

/**
 * Heaps
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Heaps {

    public static void main(String[] args) {
        Heap HeapI;
        Random Random = new Random();
        int n;
        
        do {
            n = Random.nextInt(10);
        } while (n < 0);

        HeapI = new Heap(n);
        for (int i = 0; i < n; i++) {
            int k = Random.nextInt();
            System.out.println("Size: " + n + "\t-|- Heap Entry: " + (i + 1) + "\t-|- Value: " + k + "\n");
            HeapI.Add(k);
        }

        System.out.println("Heap Size: " + HeapI.Heap.length);
        HeapI.Print(HeapI.Heap);
    }
}