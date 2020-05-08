/**
 * Stack
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Stack {
    private Object[] stack;
    private int Size = 0;

    Stack(int Size) {
        this.stack = new Object[Size];
    }

    push(Object e) {
        this.stack[this.Size] = e;
        this.Size++;
    }

    Object pop() {
        Object V = this.stack[this.Size - 1];
        this.Size--;

        return V;
    }

    Boolean Empty() {
        return this.Size == 0;
    }

    getSize() {
        return this.Size;
    }
}