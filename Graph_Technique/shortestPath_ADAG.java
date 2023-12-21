package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class shortestPath_ADAG {
    public static void main(String[] args) {
        int[][] edges = {
            {0,3},
            {0,1},
            {3,4},
            {4 ,5},
            {5, 6},
            {1,2},
            {2,6},
            {6,7},
            {7,8},
            {6,8}
        };
        int src = 0, n = 9, m = 10;
        System.out.println(Arrays.toString(shortestPath(edges, n, m, src)));
    }
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i=0; i<m; i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;

        while(!q.isEmpty())
        {
            int node = q.peek();
            q.remove();

            for(int neighbour : adj.get(node))
            {
                if(dist[node] + 1 < dist[neighbour])
                {
                    dist[neighbour] = 1 + dist[node];
                    q.add(neighbour);
                }
            }
        } 
        for(int i=0; i<n; i++)
            if(dist[i] == (int)1e9)
                dist[i] = -1;
        return dist;          
    }
}
