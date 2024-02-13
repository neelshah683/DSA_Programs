package Stack_Queues;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement_2 {
    
    public static void main(String[] args) {
        int[] nums = {2, 10, 12, 1, 11};
        System.out.println(Arrays.toString(nextGreaterElements1(nums)));
    }
    public static int[] nextGreaterElements1(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];

        Stack<Integer> st = new Stack<>();

        int len2 = (2 * len -1);
       for(int index = len2; index >= 0; index--)
       {
           while(!st.isEmpty() && nums[index % len] >= st.peek())
                st.pop();

            if(st.isEmpty()) res[index % len] = -1;
            else    res[index % len] = st.peek();

            st.push(nums[index % len]);
       }
        return res;
    }
    //TC: O(N^2) //SC: O(N)
     public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        for(int index = 0; index < len; index++)
        {
            for(int index2 = index + 1; index2 < (2 * len); index2++)
            {
                if(nums[index2 % len] > nums[index]){
                    res[index] = nums[index2 % len];
                    break;
                }
            }
        }
        return res;
    }
}
