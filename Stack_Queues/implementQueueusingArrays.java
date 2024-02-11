package Stack_Queues;

class Queue {
    int front, rear;
    int []arr;

    Queue() {
        front = 0;
        rear = 0;
        arr = new int[100001];
    }

    // Enqueue (add) element 'e' at the end of the queue.
    public void enqueue(int e) {
        if(rear == arr.length) return ;
        arr[rear++] = e;
    }

    // Dequeue (retrieve) the element from the front of the queue.
    public int dequeue() {
        if(front == rear) return -1;
        int x = arr[front];
        for(int i = front + 1; i < rear; i++)
            arr[i-1] = arr[i];
        rear--;
        return x;
    }
}
public class implementQueueusingArrays {
    public static void main(String[] args) {
        
    }
}
