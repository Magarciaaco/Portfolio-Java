import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

class SortingStructures {
    public static Random rng = new Random();

    /************************
     *  RECURSIVE METHODS
     ***********************/ 

    // Calls a helper method with initial parameters
    // i = 0, n = array length - 1
    public static int RecursiveBubbleSort(int[] arr) {
        return RecursiveBubbleHelpr(arr, arr.length-1);
    }

    /* RecursiveBubbleHelpr is the method that actually sorts the array.
     * 
     * The parameter i is an iterator: it bubbles the largest element
     * between 0 and n to position n.
     *
     * Parameter n sets a limit to how much each recursion set will
     * "bubble". Every time the largest element between 0 and n is
     * put in position n, the next recursive call sets i to 0 and 
     * reduces n by 1.
     */
    public static int RecursiveBubbleHelpr(int[] arr, int n) {
        // Base case: when the limit is below what is sortable
        if(n <= 0) {
            return 0;
        } else {
            // Recursive case: when we are bubbling up
            int counter = RecursiveBubbler(arr, 0, n);
            // We only do one comparison here, so it's 1 + call
            return counter + RecursiveBubbleHelpr(arr,n-1);
        }
    }

    // Method that "bubbles up" the array from 0 to n
    // When the recursive calls end, the max element between
    // pos 0 and n will be in pos n
    public static int RecursiveBubbler(int[] arr, int i, int n) {
        if(i == n) {
            // Base case: Last element
            return 0;
        } else {
            // Recursive case:
            // If left element > right, swap
            // Make recursive call increasing index i
            if(arr[i] > arr[i+1]) {
                swap(arr, i, i+1);
            }
            return 1 + RecursiveBubbler(arr, i+1, n);
        }
    }

    /****************************************************************/

    // Calls a helper method with initial parameters
    // i = 0, n = 1
    public static int RecursiveInsertionSort(int[] arr) {
        return RecursiveInsertionHelpr(arr, 0);
    }

    /* RecursiveInsertionHelpr is the one that actually sorts the array.
     * 
     * The parameter i is an iterator: it stops decreasing on each 
     * recursion when the new element has been correctly inserted in 
     * the sorted part. When it stops, n is increased.
     *
     * Parameter n is the last element of the sorted part. After it is 
     * increased, the element there must be moved down (using 
     * parameter i) to maintain the order of the sorted part.
     */
    public static int RecursiveInsertionHelpr(int[] arr, int n) {
        // Base case: when the sorted part is equal to the whole array
        if(n >= arr.length) {
            return 0;
        } else {
            // Recursive case: Put element on n (first element 
            // in unsorted) in its right location on sorted
            int counter = RecursiveInserter(arr, n-1);
            // Use recursive call to set first element of unsorted
            // to n+1
            return counter + RecursiveInsertionHelpr(arr, n+1);
        }
    }

    public static int RecursiveInserter(int[] arr, int i) {
        if(i < 0 || arr[i] <= arr[i+1]) {
            // Base case: Sorted part is sorted again.
            return 1;
        } else {
            // Recursive case: Moving the first unsorted element down
            // through the sorted part. 
            swap(arr, i, i+1);
            return 1 + RecursiveInserter(arr, i-1);
        }
    }
    /****************************************************************/

    // Calls a helper method with initial parameters
    // n = array length - 1
    public static int RecursiveSelectionSort(int[] arr) {
        return RecursiveSelectionHelpr(arr, arr.length - 1);
    }

    /* RecursiveSelectionHelpr is the one that actually sorts the array.
     * 
     * Parameter n is the one that determines where the next largest 
     * element will be put. It starts at the last element of the array, 
     * then the method searches for the largest element ih the rest of 
     * the array (from 0 to n), swaps the largest element with the 
     * element at n, then repeats the process (recursive call) with 
     * elements 0 to n-1.
     */
    public static int RecursiveSelectionHelpr(int[] arr, int n) {
        int counter = 0;
        // Base case: n is 0 or less (Array is size 1, or no more 
        // elements to search through)
        if(n <= 0) {
            return counter;
        } else {
            // Recursive case: Find max, swap, then reduce the index of // the position for the next largest element
            int max = findMax(arr, 0, n);
            swap(arr, n, max);

            // Counter is increased by n-1 because findMax always
            // does n-1 element comparisons
            counter += n - 1;
            return counter  + RecursiveSelectionHelpr(arr, n-1);
        }
    }

