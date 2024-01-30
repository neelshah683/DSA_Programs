package BinarySearch;

import java.util.Arrays;

public class aggressiveCows {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 9};
        int k = 3, n = nums.length;
        System.out.println(solve(n, k, nums));
    }
    public static int solve(int n, int k, int[] stalls) {
    
        Arrays.sort(stalls);
        int low = 1;
        int high = Arrays.stream(stalls).max().getAsInt();
        
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            if(chkPlace(stalls, mid, k)==true)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
    public static boolean chkPlace(int[] stalls, int distance, int k)
    {
        int cntCows = 1, n = stalls.length, last = stalls[0];
        
        for(int index = 1; index < n; index++)
        {
            if(stalls[index]-last >= distance)
            {
                cntCows++;
                last = stalls[index];
            }
            if(cntCows == k) return true;
        }
        return false;
    }
}
