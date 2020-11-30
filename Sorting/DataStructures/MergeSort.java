package DataStructures;

/* Iterative Merge Sort.
 * The idea is that, instead of dividing the array until we have
 * arrays of size 1 then merging them upwards, we start with
 * arrays of size 1, merge, then increase the size of the arrays
 * we are building by 2 x the previous size.
 * 
 * Average Case: O(n Log(n))
 * Worst   Case: O(n Log(n))
 * Best    Case: O(n Log(n))
 */

public class MergeSort {
    private int[] e;

    public MergeSort() {
        
    }

    public void set(int[] e) {
        this.e = e;
    }

    /**
     * Iterative MergeSort
     */
    public void sort() {
        // This loop manages the size of arrays to merge
        for(int size = 1; size < e.length; size = size * 2) {
            // This inner loop merges the groups of 2 arrays (it is why it is increased by i + 2*size)
            for (int i = 0; i < e.length; i = i + 2*size) {
                int x1 = i;
                int y1 = i + size - 1;
                int x2 = y1 + 1;
                int y2 = x2 + size - 1;

                // If first index of right array is greater
                // than last index, there is no right array.
                if(x2 > e.length - 1) {
                    continue;
                }

                // If second index of right array is greater
                // than last index, set to last index of array
                if(y2 > e.length - 1) {
                    y2 = e.length - 1;
                }

                // Merge the two current sub arrays.
                Merge(x1, y1, x2, y2);
            }
        }
    }

    public void show() {
        for (int i : e) {
            System.out.print(i + " ");
        }
    }

    // -------------------- MERGE SORT HELPER --------------------  //

    // Merge method
    // Takes subarrays arr[x1 .. y1] and arr[x2 .. y2] and
    // merges them in order in positions arr[x1 .. y2]
    public void Merge(int x1, int y1, int x2, int y2) {

        int[] Temporal_Array = new int[y2 - x1 + 1];
        int i1 = x1;
        int i2 = x2;

        for (int i = 0; i < Temporal_Array.length; i++) {
            if (i1 <= y1 && i2 <= y2) {
                if (e[i1] < e[i2]) {
                    Temporal_Array[i] = e[i1];
                    i1++;
                } else {
                    Temporal_Array[i] = e[i2];
                    i2++;
                }
            } else {
                if (i1 <= y1) {
                    Temporal_Array[i] = e[i1];
                    i1++;
                } else {
                    Temporal_Array[i] = e[i2];
                    i2++;
                }
            }
        }
        int j = 0;
        for (int i = x1; i <= y2; i++) {
            e[i] = Temporal_Array[j];
            j++;
        }
    }

    // -----------------------------------------------------------  //
}