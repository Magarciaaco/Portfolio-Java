/**
 * Sorting
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

import DataStructures.MergeSort;
import DataStructures.QuickSort;

public class Sorting {
    static MergeSort Merge_Sort = new MergeSort();
    static QuickSort Quick_Sort = new QuickSort();

    static int[] Array = { 9, 8, 5, 7, 6, 4, 3, 1, 2 };

    public static void main(String[] args) {
        System.out.println("ARRAY NON-SORTED");
        for (int i : Array) {
            System.out.print(i);
        }
        
        System.out.println("\n");
        System.out.println("QUICK SORT");
        // ----- QUICK SORT ----- // START
        Quick_Sort.set(Array);
        Quick_Sort.sort();
        Quick_Sort.show();
        // ----- QUICK SORT ----- // END
        System.out.println("\n");
        System.out.println("MERGE SORT");
        // ----- QUICK SORT ----- // START
        Merge_Sort.set(Array);
        Merge_Sort.sort();
        Merge_Sort.show();
        // ----- QUICK SORT ----- // END
        System.out.println("\n");  
    }
}
