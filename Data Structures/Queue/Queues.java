/**
 * Queues
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

public class Queues {
    public static void main(String[] args) {
        Queue Q = new Queue();

        for(int i=1; i <= 256; i = 2*i) {
            Q.EnQueue(i);

            System.out.println("FRONT: " + Q.getFront());
            System.out.println("REAR: " + Q.getRear());
            System.out.println();
        }

        for(int i=0; i < 6; i++) {
            Q.DeQueue();

            System.out.println("FRONT: " + Q.getFront());
            System.out.println("REAR: " + Q.getRear());
            System.out.println();
        }
    }
}