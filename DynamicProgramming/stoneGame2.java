package DynamicProgramming;

import java.util.Arrays;

public class stoneGame2 {
    
    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        System.out.println(stoneGameII(piles));
    }
    public static int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][][] dp = new int[2][n+1][n+1];
        for(int[][] row1 : dp){
            for(int[] row2 : row1)
                Arrays.fill(row2, -1);
        }

        return solveAlice(piles, dp, 0, 1, 1);
    }
    public static int solveAlice(int[] piles, int[][][] dp, int indx, int currPerson, int M){
        if(indx >= piles.length)    return 0;
        if(dp[currPerson][indx][M] != -1)   
            return dp[currPerson][indx][M];

        int stones = 0;
        int result = (currPerson == 1)? -1 : (int)1e9;

        for(int x = 1; x <= Math.min(2 * M, piles.length - indx); x++){
            stones += piles[indx + x - 1];

            if(currPerson == 1)//Alice
                result = Math.max(result, stones + solveAlice(piles, dp, indx + x, 0, Math.max(M, x)));
            else //Bob
                result = Math.min(result, solveAlice(piles, dp, indx + x, 1, Math.max(M, x)));
        }

        return dp[currPerson][indx][M] = result;
    }
}