    // Recursively finds the largest elements between indexes x and y.
    // Always does y - x - 1 comparisons.
    public static int findMax(int[] arr, int x, int y) {
        if(x >= y) {
            return y;
        } else {
            int maxRight = findMax(arr, x+1, y);
            
            if(arr[maxRight] > arr[x]) {
                return maxRight;
            } else {
                return x;
            }
        }
    }

    /****************************************************************/

    // This method creates a new heap based on the input array,
    // turns the heap into a Max Heap, then uses Recursive Heap Sort.
    public static int RecursiveHeapSort(int[] arr) {
        int[] heap = createHeap(arr, arr.length-1);
        int counter = MaxHeapify(heap);
        counter += RecursiveHeapSortR(arr, heap);
        return counter;
    }

    // Recursively sorts a MaxHeap, and puts its sorted elements 
    // in the original input array.
    public static int RecursiveHeapSortR(int[] arr, int[] heap) {
        int counter = 0;
        // Base case: Heap is empty.
        if(heap[0] == 0) {
            return counter;
        } else {
            // Recursive case: 
            // Put the head of the heap in the next largest position in 
            // the array;
            arr[heap[0]-1] = heap[1];
            // Remove the head from the heap;
            swap(heap, 1, heap[0]);
            heap[0]--;
            // Rebuild the heap;
            counter += siftRecursive(heap, 1);
            // Make recursive call with reduced heap.
            counter += RecursiveHeapSortR(arr, heap);
        }
        return counter;
    }

    // Calls a helper method with parameters
    // root = heap size / 2 (last parent)
    public static int MaxHeapify(int[] heap) {
        return Heapify(heap, heap[0]/2);
    }

    public static int Heapify(int[] heap, int nodeIndex) {
        if(nodeIndex == 0) {
            return 0;
        } else {
            int counter = siftRecursive(heap, nodeIndex);
            counter += Heapify(heap, nodeIndex-1);
            return counter;
        }
    }

    /* Method that sifts down the sub heap starting at root.
     * Whenever nodes are switched, the method recursively 
     * sifts down the affected sub heap.
     */ 
    public static int siftRecursive(int[] heap, int root) {
        int left = root*2;
        int right = root*2 + 1;
        int counter = 0;
        int size = heap[0];
        int largest;

        
        if(left > size) {
            // Base case: Current root has no children.
            return 0;
        } else {
            // Recursive case:
            // If child of root is bigger then root, swap them and
            // siftRecursive from the post-swap child node.

            counter += 1; 
            if(right <= size && heap[right] > heap[left]) {
                largest = right;
            } else {
                largest = left;
            }

            if(heap[root] < heap[largest]) {
                swap(heap, root, largest);
                counter += siftRecursive(heap, largest);
            }
            return counter;
        }
    }

    // Recursive Heap creation.
    // Copies array into heap, 
    // sets size of heap to array length
    public static int[] createHeap(int[] arr, int i) {
        int[] heap;
        if(i==0) {
            int heapSize = getHeapSize(arr.length);
            heap = new int[heapSize+1];
            heap[0] = arr.length;
        } else {
            heap = createHeap(arr, i-1);
        }
        heap[i+1] = arr[i];
        return heap;
    }

    // Create a heap of size 2^i
    // If heaps are binary, their size has to be a power of 2.
    public static int getHeapSize(int arrSize) {
        if(arrSize<=1) {
            return 2;
        } else {
            return 2 * getHeapSize(arrSize/2);
        }
    }

    /****************************************************************/

