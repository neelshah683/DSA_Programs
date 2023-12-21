package BinarySearch;

import java.util.Arrays;

public class firstAndLastIndex {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 7;
        int[] ans = new int[2];
        ans[0] = firstLastIndex(nums, target, true);
        ans[1] = firstLastIndex(nums, target, false);

        System.out.println(Arrays.toString(ans));
    }
    public static int firstLastIndex(int[] nums, int target, boolean startIndex)
    {
        int start = 0, end = nums.length-1, ans = -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(target < nums[mid])
                end = mid - 1;
            else if(target > nums[mid])
                start = mid + 1;
            else{
                ans = mid;
                if(startIndex)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }
}
