package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// class Pair5{
//     int xrow, xcol;
//     Pair5(int x, int y)
//     {
//         this.xrow = x;
//         this.xcol = y;
//     }
// }
public class numberof_DistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 1, 0}
        };
        System.out.println(countDistinctIslands(grid));  
    }
    public static int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(!vis[i][j] && grid[i][j] == 1)
                {
                    ArrayList<String> list = new ArrayList<>();
                    dfsTraversal(i, j, i, j, list, vis, grid);
                    System.out.println(list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    private static String toString(int r, int c)
    {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public static void dfsTraversal(int row, int col, int bRow, int bCol, ArrayList<String> list, boolean[][] vis, int[][] grid)
    {
        if(row < 0 || row == grid.length || col < 0 || col == grid[row].length || vis[row][col] == true || grid[row][col] ==0)
            return;
        vis[row][col] = true;
        list.add(toString(row-bRow, col-bCol));
        dfsTraversal(row, col+1, bRow, bCol, list, vis, grid);
        dfsTraversal(row, col-1, bRow, bCol, list, vis, grid);
        dfsTraversal(row+1, col, bRow, bCol, list, vis, grid);
        dfsTraversal(row-1, col, bRow, bCol, list, vis, grid);
    }
}
