public class Doubly_Linked_List {
    
    Node head;
    int size;
    Doubly_Linked_List()
    {
        this.size = 0;
    }
    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }
    }
    public void insertFirst(int data)
    {
        Node newNode = new Node(data);

        if(head==null)
        {
            head = newNode;
            return ;
        }
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = null;
        head = newNode;
    }
    public void insertEnd(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head = newNode;
            return ;
        }

        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = null;
    }
    public void insertAny(int data, int index)
    {        
        if(index==0)
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
        temp.next.prev = newNode;
        newNode.next = temp.next;
        newNode.prev = temp;
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
        head.prev = null;
    }
    public void deleteEnd()
    {
        if(head==null)
        {
            System.out.println("List is Empty:");
            return ;
        }
        
        size--;
        if(head.next==null)
        {
            head=null;
            return ;
        }
        Node temp = head;
        while(temp.next.next!=null)
        {
            temp = temp.next;
        }
        temp.next.prev = null;
        temp.next = null;
    }
    public void deleteAny(int index)
    {
        if(index == 0)
        {
            deleteFirst();
            return ;
        }
        if(index == size-1)
        {
            deleteEnd();
            return ;
        }
        size--;
        Node temp = head, temp2 = head.next, temp3 = temp2.next;;
        for(int i=1;i<index;i++)
        {
            temp = temp.next;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        temp.next = temp3;
        temp3.prev = temp;
        temp2.next = null;
        temp2.prev =null;
    }
    public void printList()
    {
        if(head == null)
        {
            System.out.println("List is Empty:");
            return ;
        }
        Node temp = head, last = null;
        
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.print("NULL");

        System.out.println("\nPrinting Reverse Linked List:");
        while(last != null)
        {
            System.out.print(last.data+" -> ");
            last = last.prev;
        }
        System.out.print("Null");
    }
    //delete all occurrences ---- TC: O(N) | SC: O(1)
    public  Node deleteAllOccurrences(Node head, int k) {
        if(head == null) return null;
        if(head.next == null && head.data == k) return head.next;
        Node temp = head;

        while(temp != null){
            if(temp.data == k){
                if(temp == head){
                    head = head.next;
                }
                else{
                    Node prevNode = temp.prev, nextNode = temp.next;
                    if(nextNode != null) nextNode.prev = prevNode;
                    prevNode.next = nextNode;
                }
            }
            temp = temp.next;
        }
        return head;
    }
    //remove duplicates from sorted doubly linkedlist
    public Node removeDuplicates(Node head){
        if(head == null || head.next == null) return head;

        Node temp = head;
        while(temp != null){
            Node nextNode = temp.next;
            while(nextNode != null && nextNode.data == temp.data) nextNode = nextNode.next;
            temp.next = nextNode;
            if(nextNode != null) nextNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        
        Doubly_Linked_List dl = new Doubly_Linked_List();

        dl.insertFirst(25);
        dl.insertFirst(10);
        dl.insertFirst(5);

        dl.insertEnd(30);
        dl.insertEnd(35);
        dl.insertEnd(40);

        dl.insertAny(15, 4);

        dl.deleteFirst();

        dl.deleteEnd();

        dl.deleteAny(2);

        System.out.println("Length = "+dl.size);

        dl.printList();
    }
}
