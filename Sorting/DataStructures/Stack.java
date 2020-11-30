/**
 * Stack
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

package DataStructures;

public class Stack {
    private int[] e;
    private int Size;

    public Stack(int Size) {
        e = new int[Size];
        this.Size = 0;
    }

    public int pop() {
        int val = this.e[this.Size-1];
        this.Size--;
        return val;
    }

    public void push(int newInt) {
        this.e[this.Size] = newInt;
        this.Size++;
    }

    public int getSize() {
        return this.Size;
    }

    public boolean isEmpty() {
        return this.Size == 0;
    }
}
