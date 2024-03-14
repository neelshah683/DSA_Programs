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
        //BRUTE FORCE SOLUTION
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

        //Optimized Solution
        // if(head == null) return head;

        // ListNode fast = head, slow = head;

        // for(int index = 1; index <= n; index++) fast = fast.next;

        // if(fast == null) return head.next;

        // while(fast.next != null){
        //     fast = fast.next;
        //     slow = slow.next;
        // }
        // slow.next = slow.next.next;
        // return head;
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
   public boolean isPalindrome(Node head) {
    if(head == null || head.next == null) return true;

    Node slow = head, fast = head;

    while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    Node newHead = reverseListRecursive(slow.next);

    Node first = head, second = newHead;
    
    while(second != null){
        if(first.data != second.data){
            reverseListRecursive(newHead);
            return false;
        } 
        first = first.next;
        second = second.next;
    }
    reverseListRecursive(newHead);
    return true;
}
public Node oddEvenList(Node head) {
    if(head == null || head.next == null || head.next.next == null)
        return head;
    
        Node odd = head, even = head.next, evenHead = head.next;

    while(even != null && even.next != null){
        odd.next = odd.next.next;
        even.next = even.next.next;
        odd = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
}
    public Node deleteMiddle(Node head) {
        if(head == null || head.next == null)
            return null;
        
            Node fast = head, slow = head;
        int flg = 1;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(flg == 0)
                slow = slow.next;
            flg = 0;
        }
        slow.next = slow.next.next;
        return head;
    }
    // for sorting a linkedlist using ms ---> Merge Sort TC: O(NlogN) SC: O(Log N)
    public Node sortList(Node head) {
        if(head == null || head.next == null) return head;

        Node middle = findMiddle(head);
        Node left = head;
        Node right = middle.next;

        middle.next = null;

        Node leftPart = sortList(left);
        Node rightPart = sortList(right);

        return mergeList(leftPart, rightPart);

    }
    public Node mergeList(Node head1, Node head2){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.next = head1;
                temp = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                temp = head2;
                head2 = head2.next;
            }
        }
        if(head1 == null)   temp.next = head2;
        else    temp.next = head1;

        return dummyNode.next;
    }
    public Node findMiddle(Node head){
        Node fast = head.next;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //ending of sort linkedlist

    //TC: O(N) SC: O(1)
    public  Node sortListofZero_One_Two(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;

        Node dummyNodeZero = new Node(-1);
        Node zero = dummyNodeZero;

        Node dummyNodeOne = new Node(-1);
        Node one = dummyNodeOne;
        
        Node dummyNodeTwo = new Node(-1);
        Node two = dummyNodeTwo;

        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            if(temp.data == 1){
                one.next = temp;
                one = temp;
            }
            if(temp.data == 2){
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = (dummyNodeOne.next != null) ? dummyNodeOne.next : dummyNodeTwo.next;
        one.next = dummyNodeTwo.next;
        two.next = null;

        return dummyNodeZero.next;
    }
    //find intersection node in two LinkedLists
    //TC: O(N) SC: O(1)
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        Node t1 = headA, t2 = headB;

        while(t1 != null && t2 != null){
            if(t1 == t2) return t1;
            t1 = t1.next;
            t2 = t2.next;
            if(t1 == null && t2 != null) t1 = headB;
            if(t2 == null && t1 != null) t2 = headA;
        }
        return null;
    }
    //For adding 1 to LL TC: O(N) SC: O(N)
    public Node addOne(Node head) {
		int carry = helper(head);
		if(carry == 1){
            Node newNode = new Node(1);
			newNode.next = head;
			head = newNode;
		}
		return head;
	}
    //For adding 1 to LL
	public int helper(Node temp){
		if(temp == null) return 1;

		int carry = helper(temp.next);

		temp.data += carry;

		if(temp.data < 10) return 0;

		temp.data = 0;

		return 1;
	}
    //TC: O(max(l1, l2)) SC: O(1) ---> Add two numbers in one LL
    public Node addTwoNumbers(Node l1, Node l2) {
    
        Node t1 = l1, t2 = l2;
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        int carry = 0;
        while(t1 != null || t2 != null){
          int sum = (t1 != null ? t1.data : 0) + (t2 != null ? t2.data : 0) + carry;

          Node newNode = new Node((sum < 10) ? sum : (sum % 10));

            carry = (sum >= 10) ? 1 : 0;

            temp.next = newNode;
            temp = newNode;

            t1 = (t1 != null) ? t1.next : null;
            t2 = (t2 != null) ? t2.next : null;
        }
        if(carry == 1){
            Node newNode = new Node(1);
            temp.next = newNode;
            temp = newNode;
        }
        return dummyNode.next;
    }
    //delete duplicates from sorted lists----> TC: O(N) | SC: O(1)
    public Node deleteDuplicates(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;
        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node prev = dummyNode;
        while(temp != null){
            Node nextNode = temp.next;

            while(nextNode != null && nextNode.data == temp.data) 
                nextNode = nextNode.next;

            if(prev.next.next == nextNode)
                prev = prev.next;
            else{
                    prev.next = nextNode;
                    temp = nextNode;
                    continue;
                }
            temp = temp.next;
        }
        return dummyNode.next;
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

        System.out.println("Is Palindrome: "+sl.isPalindrome(newHead));

        sl.oddEvenList(newHead);
    }
}
