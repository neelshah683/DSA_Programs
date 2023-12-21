package Graph_Technique;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair4{
    int first, second, step;
    Pair4(int x, int y, int z)
    {
        this.first = x;
        this.second = y;
        this.step = z;
    }
}
// If you have to find nearest cell having 0, then just change grid[i][j] == 0
public class distanceNearestCell_having1 {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 0, 1}
        };
        System.out.println(Arrays.deepToString(nearest(grid)));
    }
    public static int[][] nearest(int[][] grid)
    {
        int n = grid.length, m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        Queue<Pair4> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                    q.add(new Pair4(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            int minStep = q.peek().step;
            q.remove();

            dist[row][col] = minStep;

            for(int[] dirs : dir)
            {
                int xRow = row + dirs[0];
                int xCol = col + dirs[1];
                if(xRow>=0 && xRow < n && xCol >=0 && xCol < m && !vis[xRow][xCol])
                {
                    vis[xRow][xCol] = true;
                    q.add(new Pair4(xRow, xCol, minStep + 1));
                }
            }
        }
        return dist;
    }
}
