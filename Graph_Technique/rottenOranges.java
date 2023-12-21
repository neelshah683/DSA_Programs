package Graph_Technique;

import java.util.LinkedList;
import java.util.Queue;

class Pair2 {
    int first;
    int second;
    int time;
    Pair2(int row, int col, int tm) {
        this.first = row;
        this.second =  col;
        this.time = tm;
    }
}
public class rottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println("Min Time = "+orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
    
        int n = grid.length, m = grid[0].length, cntOne = 0;
        Queue<Pair2> q = new LinkedList<Pair2>();
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair2(i, j, 0));
                    vis[i][j] = true;
                }
                if(grid[i][j] == 1)
                    cntOne++;
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int t = 0, cnt = 0;
        while(!q.isEmpty())
        {
            int row = q.peek().first;
            int col = q.peek().second;
            int tm = q.peek().time;
            t = Math.max(t, tm);
            q.remove();

            for(int[] dt : dir)
            {
                int r = row + dt[0];
                int c = col + dt[1];

                if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == 1 && !vis[r][c])
                {
                    q.add(new Pair2(r, c, tm + 1));
                    vis[r][c] = true;
                    cnt++;
                }
            }
        }
        return cnt != cntOne ? -1 : t;
    }
    
}
