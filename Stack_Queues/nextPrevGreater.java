package Stack_Queues;

import java.util.Arrays;
import java.util.Stack;


public class nextPrevGreater {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 2, 1, 9};
        System.out.println(Arrays.toString(nextMax(nums)));
    }
    public static int[] nextMax(int[] nums){
        int len = nums.length;
        Stack<Integer> st = new Stack();

        int[] nextMax = new int[len];

        for(int index = 0; index < len; index++){
            while(!st.isEmpty() && nums[index] > st.peek())
                st.pop();
            
            if(!st.isEmpty()) 
                nextMax[index] = st.peek();
            
            st.push(nums[index]);
            
        }
        return nextMax;
    }
}
