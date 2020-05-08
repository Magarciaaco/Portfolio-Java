/**
 * Stack
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */
public class Stack {

    public static void main(String[] args) {
        final int Limit = 10;

        Stack_Struct Stack_ = new Stack_Struct(Limit);

        int o = 1;
        do {
            System.out.print("Stacking: " + o + (o > 9 ? " " : "  "));
            Stack_.push(o);
            System.out.println(" -| Done");
            o += 2;
        } while (Stack_.getSize() < Limit);
        
        System.out.println("\nPoping\n");

        while (Stack_.getSize() > 0) {
            
            System.out.println("Stack Status: " + (Stack_.Empty() ? "EMPTY" : "NOT EMPTY"));
            Stack_.pop();
        }

        System.out.println("Stack Status: " + (Stack_.Empty() ? "    EMPTY" : "NOT EMPTY"));
    }

    
    private static class Stack_Struct {
        private Object[] stack;
        private int Size = 0;

        Stack_Struct(int Size) {
            this.stack = new Object[Size];
        }

        void push(Object e) {
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

        int getSize() {
            return this.Size;
        }
    }
}