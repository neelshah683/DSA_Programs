package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class kosarajusAlgo_StronglyConnectedComponents {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(4)));
        adj.add(new ArrayList<Integer>());

        System.out.println(kosaraju(V, adj));

    }
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++)
            if(vis[i] == 0)
                dfsTraversal(i, vis, st, adj);
        
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i=0; i<V; i++)
            adjRev.add(new ArrayList<Integer>());
            
        for(int i=0; i<V; i++)
        {
            for(Integer num : adj.get(i))
            {
                adjRev.get(num).add(i);
            }
        }
        int[] vis2 = new int[V];
        int cnt = 0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(vis2[node] == 0)
            {   
                cnt++;
                dfsTraversal2(node, vis2, adjRev);
            }
            
        }
        return cnt;
    }
    public static void dfsTraversal2(int node, int[] vis2, ArrayList<ArrayList<Integer>> adjRev)
    {
        vis2[node] = 1;
        
        for(int adjNode : adjRev.get(node))
            {
                if(vis2[adjNode] == 0)
                    dfsTraversal2(adjNode, vis2, adjRev);
            }
        
    }
    public static void dfsTraversal(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        
        for(int adjNode : adj.get(node))
            if(vis[adjNode] == 0)
                dfsTraversal(adjNode, vis, st, adj);
        st.push(node);
    }
}
