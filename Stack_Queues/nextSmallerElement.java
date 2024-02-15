package Stack_Queues;
import java.util.Stack;
import java.util.Arrays;

public class nextSmallerElement {
    
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 2, 25};
        System.out.println(Arrays.toString(help_classmate(arr, arr.length)));
    }
    public static int[] help_classmate(int arr[], int n) 
	{ 
	    Stack<Integer> st = new Stack<>();
	    int[] ans = new int[n];
	    for(int index = n-1; index >= 0; index--){
	        while(!st.isEmpty() && arr[index] <= st.peek())
	            st.pop();
	            
            if(st.isEmpty()) ans[index] = -1;
            else    ans[index] = st.peek();
            
            st.push(arr[index]);
	    }
	    return ans;
	} 
}
