package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class waysDest{
    long first; 
    int second;
    waysDest(long first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
public class noways_arriveAtDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
            {0,1,2},
            {0,6,7},
            {1,2,3},
            {1,3,3},
            {6,3,3},
            {3,5,1},
            {6,5,1},
            {2,5,1},
            {0,4,5},
            {4,6,2}
        };
        System.out.println(countPaths(n, roads));
    }
    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<waysDest>> adj = new ArrayList<>();
       int m = roads.length;
       
       for(int i=0; i<n; i++)
            adj.add(new ArrayList<waysDest>());
        for(int i=0; i<m; i++)
        {
            adj.get(roads[i][0]).add(new waysDest(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new waysDest(roads[i][2], roads[i][0]));
        }
        
        PriorityQueue<waysDest> pq = new PriorityQueue<waysDest>((x, y) -> (int)(x.first - y.first));
        pq.add(new waysDest(0, 0));
        
        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        ways[0] = 1;
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        int mod = (int)(1e9 + 7);

        while(!pq.isEmpty())
        {
            long dt = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            
            for(int i=0; i<adj.get(node).size(); i++)
            {
                int adjNode = adj.get(node).get(i).second;
                long edW = adj.get(node).get(i).first;
                
                if(dt + edW < dist[adjNode])
                {
                    dist[adjNode] = dt + edW;
                    pq.add(new waysDest(dist[adjNode], adjNode));
                    ways[adjNode] = ways[node] % mod;
                }
                else if(dt + edW == dist[adjNode])
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
            }
        }
        return ways[n-1] % mod;
    }
}
