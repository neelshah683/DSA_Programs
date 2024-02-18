package Stack_Queues;
import java.util.Stack;
public class largeRectHistogram {
    
    public static void main(String[] args) {
        int[] heights = {3, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length, maxi = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int index = 0; index <= len; index++) {

            while(!st.isEmpty() && (index == len || heights[index] < heights[st.peek()])){
                int num = heights[st.pop()];
                int width = 0;
                if(st.isEmpty())  width = index;
                else    width = index - st.peek() - 1;
                maxi = Math.max(maxi, num * width);
            }
            st.push(index);
        }
        return maxi;
    }
}