    /* Iterative Merge Sort.
     * The idea is that, instead of dividing the array until we have
     * arrays of size 1 then merging them upwards, we start with
     * arrays of size 1, merge, then increase the size of the arrays
     * we are building by 2 x the previous size.
     */
    public static int IterativeMergeSort(int[] arr) {
        int counter = 0;
        // Outer loop controls size of arrays to merge.
        for(int size = 1; size < arr.length; size = size * 2) {
            // Inner loop merges groups of 2 arrays, which is
            // why it is increased by i + 2*size
            for(int i = 0; i < arr.length; i = i + 2*size) {
                int x1 = i;
                int y1 = i + size - 1;
                int x2 = y1 + 1;
                int y2 = x2 + size - 1;

                // If first index of right array is greater
                // than last index, there is no right array.
                if(x2 > arr.length - 1) {
                    continue;
                }

                // If second index of right array is greater
                // than last index, set to last index of array
                if(y2 > arr.length - 1) {
                    y2 = arr.length - 1;
                }

                // Merge the two current sub arrays.
                counter += Merge(arr, x1, y1, x2, y2);
            }
        }

        return counter;
    }

    // Merge method.
    // Takes subarrays arr[x1 .. y1] and arr[x2 .. y2] and
    // merges them in order in positions arr[x1 .. y2]
    public static int Merge(int[] arr, int x1, int y1, int x2, int y2) {
        int counter = 0;
        int[] helpArr = new int[y2 - x1 + 1];
        int i1 = x1;
        int i2 = x2;
        for(int i = 0; i < helpArr.length; i++) {
            if(i1 <= y1 && i2 <= y2) {
                if(arr[i1] < arr[i2]) {
                    helpArr[i] = arr[i1];
                    i1++;
                } else {
                    helpArr[i] = arr[i2];
                    i2++;
                }
                counter += 1;
            } else {
                if(i1 <= y1) {
                    helpArr[i] = arr[i1];
                    i1++;
                } else {
                    helpArr[i] = arr[i2];
                    i2++;
                }
            }
        }
        int j = 0;
        for(int i = x1; i <= y2; i++) {
            arr[i] = helpArr[j];
            j++;
        }
        return counter;
    }

    /****************************************************************/

    /* Iterative Quick Sort.
     * Uses the IntStack class found at the bottom of this file.
     * Every time it splits, it puts the indexes of the split into
     * the stack.
     * Otherwise is the same as Recursive Quick Sort, except
     * this one doesn't have a Split method (it is coded into the 
     * method itself, so it can keep track of the comparisons 
     * when splitting).
     */
    public static int IterativeQuickSort(int[] arr) {
        int counter = 0;
        IntStack stack = new IntStack(arr.length * 2);
        // If we push Bot then Top,
        // we pop Top then Bot
        stack.push(0);
        stack.push(arr.length - 1);

        int top, bot;
        while(!stack.isEmpty()) {
            // If we push Bot then Top,
            // we pop Top then Bot
            top = stack.pop();
            bot = stack.pop();
            
            if(bot >= top) {
                // Empty array or size 1
                continue;
            } else {
                // Split, as seen in Cormen's textbook 
                int pivot = arr[top];
                int i = bot;
                for(int j = bot; j <= top-1; j++) {
                    counter++;
                    if(arr[j] < pivot) {
                        swap(arr, i, j);
                        i++;
                    }
                }
                swap(arr, i, top);

                // Push right sub-array
                stack.push(i + 1);
                stack.push(top);
                // Push left sub-array
                stack.push(bot);
                stack.push(i - 1);
            }

        }

        return counter;
    }


    // Method that swaps two elements in an array.
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // Method that creates an array of integers from 1 to size,
    // then shufflest them.
    public static int[] createShuffled(int size) {
        int[] arr = new int[size];
        Random rng = new Random();
        for(int i = 0; i < size; i++) {
            arr[i] = i+1;
        }

        int j;
        for(int i = 0; i < size; i++) {
            j = rng.nextInt(size);
            swap(arr, i, j);
        }

        return arr;
    }


