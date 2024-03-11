import java.util.ArrayList;
import java.util.List;

public class Singly_Linked_List {
    
    Node head;
    int size;
    Singly_Linked_List()
    {
        this.size = 0;
    }
    class Node{

        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
            size++;
        }
        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
            size++;
        }
    }
    public void addFirst(int data)
    {
        Node newNode = new Node(data);

        if(head==null)
        {
            head = newNode;
            return ;
        }        
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void add_atAnyIndex(int data, int index)
    {
        if(index == 0)
        {
            addFirst(data);
            return ;
        }

        if(index == size)
        {
            addLast(data);
            return ;
        }

        Node temp = head;
        for(int i = 1; i < index ; i++)
        {
            temp = temp.next;
        }
        Node newNode = new Node(data, temp.next);
        temp.next = newNode;
    }
    public void searchNode(int data)
    {
        int count = 0;
        if(head == null)
        {
            System.out.println("List is Empty:");
            return ;
        }

        Node temp = head;
        while(temp!=null)
        {
            if(temp.data == data)
            {
                System.out.println("Element "+temp.data+" found at position: "+count);
                return ;
            }
            count++;
            temp = temp.next;
        }
        System.out.println("Element Not Found:");
    }
    public int getSize()
    {
        return size;
    }
    public Node reverseListRecursive(Node head) {
        if(head == null || head.next == null)
            return head;
        
        Node newHead = reverseListRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public void reverseList(){
        
        //Iterative Version
        Node prev = null, next = null, curr = head;

        if(head==null)
        {
            System.out.println("List is Empty:");
            return ;
        }

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
    }
    public void deleteEnd()
    {
        if(head == null)
        {
            System.out.println("List is Empty:");
            return ;
        }

        size--;
        if(head.next == null)
        {
            head = null;
            return ;
        }

        Node temp = head.next;
        Node prev = head;
        while(temp.next!=null)
        {
            prev = prev.next;
            temp = temp.next;
        }
        prev.next = null;
    }
    public void deleteAny(int index)
    {
        if(head == null)
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
        for(int i = 1;i < index; i++)
        {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public void printList()
    {
        if(head == null)
        {
            System.out.println("List is Empty");
            return ;
        }

        Node temp = head;
        
        while(temp!=null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }
    public void printListReverse(Node head)
    {
        if(head == null)
        {
            System.out.println("List is Empty");
            return ;
        }

        Node temp = head;
        
        while(temp!=null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }
    public void get_NthNode(int index)
    {
        if(head==null && index == 0)
        {
            System.out.println("List is Empty:");
            return ;
        }
        
        int count = 0;
        Node temp = head;
        
        while(temp!=null)
        {
            if(count == index)
            {
                System.out.println("Data at given Index: "+temp.data);
                return ;
            }
            count++;
            temp = temp.next;
        }
        System.out.println("Data Not Found:");
    }

    public void get_NthNode_END(int N)
    {
        if(head == null && N == 0)
        {
            System.out.println("List is Empty:");
            return ;
        }

        int setter = getSize() - N + 1;
        Node temp = head;
        for(int i=1; i < setter; i++)
        {
            temp = temp.next;
        }
        System.out.println("Value at Nth Position from End: "+temp.data);
    }
    public boolean hasCycle(Node head) {
    //TC: O(N) SC:O(N) --->Brute Force Solution
    //     if(head == null)
    //         return false;

    //    List<Node> list = new ArrayList<>();
    //    Node temp = head;

    //     while(temp.next != null){
    //         if(!list.contains(temp))
    //             list.add(temp);
    //         else
    //             return true;
    //         temp = temp.next;
    //     }

    //TC: O(N) //SC: O(1) -->Optimized Solution Tortoise & Hair Algorithm [Two Pointers]
            if(head == null)
            return false;

        Node fast = head, slow = head;
        while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) return true;
        }
        return false;
    }
    public Node detectCycleStartingPoint(Node head) {
        if(head == null)
           return head;

       Node fast = head, slow = head;

       while(fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast){
               slow = head;
               while(slow != fast){
                   slow = slow.next;
                   fast = fast.next;
               }
               return fast;
           }
       }
       return null;
   }
    public static void main(String[] args) {
        
        Singly_Linked_List sl = new Singly_Linked_List();

        sl.addFirst(20);
        sl.addFirst(10);
        sl.addFirst(5);

        sl.addLast(30);
        sl.addLast(35);
        sl.addLast(40);

        sl.add_atAnyIndex(25,3);

        sl.searchNode(45);

        System.out.println("Length = "+sl.getSize());

        sl.deleteFirst();

        sl.deleteEnd();

        sl.deleteAny(4);

        sl.get_NthNode(2);

        sl.get_NthNode_END(7);

        sl.printList();

        System.out.println("\nBefore Reverse:-> ");
        sl.printList();
        
        // sl.reverseList(); --->Iterative Version
        sl.printList();

        Node newHead = sl.reverseListRecursive(sl.head);
        System.out.println("\nAfter Reverse:-> ");

        sl.printListReverse(newHead);

        System.out.println();

        sl.hasCycle(newHead);

        sl.detectCycleStartingPoint(newHead);
    }
}
