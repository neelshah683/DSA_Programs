package Stack_Queues;

import java.util.Arrays;
import java.util.Stack;


public class sumSubArrayRanges {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subArrayRanges(nums));
    }
    public static long subArrayRanges(int[] nums) {
        int len = nums.length;
        int[] prevMin = new int[len];
        int[] nextMin = new int[len];
        int[] prevMax = new int[len];
        int[] nextMax = new int[len];

        Arrays.fill(prevMin, -1);
        Arrays.fill(nextMin, len);
        Arrays.fill(prevMax, -1);
        Arrays.fill(nextMax, len);

        Stack<Integer> st = new Stack<>();

        //for prevSmall
        for(int index = 0; index < len; index++){
            while(!st.isEmpty() && nums[index] <= nums[st.peek()])
                st.pop();
            
            if(!st.isEmpty()) 
                prevMin[index] = st.peek();
            
            st.push(index);
        }
        st.clear();
        //for nextSmall
        for(int index = len-1; index >= 0; index--){
            while(!st.isEmpty() && nums[index] < nums[st.peek()])
                st.pop();
            
            if(!st.isEmpty()) 
                nextMin[index] = st.peek();
            
            st.push(index);
            
        }
        st.clear();
        //for prevLarge
        for(int index = 0; index < len; index++){
            while(!st.isEmpty() && nums[index] >= nums[st.peek()])
                st.pop();
            
            if(!st.isEmpty()) 
                prevMax[index] = st.peek();
            
            st.push(index);
            
        }
        st.clear();
        //for nextLarge
        for(int index = len-1; index >= 0; index--){
            while(!st.isEmpty() && nums[index] > nums[st.peek()])
                st.pop();
            
            if(!st.isEmpty()) 
                nextMax[index] = st.peek();
            
            st.push(index);
            
        }
        
        long ans = 0;
        for(int index= 0; index < len; index++){
            int leftMin = index - prevMin[index];
            int rightMin = nextMin[index] - index;
            int leftMax = index - prevMax[index];
            int rightMax = nextMax[index] - index;

            ans += ((long)leftMax * (long)rightMax - (long)leftMin * (long)rightMin) * nums[index];
        }
        return ans;
    }
}
