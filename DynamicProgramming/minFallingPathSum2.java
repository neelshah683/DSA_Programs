package DynamicProgramming;
import java.util.*;
public class minFallingPathSum2 {
    
    public static void main(String[] args) {
        
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int n = grid.length, res = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        for(int col = 0; col < n; col++)
            res = Math.min(res, minPathSum(grid, dp, n, n-1, col, col));

        System.out.println(res);

        System.out.println(minPathSum2(grid));
        System.out.println(minPathSum3(grid));
        System.out.println(minPathSum4(grid));

    }
    //Memoization: TC: O(N^3) | SC: O(N^2) + Recursive-Stack Space
    public static int minPathSum(int[][] grid, int[][] dp, int n, int r, int c, int markPoint){
        if(r < 0 || c < 0 || c == grid.length)  return (int)(1e9);
        if(r == 0)  return grid[r][c];
        if(dp[r][c] != -1)  return dp[r][c];

        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++){
            if(col == markPoint) continue;
            int minPath = grid[r][c] + minPathSum(grid, dp, n, r-1, col, col);
            ans = Math.min(ans, minPath);
        }
        
        return dp[r][c] = ans;
    }
    //TABULATION: TC: O(N^3) | SC: O(N^2)
    public static int minPathSum2(int[][] grid){
        int n = grid.length;
        int[][] dp = new int[n][n];
        for(int col = 0; col < n; col++)
            dp[0][col] = grid[0][col];
        
        for(int row = 1; row < n; row++)
        {
            for(int col = 0; col < n; col++){

                int ans = Integer.MAX_VALUE;
                for(int inCol = 0; inCol < n; inCol++){
                    if(inCol == col) continue;
                    int minPath = grid[row][col] + dp[row-1][inCol];
                    ans = Math.min(ans, minPath);
                }
                
                dp[row][col] = ans;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++)
            res = Math.min(res, dp[n-1][col]);
        return res;
    }
    //TABULATION : TC: O(N^3) | SC:O(N)
    public static int minPathSum3(int[][] grid){
        int n = grid.length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        for(int col = 0; col < n; col++)
            prev[col] = grid[0][col];
        
        for(int row = 1; row < n; row++)
        {
            for(int col = 0; col < n; col++){

                int ans = Integer.MAX_VALUE;
                for(int inCol = 0; inCol < n; inCol++){
                    if(inCol == col) continue;
                    int minPath = grid[row][col] + prev[inCol];
                    ans = Math.min(ans, minPath);
                }
                
                curr[col] = ans;
            }
            prev = (int[])(curr.clone());
        }
        int res = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++)
            res = Math.min(res, prev[col]);
        return res;
    }
    //Tabulation: TC: O(N^2) | SC: O(N)
    public static int minPathSum4(int[][] grid) {
        int n = grid.length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        for(int col = 0; col < n; col++)
            prev[col] = grid[0][col];
        
        for(int row = 1; row < n; row++)
        {
           
           PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int prevCol = 0; prevCol < n; prevCol++)
                pq.add(prev[prevCol]);

            int min1 = pq.poll();
            int min2 = pq.poll();

            for(int col = 0; col < n; col++){

                if(prev[col] == min1)             
                    curr[col] = grid[row][col] + min2;
                else
                    curr[col] = grid[row][col] + min1;
            }
            prev = (int[])(curr.clone());
        }
        int res = Integer.MAX_VALUE;
        for(int col = 0; col < n; col++)
            res = Math.min(res, prev[col]);
        return res;
    }
}
