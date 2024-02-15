package Stack_Queues;
import java.util.Stack;
import java.util.Arrays;
import java.util.Arrays;

public class sumSubarrayMinimum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins1(arr));
    }
    // OPTIMAL SOLUTION TC: O(N) SC: O(N)
    public static int sumSubarrayMins1(int[] arr) {
       long ans = 0;
       int mod = (int)1e9 + 7, len = arr.length;
       int[] left = new int[len];
       int[] right = new int[len];
       Arrays.fill(left, -1);
       Arrays.fill(right, len);
       Stack<Integer> st = new Stack<>();

    //For PrevSmall
       for(int index = 0; index < len; index++){
	        while(!st.isEmpty() && arr[index] <= arr[st.peek()])
	            st.pop();
	            
            if(!st.isEmpty()) left[index] = st.peek();
            
            st.push(index);
	    }
        st.clear();
        //For NextSmall
        for(int index = len-1; index >= 0; index--){
	        while(!st.isEmpty() && arr[index] < arr[st.peek()])
	            st.pop();
	            
            if(!st.isEmpty()) right[index] = st.peek();
            
            st.push(index);
	    }
        for(int index = 0; index < len; index++)
            ans = (ans + (long)arr[index]*(index-left[index])*(right[index]-index))%mod;
        return (int)ans;
    }
    //Brute Force TC: O(N^2) SC: O(1)
    public static int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7;
        int len = arr.length, ans = 0;
        for(int index1 = 0; index1 < len; index1++){
            int min = Integer.MAX_VALUE;
            for(int index2 = index1; index2 < len; index2++){
                if(arr[index2] < min){
                    min = arr[index2];
                }
                ans += min;
            }
            ans %= mod;
        }
        return ans;
    }
}
