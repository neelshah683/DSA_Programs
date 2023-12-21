package DynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class largeRectangleHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(rectHistogram(heights));
        System.out.println(rectHistogram2(heights));

    }
    public static int rectHistogram(int[] nums)
    {
        int len = nums.length;
        int[] leftSmall = new int[len];
        int[] rightSmall = new int[len];
        Stack<Integer>  st = new Stack<Integer>();
        for(int i=0; i<len; i++)
        {
            while(!st.empty() && nums[i] <= nums[st.peek()])
                st.pop();
            
            if(st.empty())  
                leftSmall[i] = 0;
            else    
                leftSmall[i] = st.peek() + 1;     
            st.push(i);
        }

        while(!st.isEmpty())
            st.pop();

        for(int i=len-1; i>=0; i--)
        {
            while(!st.empty() && nums[i] <= nums[st.peek()])
                st.pop();

            if(st.empty())
                rightSmall[i] = len-1;
            else
                rightSmall[i] = st.peek() - 1;    
            st.push(i);
        }  

        int maxi = 0;
        for(int i=0; i<len; i++)
        {
            maxi = Math.max(maxi, (rightSmall[i]-leftSmall[i]+1)*nums[i]);
        }
        return maxi;
    }
    public static int rectHistogram2(int[] nums)
    {
        int len = nums.length;
        Stack<Integer> st = new Stack<>();

        int maxi = 0;
        for(int i=0; i<=len; i++)
        {
            while(!st.empty() && (i==len || nums[st.peek()] >= nums[i]))
            {           
                int height = nums[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxi = Math.max(maxi, width * height);    
            }
            st.push(i);
        }
        return maxi;
    }
    
}
