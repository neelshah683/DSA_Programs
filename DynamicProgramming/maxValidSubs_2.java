package DynamicProgramming;

public class maxValidSubs_2 {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(maximumLength(nums, k));
    }
    public static int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[k][k];
        int ans = 0;

        for(int indx = 0; indx < n; indx++){
            int curr = nums[indx] % k;
            for(int prev = 0; prev < k; prev++){
                dp[curr][prev] =  Math.max(dp[curr][prev], 1 + dp[prev][curr]);
                ans = Math.max(ans, dp[curr][prev]);
            }
            
        }
        return ans;
    }
}
