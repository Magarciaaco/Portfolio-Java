/**
 * Queue
 * Coded by: Miguel Angel Garcia Acosta
 * Contact: MAGA.DevCS@Gmail.com
 */

public class Queue {
    private int[] queue;
    private int Front, Rear, Size = 0;
    private final int Capacity = 100;


    Queue() {
        System.out.println("New Queue : 100 Capacity");
        this.queue = new int[this.Capacity];

        this.Front = this.Size;
        this.Rear = this.Capacity - 1;
    }

    private Boolean isFull() {
        return this.Size == this.Capacity;
    }

    private Boolean isEmpty() {
        return this.Size == 0;
    }

    void EnQueue(int e) {
        if(isFull()) return;

        this.Rear = (this.Rear + 1)%this.Capacity;
        this.queue[this.Rear] = e;
        this.Size += 1;

        System.out.println("EN_QUEUED: " + e);
    }

    void DeQueue() {
        if(isEmpty()) return;

        int Curr = this.queue[this.Front];

        this.Front = (this.Front + 1)%this.Capacity;
        this.Size -= 1;

        System.out.println("DE_QUEUED: " + Curr);
    }

    int getFront() {
        if(isEmpty()) return -1;

        return this.queue[this.Front];
    }

    int getRear() {
        if(isEmpty()) return -1;

        return this.queue[this.Rear];
    }
}