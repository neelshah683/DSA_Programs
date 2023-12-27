package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//for krushkal's algo
class Edge implements Comparable<Edge> {
    int u, v, wt;
    Edge(int u, int v, int wt)
    {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
    public int compareTo(Edge compareEdge)
    {
        return this.wt - compareEdge.wt;
    }
}
//for prim's algo
class minSum{
    int weight, node;
    minSum(int weight, int node)
    {
        this.weight = weight;
        this.node = node;
    }
}
//for krushkal's algo
class IniConfiguration2{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    IniConfiguration2(int n)
    {
        for(int i=0; i<=n ;i++)
        {
            size.add(1);
            parent.add(i);
        }
    }
    public int findUlParent(int node)
    {
        if(node == parent.get(node))
            return node;
        int val = findUlParent(parent.get(node));
        parent.set(node, val);
        return parent.get(node);    
    }
    public void unionBySize(int u, int v)
    {
        int pu = parent.get(u);
        int pv = parent.get(v);
        if(pu == pv)
            return ;
        if(size.get(pu) < size.get(pv))
        {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        }
        else
        {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
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
    // Using Krushkal's Algorithm [Disjoint Set]
    public static int spanningTree2(int V, int E, ArrayList<ArrayList<Pair>> adj)
	{
	    List<Edge> edges = new ArrayList<>();
	    
	    for(int i=0; i<V; i++)
	    {
	        for(int j=0; j<adj.get(i).size(); j++)
	        {
	            int adjNode = adj.get(i).get(j).node;
	            int wgt = adj.get(i).get(j).weight;
	            int node = i;
	            Edge temp = new Edge(node, adjNode, wgt);
	            edges.add(temp);
	        }
	    }
	    int sumWt = 0;
	    Collections.sort(edges);
	    IniConfiguration2 in = new IniConfiguration2(V);
	    for(int i=0; i<edges.size(); i++)
	    {
	        int src = edges.get(i).u;
	        int dest = edges.get(i).v;
	        int w = edges.get(i).wt;
	        
	        if(in.findUlParent(src) != in.findUlParent(dest))
	        {
	           sumWt+=w;
	           in.unionBySize(src, dest);
	        }
	    }
	    return sumWt;
	}
    // Using Prim's Algorithm
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
