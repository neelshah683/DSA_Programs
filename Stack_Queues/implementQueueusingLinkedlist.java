package Stack_Queues;

class Node {
    public int data;
    public Node next;

    Node()
    {
        this.data = 0;
        this.next = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

class Queue{
    Node front;
    Node rear;
    void push(){};
    Queue() {
        front = null;
        rear = null;
    }
}
 class Solution extends Queue{
    Node head = null;
    Node tail = null;
    public void push(int x) {
        Node newNode = new Node(x);
        if(head == null)
            head = tail = newNode;
        tail.next = newNode;
        tail = newNode;
    }

    public int pop() {
        if(head == null)
            return -1;
        int x = head.data;
        if(head == tail)
        {
            head = tail = null;
            return x;
        }
        head = head.next;
        return x;
    }
}
public class implementQueueusingLinkedlist {
    public static void main(String[] args) {
        
    }
}
