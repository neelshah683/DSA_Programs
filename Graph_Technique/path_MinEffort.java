package Graph_Technique;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class minEffort{
    int diff, first, second;
    minEffort(int diff, int first, int second)
    {
        this.diff = diff;
        this.first = first;
        this.second = second;
    }
}
public class path_MinEffort {
    public static void main(String[] args) {
        int[][] heights = {
            {1,2,2},
            {3,8,2},
            {5,3,5}
        };
        System.out.println(minimumEffortPath(heights));
    }
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        
        //Use priority queue instead of queue
        //PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.diff - y.diff);

        Queue<minEffort> pq = new LinkedList<>();        
        int[][] dist = new int[n][m];
        for(int[] row : dist)
            Arrays.fill(row, (int)(1e9));
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        pq.add(new minEffort(0, 0, 0));
        dist[0][0] = 0;
        
        while(!pq.isEmpty())
        {
            int df = pq.peek().diff;
            int rw = pq.peek().first;
            int cl = pq.peek().second;
            pq.remove();
            
            if(rw == n-1 && cl == m-1)
                return df;
            for(int[] dt : dir)
            {
                int nrow = rw + dt[0];
                int ncol = cl + dt[1];
                
                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m)
                {
                    int val = Math.max(Math.abs(heights[rw][cl] - heights[nrow][ncol]), df);
                    if(val < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = val;
                        pq.add(new minEffort(dist[nrow][ncol], nrow, ncol));
                    }
                }
            }
        }
        return -1;
    }
}
