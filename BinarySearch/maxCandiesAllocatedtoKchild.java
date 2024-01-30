package BinarySearch;

import java.util.Arrays;

public class maxCandiesAllocatedtoKchild {
    
    public static void main(String[] args) {
        int[] nums = {4, 15, 6, 17};
        int k = 3;
        System.out.println(maximumCandies(nums, k));
    }
    public static int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = Arrays.stream(candies).max().getAsInt();
        while(low < high)
        {
            int mid = low + (high-low) / 2;
            if(chkCandyAllocation(candies, mid, k)==true)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return chkCandyAllocation(candies, low, k) ? low : low-1;
    }
    public static boolean chkCandyAllocation(int[] candies, int maxCandy, long k)
    {   
        long cntChild = 0;
        for(int var : candies)
        {
            cntChild += (var/maxCandy);
            if(cntChild >= k) return true;
        }
        return false;
    }
}
