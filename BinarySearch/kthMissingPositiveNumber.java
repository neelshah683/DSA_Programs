package BinarySearch;

public class kthMissingPositiveNumber {
    
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(nums, k));
    }
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length, low = 0, high = n-1;
         while(low <= high)
         {
             int mid = low  + (high-low) / 2;
             int missNum = arr[mid] - (mid+1);
             if(missNum < k) 
                 low = mid + 1;
             else
                 high = mid - 1;
         }
         return low + k;
     }
}
