package Stack_Queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;



public class nextPrevSmallerElement {
    
    public static void main(String[] args) {
        int[] arr = {1, 6, 2};
        System.out.println(Arrays.toString(leftSmaller(arr.length, arr)));

    }
    public static int[] leftSmaller(int n, int a[])
    {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];	 
           for(int index = 0; index < n; index++){
	        while(!st.isEmpty() && a[index] <= st.peek())
	            st.pop();
	            
            if(st.isEmpty()) ans[index] = -1;
            else    ans[index] = st.peek();
            
            st.push(a[index]);
	    }
	    return ans;
    }
}
