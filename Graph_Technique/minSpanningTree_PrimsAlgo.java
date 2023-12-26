package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class minSum{
    int weight, node;
    minSum(int weight, int node)
    {
        this.weight = weight;
        this.node = node;
    }
}
public class minSpanningTree_PrimsAlgo {
    
    public static void main(String[] args) {
        int V = 3, E = 3;
        int[][] edges = {
            {0, 1, 5},
            {1, 2, 3},
            {0, 2, 1}
        };
        System.out.println(makeGraph(V, E, edges));
    }
    public static int spanningTree(int V, ArrayList<ArrayList<minSum>> adj){

        PriorityQueue<minSum> pq = new PriorityQueue<minSum>((x,y) -> x.weight - y.weight);
        pq.add(new minSum(0, 0));
        
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        
        int sum = 0;
        
        while(!pq.isEmpty())
        {
            int nd = pq.peek().node;
            int wt = pq.peek().weight;
            pq.remove();
            
            if(vis[nd] == 1)
                continue;
                
            vis[nd] = 1;
            sum+=wt;
            
            for(int i=0; i<adj.get(nd).size(); i++)
            {
                int n = adj.get(nd).get(i).node;
                int w = adj.get(nd).get(i).weight;
                if(vis[n] == 0)
                    pq.add(new minSum(w, n));
            }
        }
        return sum;
	}
	public static int makeGraph(int V, int E, int[][] edges)
	{
	   ArrayList<ArrayList<minSum>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
            adj.add(new ArrayList<minSum>());
        
        for(int i=0; i<E; i++)
        {
            adj.get(edges[i][0]).add(new minSum(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new minSum(edges[i][2], edges[i][0]));
        }
        int ans = spanningTree(V, adj);
        return ans;
	}
}
