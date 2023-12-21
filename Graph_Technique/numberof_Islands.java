package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first, second;
    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
public class numberof_Islands {

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numIslands2(grid));
    }

    //USING DFS TRAVERSAL ====> IDENTICAL ISLANDS
    public static int numIslands(char[][] grid) {
        
        int n = grid.length, m = grid[0].length, cnt = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == '1')
                {
                    cnt++;
                    dfsTraversal(i, j, grid);
                }
            }
        }
        return cnt;
    }
    public static void dfsTraversal(int i, int j, char[][] grid)
    {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        dfsTraversal(i, j+1, grid);
        dfsTraversal(i, j-1, grid);
        dfsTraversal(i+1, j, grid);
        dfsTraversal(i-1, j, grid);

    }

    //USING BFS TRAVERSAL ===> IDENTICAL ISLANDS
    public static int numIslands2(char[][] grid) {
        int n = grid.length, m = grid[0].length, cnt = 0;
        int[][] vis = new int[n][m];
        int[][] dir = {
            {-1, 0},
            {1, 0}, 
            {0, 1},
            {0, -1}
        };
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(vis[i][j] == 0 && grid[i][j] == '1')
                {
                    cnt++;
                    bfsTraversal2(i, j, grid, vis, dir);
                }
            }
        }
        return cnt;
    }
     
    public static void bfsTraversal2(int i, int j, char[][] grid, int[][]vis, int[][] dir)
    {
        vis[i][j] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));
        int n = grid.length, m = grid[0].length;
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int[] data : dir)
            {
                int x = row + data[0];
                int y = col + data[1];
                if(x>=0 && x < n && y >=0 && y < m && vis[x][y] ==0 && grid[x][y]=='1')
                {
                    vis[x][y] = 1;
                    q.add(new Pair(x, y));
                }
            }
        }
    }

    //BFS TRAVERSAL FOR 8 DIRECTIONS ===> CONNECTED ISLANDS
    public static void bfsTraversal3(int i, int j, char[][] grid, int[][] vis)
    {
        vis[i][j] = 1;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));

        int n = grid.length, m = grid[0].length; 

        while(!q.isEmpty())
        {
            int row  = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int delrow = -1; delrow <= 1; delrow++)
            {
                for(int delcol = -1; delcol <= 1; delcol++)
                {
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0)
                    {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
