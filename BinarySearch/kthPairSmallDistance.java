package BinarySearch;
import java.util.*;

class kthPairSmallDistance {
    
    public static void main(String[] args) {
        int[] nums = {1, 6, 1};
        int k = 3;
        System.out.println(smallestDistancePair1(nums, k));
    }
    //Optimal Solution: TC: O(N log N + N log M) | SC: O(1)
    public static int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);
        
        int maxi = Arrays.stream(nums).max().getAsInt();
        int mini = Arrays.stream(nums).min().getAsInt();

        int low = 0, high = maxi - mini, n = nums.length;

        while(low <= high){

            int mid = low + (high - low) / 2;
            if(calcDistance(nums, mid, k) == true)
                high = mid - 1;
            else
                low = mid + 1;            
        }
        return low;
    }
    public static boolean calcDistance(int[] nums, int d, int k){
        int n = nums.length, cntPairs = 0;

        int left = 0, right = 1;

        while(right < n){
            while(nums[right] - nums[left] > d)
                left++;
            cntPairs += (right - left);
            right++;
        }

        return (cntPairs < k) ? false : true;
    }
    //Optimal Solution 2
    //TC: O(N^2) | SC: O(10^6 -> Worst Case)
    public static int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;

        int maxi = Arrays.stream(nums).max().getAsInt();

        int[] ans = new int[maxi + 1];

        for(int indx = 0; indx < n-1; indx++){
            for(int indx2 = indx + 1; indx2 < n; indx2++){
                int val = Math.abs(nums[indx] - nums[indx2]);
                ans[val]++;
            }
        }

        for(int indx = 0; indx < maxi + 1; indx++){
            while(ans[indx] > 0 && k > 0){
                k--;
                ans[indx]--;
            }
            if(k == 0)  return indx;
        }

        return 0;
    }
}
