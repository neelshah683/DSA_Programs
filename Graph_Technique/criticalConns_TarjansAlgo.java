package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class criticalConns_TarjansAlgo {
    static int timer = 1;
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        connections.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        connections.add(new ArrayList<Integer>(Arrays.asList(2, 0)));
        connections.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        
        System.out.println(criticalConnections(n, connections));
    }
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Integer>());

        for(List<Integer> list : connections)
        {
            int u = list.get(0);
            int v = list.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] step = new int[n];
        int[] lowest = new int[n];
        dfsTraversal(0, -1, vis, step, lowest, adj, ans);
        return ans;
    }
    public static void dfsTraversal(int node, int parent, int[] vis, int[] step, int[] lowest, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> ans)
    {
        vis[node] = 1;
        step[node] = timer;
        lowest[node] = timer;
        timer++;

        for(int adjNode : adj.get(node))
        {
            if(adjNode == parent)
                continue;
            if(vis[adjNode] == 0)
            {
                dfsTraversal(adjNode, node, vis, step, lowest, adj, ans);
                lowest[node] = Math.min(lowest[node], lowest[adjNode]);
                if(lowest[adjNode] > step[node])
                    ans.add(new ArrayList<Integer>(Arrays.asList(node, adjNode)));
            }
            else
            {
                lowest[node] = Math.min(lowest[node], lowest[adjNode]);
            }
        }
    }
}
