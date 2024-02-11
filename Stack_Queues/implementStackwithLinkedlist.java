package Stack_Queues;

 class Node
 {
     int data;
     Node next;
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
 class Stack {
    //Write your code here

    Node head=null;
    int size;
    Stack()
    {
        this.size = 0;
    }

    int getSize()
    {
        return size;
    }

    boolean isEmpty()
    {
        return size == 0;
    }

    void push(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
            head = newNode;
        newNode.next = head;
        head = newNode; 
        size++;
    }

    void pop()
    {
        if(size > 0)
        {
            head = head.next;
            size--;
        }
    }

    int getTop()
    {
        if(size > 0)
            return head.data;
        return -1;
    }
}
public class implementStackwithLinkedlist {
    public static void main(String[] args) {
        
    }
}
