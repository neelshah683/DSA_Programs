import java.util.*;

public class SlidingWindow_MaximumSumSubarraySizek {
    
    public static void main(String[] args) {
        
        int[] arr = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        int n = arr.length;
        int max = maximumSumSubarray(arr, k, n);
        System.out.println("Maximum = "+ max);
    }
    static int maximumSumSubarray(int[] nums, int k, int n){

        int max=0;
        for(int i=0; i+k <= n;i++)
        {
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = 0;

            for(int j=i; j<i+k;j++)
            {          
                if(map.containsKey(nums[j]))
                {
                    sum = 0;
                    break;
                }
                else
                {
                    map.put(nums[j], 1);
                    sum += nums[j];
                }
            }

            if(sum > max)
                max = sum;
            
        }
        return max;
    }

}
