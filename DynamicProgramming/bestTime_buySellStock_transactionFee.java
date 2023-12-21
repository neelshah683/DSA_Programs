package DynamicProgramming;

public class bestTime_buySellStock_transactionFee {
    
    public static void main(String[] args) {
        
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(buySellStock_fee(prices, fee));
        System.out.println(buySellStock_fee2(prices, fee));
    
    }
    public static int buySellStock_fee(int[] nums, int fee)
    {
        int len = nums.length;
        int[][] dp = new int[len+1][2];
        dp[len][0] = dp[len][1] = 0;

        for(int i=len-1; i>=0; i--)
        {
            for(int j=0; j<2; j++)
            {
                if(j==1)
                    dp[i][j]= Math.max(-nums[i] + dp[i+1][0], dp[i+1][1]);
                else
                    dp[i][j]= Math.max(nums[i] - fee + dp[i+1][1] ,dp[i+1][0]);
            }
        }
        return dp[0][1];
    }
    public static int buySellStock_fee2(int[] nums, int fee)
    {
        int len = nums.length;
        int[] prev = new int[len+1];
        int[] curr = new int[len+1];

        for(int i=len-1; i>=0; i--)
        {
            for(int j=0; j<2; j++)
            {
                if(j==1)
                    curr[j]= Math.max(-nums[i] + prev[0], prev[1]);
                else
                    curr[j]= Math.max(nums[i] - fee + prev[1] , prev[0]);
            }
            prev = curr; 
        }
        return prev[1];
    }
}
