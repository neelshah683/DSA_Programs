package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class articulationPoint_TarjansAlgo {
    static int timer = 1;
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        adj.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        System.out.println(articulationPoints(V, adj));
    }
    public static ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        int[] step = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];

        for(int i=0; i<V; i++)
            if(vis[i] == 0)
                dfsTraversal(i, -1, vis, step, low, mark, adj);
        for(int i=0; i<V; i++)
            if(mark[i] == 1)
                ans.add(i);
        if(ans.size() == 0)
            ans.add(-1);
        return ans;
    }
    public static void dfsTraversal(int node, int parent, int[] vis, int[] step, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        step[node] = timer;
        low[node] = timer;
        timer++;
        int child = 0;
        for(int adjNode : adj.get(node))
        {
            if(adjNode == parent)
                continue;
            if(vis[adjNode] == 0)
            {
              dfsTraversal(adjNode, node, vis, step, low, mark, adj); 
              low[node] = Math.min(low[node], low[adjNode]);
              if(low[adjNode] >= step[node] && parent != -1)
                    mark[node] = 1;
            child++;
            }
            else
            {
                low[node] = Math.min(low[node], step[adjNode]);
            }
        }
        if(child > 1 && parent == -1)
             mark[node] = 1;
    }
}
