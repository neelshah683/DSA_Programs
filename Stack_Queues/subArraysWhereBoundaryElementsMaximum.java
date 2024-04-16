package Stack_Queues;

import java.util.Stack;
import java.util.HashMap;
import java.util.*;
public class subArraysWhereBoundaryElementsMaximum {
    
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 3, 2};
        System.out.println(numberOfSubarrays(nums));
    }
    public static long numberOfSubarrays(int[] nums) {
        long result = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] leftGre = prevGreater(nums);
        for(int indx = 0; indx < nums.length; indx++){
            if(!map.containsKey(nums[indx]))
                map.put(nums[indx], new ArrayList<>());

            map.get(nums[indx]).add(indx);

            result += map.get(nums[indx]).size() - calcSubArr(map.get(nums[indx]), leftGre[indx]);
        }
        return result;
    }
    public static int calcSubArr(List<Integer> index, int target){
        int start = 0, end = index.size()-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(index.get(mid) < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
    public static int[] prevGreater(int[] nums){
        int[] leftGreater = new int[nums.length];
        Arrays.fill(leftGreater, -1);
        Stack<Integer> st = new Stack<>();

        for(int indx = 0; indx < nums.length; indx++){
            while(!st.isEmpty() && nums[indx] >= nums[st.peek()])
                st.pop();
            
            if(!st.isEmpty())
                leftGreater[indx] = st.peek();

            st.push(indx);
        }
        return leftGreater;
    }
}
