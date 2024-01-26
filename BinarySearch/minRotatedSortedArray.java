package BinarySearch;

public class minRotatedSortedArray {
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int n = nums.length, low = 0, high = n-1, ans = Integer.MAX_VALUE;
   
        while(low <= high)
        {
           int mid = low + (high-low) / 2;
           if(nums[low] <= nums[mid])
           {
               ans = Math.min(ans, nums[low]);
               low = mid + 1;
           }
           else
           {
              ans = Math.min(ans, nums[mid]);
              high = mid - 1;
           }
        } 
        return ans;
       }
}
