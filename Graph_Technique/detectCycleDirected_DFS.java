package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;

public class detectCycleDirected_DFS {
    
    public static void main(String[] args) {
        int V = 10;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); 
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<>(Arrays.asList(2)));
        adj.add(new ArrayList<>(Arrays.asList(3)));
        adj.add(new ArrayList<>(Arrays.asList(4, 7)));
        adj.add(new ArrayList<>(Arrays.asList(5)));
        adj.add(new ArrayList<>(Arrays.asList(6)));
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<>(Arrays.asList(5)));
        adj.add(new ArrayList<>(Arrays.asList(9)));
        adj.add(new ArrayList<>(Arrays.asList(10)));
        adj.add(new ArrayList<>(Arrays.asList(8)));
        System.out.println(adj);
        System.out.println("Is it a cycle? "+isCyclic(V, adj));
    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V+1];
        boolean[] pathVis = new boolean[V+1];

        for(int i=0; i <= V; i++)
        {
            if(!vis[i])
            {
                if(dfsTraversal(i, adj, vis, pathVis)==true)
                    return true;
            }
        }
        return false;
    }
    public static boolean dfsTraversal(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis)
    {
        vis[node] = true;
        pathVis[node] = true;

        for(int neighbour : adj.get(node))
        {
            if(!vis[neighbour])
            {
                if(dfsTraversal(neighbour, adj, vis, pathVis)==true)
                    return true;
            }
            else if (pathVis[neighbour] == true)
                return true;
        }
        pathVis[node] = false;
        return false;
    }
}
