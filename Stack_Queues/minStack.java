package Stack_Queues;

import java.util.Stack;

//using only one stack
class MinStack {

    int mini = Integer.MAX_VALUE;
    Stack<Integer> st = new Stack<>();
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= mini)
        {
            st.push(mini);
            mini = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.pop() == mini)
            mini = st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mini;
    }
}
//Using two Stacks
public class minStack {
    
    Stack<Integer> st1;
    Stack<Integer> st2;
    public minStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int val) {
        st1.push(val);
        if(!st2.isEmpty())
        {
           if(val <= st2.peek())
                st2.push(val); 
        }            
        else
            st2.push(val);
    }
    
    public void pop() {
       
        int x = st1.peek();
        int y = st2.peek();
        if(x == y) 
        {
            st1.pop();
            st2.pop();
        }
        else
            st1.pop();       
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int getMin() {
        return st2.peek();
    }
    public static void main(String[] args) {
            minStack ms = new minStack();
            ms.push(512);
            ms.push(-1024);
            ms.push(-1024);
            ms.push(512);

            ms.pop();

            System.out.println(ms.getMin()); // -1024

            ms.pop();

            System.out.println(ms.getMin()); // -1024

            ms.pop();

            System.out.println(ms.getMin()); // 512
    }
}
