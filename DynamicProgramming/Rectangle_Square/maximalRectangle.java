package DynamicProgramming.Rectangle_Square;

import java.util.Stack;

public class maximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        int[] nums = new int[matrix[0].length];
        int maxi = 0;

        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                if(matrix[i][j]=='0')
                    nums[j]=0;
                if(matrix[i][j]=='1')
                    nums[j]+=1;
            }
            maxi = Math.max(maxi, rectHistogram2(nums)); 

        }
        System.out.println(maxi);
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
