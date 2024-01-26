package BinarySearch;

public class searchRotatedArray {
    
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int target = 1;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int n = nums.length, low = 0, high = n-1;

        while(low<=high)
        {
            int mid = low + (high-low)/ 2;

            if(nums[mid] == target)
                return mid;
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
        return -1;
    }
}
