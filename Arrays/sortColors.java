package Arrays;

import java.util.Arrays;

public class sortColors {
    
    //TC: O(N) SC: O(1) [Solved Using DNF - Dutch National Flag Algorithm]
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int n = nums.length, low = 0, mid = 0, high = n-1;
        if(n == 1)
            return ;
        while(mid <= high)
        {
            if(nums[mid] == 0)
            {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
                mid++;
            else
            {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] nums, int x, int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
