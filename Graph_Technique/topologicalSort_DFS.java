package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class topologicalSort_DFS {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>(Arrays.asList(3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        int[] vis = new int[V];
        Arrays.fill(vis, Integer.MAX_VALUE);
        System.out.println(Arrays.toString(vis));
        System.out.println(Arrays.toString(topoSort(V, adj)));
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!vis[i])
            {
                dfsTraversal(i, vis, adj, st);
            }
        }
        int[] a = new int[V];
        int x=0;
        while(!st.isEmpty())
        {
            a[x] = st.pop();
            x++;
        }
        return a;
    }
    public static void dfsTraversal(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st)
    {
        vis[node] = true;

        for(int neighbour : adj.get(node))
        {
            if(!vis[neighbour])
                dfsTraversal(neighbour, vis, adj, st);
        }
        st.push(node);
    }
}
