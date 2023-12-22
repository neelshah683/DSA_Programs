package Graph_Technique;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair_SD{
    int dist, row, col;
    Pair_SD(int dist, int row, int col)
    {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}
public class shortestDistance_binaryMaze {
    
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}
        };
        int[] source = {0, 1};
        int[] destination = {2, 2};
        System.out.println(shortestPath(grid, source, destination));
    }
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {

        if(Arrays.equals(source, destination))
            return 0;
            
        int n = grid.length, m = grid[0].length;
        
        Queue<Pair_SD> q = new LinkedList<>();
        q.add(new Pair_SD(0, source[0], source[1]));
        
        int[][] dist = new int[n][m];
       
        for(int[] row : dist)
            Arrays.fill(row, (int)(1e9));
        
        dist[source[0]][source[1]] = 0;
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!q.isEmpty())
        {
            int dt = q.peek().dist;
            int rw = q.peek().row;
            int cl = q.peek().col;
            q.remove();
            
            for(int[] d : dir)
            {
                int nrow = rw + d[0];
                int ncol = cl + d[1];
                if(nrow >=0 && nrow < n && ncol>=0 && ncol < m && grid[nrow][ncol] == 1)
                {
                   if(dt + 1 < dist[nrow][ncol])
                   {
                       dist[nrow][ncol] = dt + 1;
                       q.add(new Pair_SD(dist[nrow][ncol], nrow, ncol));
                   }
                   if(nrow == destination[0] && ncol == destination[1])
                        return dist[nrow][ncol];
                }
            }
            
        }
        return -1;
    }
}
