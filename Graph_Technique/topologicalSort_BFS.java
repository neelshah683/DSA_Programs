package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class topologicalSort_BFS {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>());
        adj.add(new ArrayList<Integer>(Arrays.asList(3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        System.out.println(Arrays.toString(topoSort(V, adj)));
    }
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] inDeg = new int[V];
        int[] ans = new int[V];
        int x = 0;
        for(int i=0; i<V; i++)
            for(int val : adj.get(i))
                inDeg[val]++;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDeg.length; i++)
            if(inDeg[i] == 0)
                q.add(i);
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans[x++] = node;

            for(int neighbour : adj.get(node))
            {
                inDeg[neighbour]--;    
                if(inDeg[neighbour] == 0)   
                    q.add(neighbour);
            }
        }
        return ans;
    }
}
