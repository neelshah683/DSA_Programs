package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair{
        int first, second;
        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
public class shortestPath_DAG {
    public static void dfsTraversal(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj)
    {
        vis[node] = true;
        for(int i = 0; i<adj.get(node).size(); i++)
        {
            int v = adj.get(node).get(i).first;
            if(!vis[v])
                dfsTraversal(v, vis, st, adj);
        }
        st.push(node);
    }
    public static void main(String[] args) {
        int N = 6, M = 7;
        int[][] edges = {
            {0,1,2},
            {0,4,1},
            {4,5,4},
            {4,2,2},
            {1,2,3},
            {2,3,6},
            {5,3,1}
        };
        
        System.out.println(Arrays.toString(shortestPath(N, M, edges)));
        /*Print adj list */
        // for (int i = 0; i < N; i++) {
        //     System.out.print("Adjacency list for vertex " + i + ": ");
        //     for (Pair pair : adj.get(i)) {
        //         System.out.print("(" + pair.first + ", " + pair.second + ") ");
        //     }
        //     System.out.println();
        // }
    }
    public static int[] shortestPath(int N,int M, int[][] edges) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
            adj.add(new ArrayList<Pair>());
            
        for(int i=0; i<M; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<N; i++)
        {
            if(!vis[i])
                dfsTraversal(i, vis, st, adj);
        }
        
        int[] dist = new int[N];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        
        while(!st.isEmpty())
        {
            int node = st.pop();
            
            for(int i=0; i<adj.get(node).size(); i++)
            {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                
                if(dist[node] + wt < dist[v])
                    dist[v] = dist[node] + wt;
            }
            
        }
        
        for(int i=0; i<N; i++)
            if(dist[i] == (int)(1e9))
                dist[i] = -1;
        return dist;
	}
}
