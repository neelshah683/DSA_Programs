package Heap;

import java.util.PriorityQueue;

class ListNode{
    ListNode next; 
    int val;
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
//TC: O(KLogK) + O(K*N Log k) SC: O(Log K)
public class mergeKSortedLists {
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode node7 = new ListNode(2);
        ListNode node9 = new ListNode(6);
        node7.next = node9;
        node9.next = null;

        ListNode[] list = new ListNode[4];
        list[0] = node1;
        list[1] = node4;
        list[2] = null;
        list[3] = node7;

        ListNode temp = mergeKLists(list);
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(ListNode node : lists){

            while(node != null){
                pq.add(node.val);
                node = node.next;
            }
        }
        ListNode head = null;
        ListNode curr = null;
        while(!pq.isEmpty()){
            ListNode newNode = new ListNode(pq.poll());

            if(head == null){
                head = newNode;
                curr = newNode;
            }
            else{
                curr.next = newNode;
                curr = newNode;
            }
        }
        return head;
    }
}
