package DynamicProgramming;

import java.util.Arrays;

public class fill_bookShelve {
    static int width;
    public static void main(String[] args) {
        int[][] books = {
            {1,1},
            {2,3},
            {2,3},
            {1,1},
            {1,1},
            {1,1},
            {1,2}
        };
        int shelfWidth = 4;
        System.out.println(minHeightShelves(books, shelfWidth));
    }
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        width = shelfWidth;

        int[][] dp = new int[1001][1001];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, width, 0, books, dp);
    }
    public static int solve(int indx, int rWidth, int maxHeight, int[][] books, int[][] dp){
        if(indx >= books.length)
            return maxHeight;
        if(dp[indx][rWidth] != -1)  
            return dp[indx][rWidth];

        int curThik = books[indx][0];
        int curHeight = books[indx][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;

        //keep
        if(curThik <= rWidth)
            keep = solve(indx + 1, rWidth - curThik, Math.max(maxHeight, curHeight), books, dp);

        //skip
        skip = maxHeight + solve(indx + 1, width - curThik, curHeight, books, dp);

        return dp[indx][rWidth] = Math.min(keep, skip);
    }
}
