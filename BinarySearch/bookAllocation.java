package BinarySearch;

import java.util.Arrays;

public class bookAllocation {
    
    public static void main(String[] args) {
        int[] nums = {25, 46, 28, 49, 24};
        int N = nums.length, M = 4;
        System.out.println(findPages(nums, N, M));
    }
    public static int findPages(int[]A,int N,int M)
    {
        if(N < M) return -1;
        int low = Arrays.stream(A).max().getAsInt();
        int high = Arrays.stream(A).sum();
        
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            if(chkPossible(A, mid, M)==true)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public static boolean chkPossible(int[] nums, int mid, int M)
    {
        int cntStudent = 1, sumPages = 0;
        
        for(int var : nums)
        {
            sumPages += var;
            if(sumPages > mid)
            {
                cntStudent++;
                sumPages = var;
            }
        }
        return (cntStudent <= M) ? true : false;
    }
}
