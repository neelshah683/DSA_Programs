package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class Triangle_List {
    public static void main(String[] args) {
        
        List<List<Integer>> al = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );
        int m = al.size();
        int[][] dp = new int[m][m];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(minSum(al, dp, 0, 0));
        System.out.println(minSum2(al));
        System.out.println(minSum3(al));

    }
    public static int minSum(List<List<Integer>> list, int[][] dp, int r, int c)
    {
        if(r == list.size()-1)
            return list.get(r).get(c);
        if(dp[r][c]!=-1)
            return dp[r][c];

        int down = list.get(r).get(c) + minSum(list, dp, r+1, c);
        int right = list.get(r).get(c) + minSum(list, dp, r+1, c+1);

        return dp[r][c] = Math.min(down, right);
    }
    public static int minSum2(List<List<Integer>> list)
    {
            int m = list.size();
            int[][] dp = new int[m][m];
            for (int i=0; i<m; i++){
                dp[m-1][i] = list.get(m-1).get(i);
        }
        for(int i=m-2; i>=0; i--)
        {
            for(int j=0; j<=i; j++)
            {
                int down = list.get(i).get(j) + dp[i+1][j];
                int right = list.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }
    public static int minSum3(List<List<Integer>> list)
    {
            int m = list.size();

            int[] prev = new int[m];

            int[] curr = new int[m];

            for (int i=0; i<m; i++){
                prev[i] = list.get(m-1).get(i);
        }
        for(int i=m-2; i>=0; i--)
        {
            for(int j=0; j<=i; j++)
            {
                int down = list.get(i).get(j) + prev[j];
                int right = list.get(i).get(j) + prev[j+1];

                curr[j] = Math.min(down, right);
            }
            prev=curr;
        }
        return prev[0];
    }
}
