package Graph_Technique;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class safestPathGrid {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    //TC: O(N^2LogN) | SC: O(N^2)
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1)));
        list.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        list.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        list.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0)));

        System.out.println(maximumSafenessFactor(list));
    }
    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        
        int n = grid.size();
        int[][] disThief = new int[n][n];

        for(int[] row : disThief)   
            Arrays.fill(row, Integer.MAX_VALUE);

        int low = 0, high = getManhattanDistance(grid, disThief);
        int res = 0;
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(calcSF(disThief, mid)){
                res = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return res;
    }
    public static boolean calcSF(int[][] disThief, int sf){
        if(disThief[0][0] < sf) return false;

        int n = disThief.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        q.add(new int[] {0, 0});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];

            if(row == n-1 && col == n-1)    return true;

            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !vis[newRow][newCol] && disThief[newRow][newCol] >= sf){
                    vis[newRow][newCol] = true;
                    q.add(new int[] {newRow, newCol});
                }
            }
        }
        return false;
    }
    public static int getManhattanDistance(List<List<Integer>> grid, int[][] disThief){
        int n =  grid.size();
        int maxDistance = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int[] row : disThief)   Arrays.fill(row, Integer.MAX_VALUE);

        for(int indx = 0; indx < n; indx++){
            for(int indx2 = 0; indx2 < n; indx2++){
                if(grid.get(indx).get(indx2) == 1){
                    q.add(new int[] {indx, indx2});
                    disThief[indx][indx2] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];

            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && disThief[newRow][newCol] == Integer.MAX_VALUE){
                    disThief[newRow][newCol] = disThief[row][col] + 1;
                    maxDistance = Math.max(maxDistance, disThief[newRow][newCol]);
                    q.add(new int[] {newRow, newCol});
                }
            }
        }
        return maxDistance;
    }
}
