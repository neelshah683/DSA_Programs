package DynamicProgramming;

public class numberOfLIS {
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        System.out.println(numLis(arr));
    }
    public static int numLis(int[] nums)
    {
        int len = nums.length, maxi=1, ans = 0;

        int[] dp = new int[len];
        int[] count = new int[len];

        for(int i=0; i<len; i++)
        {
            dp[i]=count[i]=1;
            for(int j=0; j<i; j++)
            {
                if(nums[j] < nums[i] && 1+dp[j] > dp[i])
                {
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                }    
                else if(nums[j] < nums[i] && 1+dp[j] == dp[i])
                    count[i]+=count[j];
            }
            maxi = Math.max(maxi, dp[i]);
        }
        for(int i=0; i<len; i++)
        {
            if(dp[i]==maxi)
                ans += count[i];
        }
        return ans;
    }
}
