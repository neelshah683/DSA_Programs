package Stack_Queues;

    class StackArr {
        
        int[] st;
        int top;
        StackArr(int capacity) {
            st = new int[capacity];
            top = -1;
        }
        public void push(int num) {
            if(isFull()==1) return ;
            top++;
            st[top] = num;
        }
        public int pop() {
            if(isEmpty() == 1) return -1;
            int x = st[top];
            top--;
            return x;
        
        }
        public int top() {
            if(isEmpty() == 1) return -1;
            return st[top];
        }
        public int isEmpty() {
            return (top == -1) ? 1 : 0;
        }
        public int isFull() {
            return (top == st.length-1) ? 1 : 0;
        }
    }
public class implementStackusingArrays {
    
    public static void main(String[] args) {
        
    }
    
}
