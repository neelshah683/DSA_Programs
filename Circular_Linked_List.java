public class Circular_Linked_List {
    
    Node head, tail;
    int size;
    Circular_Linked_List()
    {
        this.size = 0;
    }
    class Node{
        
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            size++;
        }
    }
    public void insertFirst(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head = newNode;
            tail = newNode;
            return ;
        }

        tail.next = newNode;
        newNode.next = head;
        head = newNode;
    }
    public void insertEnd(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            tail=newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }
    public void insertAny(int data, int index)
    {

        if(index == 0)
        {
            insertFirst(data);
            return ;
        }

        if(index == size)
        {
            insertEnd(data);
            return ;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for(int i=1;i<index;i++)
        {
           temp = temp.next; 
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void deleteFirst()
    {
        if(head == null)
        {
            System.out.println("List is Empty:");
            return ;
        }
        size--;
        head = head.next;
        tail.next = head;
    }
    public void deleteEnd()
    {
        if(head==null)
        {
            System.out.println("List is Empty:");
            return ;
        }
        if(head==tail)
        {
            head=tail=null;
            return ;
        }
        size--;
        Node temp = head;
        while(temp.next!=tail)
        {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }
    public void deleteAny(int index)
    {
        if(head==null)
        {
            System.out.println("List is Empty:");
            return ;
        }
        if(index == 0)
        {
            deleteFirst();
            return ;
        }
        if(index == size)
        {
            deleteEnd();
            return ;
        }
        size--;
        Node temp = head;
        for(int i=1; i<index;i++)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public int  getSize()
    {
        return size;
    }
    public void printList()
    {
        if(head == null)
        {
            System.out.println("List is Empty:");
            return ;
        }

        Node temp = head;
        do{
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }while(temp!=head);
        System.out.print("TAIL");
    }
    public static void main(String[] args) {
        
        Circular_Linked_List cl = new Circular_Linked_List();

        cl.insertFirst(25);
        cl.insertFirst(10);
        cl.insertFirst(5);

        cl.insertEnd(30);
        cl.insertEnd(35);
        cl.insertEnd(40);
        cl.insertEnd(45);
        cl.insertEnd(50);

        cl.insertAny(15, 2);

        cl.deleteFirst();

        cl.deleteEnd();

        cl.deleteAny(7);

        System.out.println("Length = "+cl.getSize()); 
        
        cl.printList();
        
    }
}
