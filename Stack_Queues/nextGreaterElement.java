package Stack_Queues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class nextGreaterElement {
    public static void main(String[] args) {
     int[] nums1 = {4, 1, 2};
     int[] nums2 = {6, 5, 1, 3, 4, 2};
     System.out.println(Arrays.toString(nextGreaterElement1(nums1, nums2)));   
    }
    //OPTIMIZED APPROACH : TC: O(N) SC: O(N)
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] ans = new int[len1];

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int index = len2-1; index >= 0; index--)
        {
            while(!st.isEmpty() && nums2[index] > st.peek())
                st.pop();     

            if(st.isEmpty()) map.put(nums2[index], -1);
            else map.put(nums2[index], st.peek());
            
            st.push(nums2[index]);
        }
        for(int index = 0; index <  len1; index++)
            ans[index] = map.get(nums1[index]);

        return ans;
    }
    //TC: O(N^2 )
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1];
        
        for(int index = 0; index < len1; index++)
        {
            int maxIndex = -1, j = len2-1;
            while(j >= 0 && nums2[j] != nums1[index]){
                if(nums2[j] > nums1[index]){
                    maxIndex = nums2[j];
                }
                j--;
            }
            ans[index] = maxIndex; 
        }
        return ans;
    }

}
