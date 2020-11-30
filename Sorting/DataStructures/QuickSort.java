package DataStructures;

/* 
 * Iterative Quick Sort.
 * Uses the Stack class found at DataStructures Package Folder.
 * 
 * Average Case: O(n Log(n))
 * Worst   Case: O(n^2)
 * Best    Case: O(n Log(n))
 */

public class QuickSort {
    private int[] e;
    private Stack stack;

    public QuickSort() {

    }

    public void set(int[] e) {
        this.e = e;
    }

    /**
     * Iterative QuickSort
     * Worst Case: O(n^2)
     * Best Case: O(n Log(n))
     */
    public void sort() {
        stack = new Stack(e.length * 2);
        // if we push the Bottom then top,
        // we pop() Top then Bottom
        stack.push(0);
        stack.push(e.length - 1);

        int Top, Bottom;
        while (!stack.isEmpty()) {
            {
                // if we push the Bottom then top,
                // we pop() Top then Bottom
                Top = stack.pop();
                Bottom = stack.pop();

                if (Bottom >= Top) {
                    // Empty array or size 1
                    continue;
                } else {
                    // Split
                    int pivot = e[Top];
                    int i = Bottom;
                    for (int j = Bottom; j <= Top - 1; j++) {
                        if (e[j] < pivot) {
                            swap(i, j);
                            i++;
                        }
                    }
                    // The last place does not require to be tested / reviewed
                    swap(i, Top);

                    // Push right sub-array
                    stack.push(i + 1);
                    stack.push(Top);

                    // Push left sub-array
                    stack.push(Bottom);
                    stack.push(i - 1);
                }
            }
        }
    }

    public void show() {
        for (int i : e) {
            System.out.print(i + " ");
        }
    }

    // Method that swaps two elements in an array.
    private void swap(int x, int y) {
        int temp = e[x];
        e[x] = e[y];
        e[y] = temp;
    }
}