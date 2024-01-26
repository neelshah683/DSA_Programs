package BinarySearch;

public class searchRotatedArrayDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;
        System.out.println(search(nums, target));
    }
    public static boolean search(int[] nums, int target) {
        int n = nums.length, low = 0, high = n-1;

        while(low<=high)
        {
            int mid = low + (high-low)/ 2;

            if(nums[mid] == target)
                return true;

            //Add-On Statement || Follow-Up Question Contains Duplicates
            else if(nums[low] == nums[mid] && nums[mid] == nums[high])
            {
                low++;
                high--;
            }
            else if(nums[low] <= nums[mid])
            {
                if(nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else
            {
                if(nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