    // Method that writes a random array of integers into a file.
    public static void generateRandomFile(String filename, int size)
            throws Exception {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        
        int[] numbers = createShuffled(size);

        for(int n : numbers) {
            bw.write("" + n + " ");
        }

        bw.close();
    }

    // Method that reads integers from a file, as long
    // as they are separated by spaces.
    public static int[] readIntsFromFile(String filename)
            throws Exception {
        File f = new File(filename);
        Scanner scnr = new Scanner(f);

        int count = 0;

        while(scnr.hasNextInt()) {
            count++;
            scnr.nextInt();
        }

        int[] input = new int[count];
        f = new File(filename);
        scnr = new Scanner(f);

        for(int i = 0; i < count; i++) {
            input[i] = scnr.nextInt();
        }

        return input;
    }

    // Method that prints an array of integers.
    public static void printIntArray(int[] arr) {
        System.out.print("[ ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    public static void printStack(int[] stack) {
        System.out.print("[ ");
        for(int i = 1; i <= stack[0]; i++) {
            System.out.print(stack[i]);
            if(i < stack[0]) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }


    public static void main(String[] args) 
            throws Exception {
        int MIN_SIZE = 100;
        int MAX_SIZE = 3200;

        // Create files of random integers
        for(int s = MIN_SIZE; s <= MAX_SIZE; s = s*2) {
            generateRandomFile("a_" + s + ".txt", s);
        }

        // For each algorithm:
        //    For each file:
        //      Load file
        //      Run algorithm on data from file
        //      Output size of problem vs number of comparisons
        int[] arr;
        int counter;

        System.out.print("BUBBL:\t");
        for(int s = MIN_SIZE; s <= MAX_SIZE; s = s*2) {
            String filename = "a_" + s + ".txt";

            arr = readIntsFromFile(filename);
            
            counter = RecursiveBubbleSort(arr);
            System.out.print(counter);
            System.out.print("\t");
        }
        System.out.println();

        System.out.print("INSRT:\t");
        for(int s = MIN_SIZE; s <= MAX_SIZE; s = s*2) {
            String filename = "a_" + s + ".txt";

            arr = readIntsFromFile(filename);
            
            counter = RecursiveInsertionSort(arr);
            System.out.print(counter);
            System.out.print("\t");
        }
        System.out.println();

        System.out.print("SELCT:\t");
        for(int s = MIN_SIZE; s <= MAX_SIZE; s = s*2) {
            String filename = "a_" + s + ".txt";

            arr = readIntsFromFile(filename);
            
            counter = RecursiveSelectionSort(arr);
            System.out.print(counter);
            System.out.print("\t");
        }
        System.out.println();

        System.out.print("HEAPS:\t");
        for(int s = MIN_SIZE; s <= MAX_SIZE; s = s*2) {
            String filename = "a_" + s + ".txt";

            arr = readIntsFromFile(filename);
            
            counter = RecursiveHeapSort(arr);
            System.out.print(counter);
            System.out.print("\t");
        }
        System.out.println();

        
        System.out.print("MERGE:\t");
        for(int s = MIN_SIZE; s <= MAX_SIZE; s = s*2) {
            String filename = "a_" + s + ".txt";

            arr = readIntsFromFile(filename);
            
            counter = IterativeMergeSort(arr);
            System.out.print(counter);
            System.out.print("\t");
        }
        System.out.println();

        System.out.print("QUICK:\t");
        for(int s = MIN_SIZE; s <= MAX_SIZE; s = s*2) {
            String filename = "a_" + s + ".txt";

            arr = readIntsFromFile(filename);
            
            counter = IterativeQuickSort(arr);
            System.out.print(counter);
            System.out.print("\t");
        }
        System.out.println();
    }
}

class IntStack {
    private int[] stack;
    private int size = 0;

    public IntStack(int maxSize) {
        this.stack = new int[maxSize];
    }

    public int pop() {
        int val = this.stack[this.size-1];
        this.size--;
        return val;
    }

    public void push(int newInt) {
        this.stack[this.size] = newInt;
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}