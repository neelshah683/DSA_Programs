package BinarySearch;

public class minDaysMake_Mbouquets {
    //https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/solutions/2327257/template-one-code-works-for-all-problems
    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2, k = 3;
        System.out.println(minDays(nums, m, k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < (long)m * (long)k) return -1;
        int[] res = minMax(bloomDay);
        int low = res[0], high = res[1];
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            if(chkDay(bloomDay, mid, m, k)==true)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high+1;
    }
    public static int[] minMax(int[] arr)
    {
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for(int var : arr)
        {
            mini = Math.min(mini, var);
            maxi = Math.max(maxi, var);
        }
        return new int[] {mini, maxi};
    }
    public static boolean chkDay(int[] arr, int day, int m, int k)
    {
        int cnt1 = 0, cnt2  = 0;
        for(int var : arr)
        {
            if(var <= day)
            {
                cnt1++;
                if(cnt1 == k)
                {
                    cnt2++;
                    cnt1 = 0;
                }
            }
            else
                cnt1 = 0;
        }
        return (cnt2 >= m) ? true : false;
    }
}
