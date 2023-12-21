package Graph_Technique;

import java.util.ArrayList;

public class dfsTraversal {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
                
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfsTraversal(0, dfs, vis, adj);
        return dfs;
    }
    public void dfsTraversal(int node, ArrayList<Integer> dfs, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = true;
        dfs.add(node);
        
        for(int neighbour : adj.get(node))
        {
            if(!vis[neighbour])
                dfsTraversal(neighbour, dfs, vis, adj);
        }
    }
}
