package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;

public class detectCycleUndirected_DFS {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2, 4)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        System.out.println("Is it a Cycle? "+isCycle(V, adj));
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!vis[i])
                if(checkCycle(i, -1, vis, adj))
                    return true;
        }
        return  false;
    }
    public static boolean checkCycle(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = true;

        for(int neighbour : adj.get(node))
        {
            if(!vis[neighbour])
            {
                if(checkCycle(neighbour, node, vis, adj))
                    return true;   
            }                                 
            else if(parent != neighbour)
                return true;
        }
        return false;
    }
}
