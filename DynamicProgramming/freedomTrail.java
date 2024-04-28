package DynamicProgramming;

import java.util.*;
public class freedomTrail {
    
    public static void main(String[] args) {
        String ring = "aryanmittal", key = "aatl";
        int n1 = ring.length(), n2 = key.length();
        int[][] dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        System.out.println(findRotateSteps(n1, dp, 0, 0, ring , key));
        System.out.println(findRotateSteps2(ring, key));
        System.out.println(findRotateSteps3(ring, key));

    }
    public static int dist(int n, int rgIndx, int kyIndx, String ring, String key){
        int dist1 = Math.abs(rgIndx - kyIndx);
        int dist2 = n - dist1;
        return Math.min(dist1, dist2);
    }      
    //TC : O(N*M*N) | SC: (N*M) + Recursive-Stack Space
    public static int findRotateSteps(int n, int[][] dp, int ringIndex, int keyIndex, String ring, String key){
        if(keyIndex == key.length()) return 0;
        if(dp[ringIndex][keyIndex] != -1)   return dp[ringIndex][keyIndex];
        
        int mini = Integer.MAX_VALUE;
        for(int indx = 0; indx < n; indx++){
            if(ring.charAt(indx) == key.charAt(keyIndex)){
                int totalSteps = dist(n, ringIndex, indx, ring, key) + 1 + findRotateSteps(n, dp, indx, keyIndex+1, ring, key);
                mini = Math.min(mini, totalSteps);
            }
        }
        return dp[ringIndex][keyIndex] = mini;
    }
    //TC : O(N*M*N) | SC: (N*M)
    public static int findRotateSteps2(String ring, String key){
        int n1 = ring.length(), n2 = key.length();
        int[][] dp = new int[n1][n2+1];

        for(int keyIndx = n2-1; keyIndx >= 0; keyIndx--)
        {
            for(int ringIndx = n1-1; ringIndx >= 0; ringIndx--){

                int mini = Integer.MAX_VALUE;
                for(int indx = 0; indx < n1; indx++){
                    if(ring.charAt(indx) == key.charAt(keyIndx)){
                            int totalSteps = dist(n1, ringIndx, indx, ring, key) + 1 + dp[indx][keyIndx+1];
                            mini = Math.min(mini, totalSteps);
                    }
                }
                dp[ringIndx][keyIndx] = mini;
            }
        }
        return dp[0][0];
    }
        //TC : O(N*M*N) | SC: (N)

    public static int findRotateSteps3(String ring, String key){
        int n1 = ring.length(), n2 = key.length();
        int[] prev = new int[n1];
        int[] curr = new int[n1];
        for(int keyIndx = n2-1; keyIndx >= 0; keyIndx--)
        {
            for(int ringIndx = n1-1; ringIndx >= 0; ringIndx--){

                int mini = Integer.MAX_VALUE;
                for(int indx = 0; indx < n1; indx++){
                    if(ring.charAt(indx) == key.charAt(keyIndx)){
                            int totalSteps = dist(n1, ringIndx, indx, ring, key) + 1 + prev[indx];
                            mini = Math.min(mini, totalSteps);
                    }
                }
                curr[ringIndx] = mini;
            }
            prev = (int[])(curr.clone());
        }
        return prev[0];
    }
}
