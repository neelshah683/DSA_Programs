package Stack_Queues;
import java.util.Arrays;
import java.util.Stack;
public class nextGreaterElement_latest {
    
    public static void main(String[] args) {
        int[] nums1 ={1, 4, 3, 2, 2, 1, 3};
        System.out.println(Arrays.toString(nextMax(nums1)));
    }
    public static int[] nextMax(int[] nums){
        int len = nums.length;
        Stack<Integer> st = new Stack();

        int[] nextMax = new int[len];

        for(int index = len-1; index >= 0; index--){
            while(!st.isEmpty() && nums[index] > st.peek())
                st.pop();
            
            if(!st.isEmpty()) 
                nextMax[index] = st.peek();
            
            st.push(nums[index]);
            
        }
        return nextMax;
    }
}
