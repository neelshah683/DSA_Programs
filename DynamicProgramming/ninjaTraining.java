package DynamicProgramming;

import java.util.Arrays;

public class ninjaTraining {
    
    public static void main(String[] args) {
        int[][] points = {
            {10,40,70},
            {20,50,80},
            {30,60,90}
        };
        int n = points.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(f(n-1, 3, points, dp));
    }
    public static int f(int day, int last, int[][] points, int[][] dp)
    {
        if(day == 0)
        {
            int maxi = 0;
            for(int i=0; i<3; i++)
            {
                if(i!=last)
                {
                    maxi = Math.max(maxi, points[day][i]);
                }
            }
            return  maxi;
        }

        if(dp[day][last]!= -1)
            return dp[day][last];
            
        int maxi = 0;
        for(int i=0; i<3; i++)
        {
            if(i!=last)
            {
                int point = points[day][i] + f(day-1, i, points, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }
}
