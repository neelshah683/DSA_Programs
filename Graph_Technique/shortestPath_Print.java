package Graph_Technique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class PairPrint{
    int dist, node;
    public PairPrint(int dist, int node)
    {
        this.dist = dist;
        this.node = node;
    }
}
public class shortestPath_Print {
    
    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {
            {1, 2, 2},
            {2, 5, 5},
            {2, 3, 4},
            {1, 4, 1},
            {4, 3, 3},
            {3, 5, 1}
        };
        ArrayList<ArrayList<PairPrint>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<PairPrint>());

        for(int i=0; i<m; i++)
        {
            adj.get(edges[i][0]).add(new PairPrint(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new PairPrint(edges[i][0], edges[i][2]));
        }
        System.out.println(shortestPath(n, m, adj));
    }
    public static ArrayList<Integer> shortestPath(int n, int m, ArrayList<ArrayList<PairPrint>> adj)
    {
        PriorityQueue<PairPrint> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];

        pq.add(new PairPrint(0, 1));
        dist[1] = 0;

        for(int i=1; i<=n; i++)
        {
            dist[i] = (int)(1e9);
            parent[i] = i;
        }
        while(!pq.isEmpty())
        {
            int distance = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            for(int i=0; i<adj.get(node).size(); i++)
            {
                int nd = adj.get(node).get(i).node;
                int dt = adj.get(node).get(i).dist;

                if(distance + dt < dist[nd])
                {
                    dist[nd] = distance + dt;
                    pq.add(new PairPrint(dist[nd], nd));
                    parent[nd] = node;
                }
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9)
        {
            path.add(-1);
            return path;
        }

        while(parent[n] != n)
        {
            path.add(n);
            n = parent[n];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
