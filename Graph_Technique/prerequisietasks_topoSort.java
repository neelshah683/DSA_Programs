package Graph_Technique;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class prerequisietasks_topoSort {
    public static void main(String[] args) {
        int V = 2;
        int[][] arr = {
            {1, 0},
            {0, 1}
        };
        System.out.println(isPossible(V, arr));
    }
    public static boolean isPossible(int V, int[][] prerequisites)
    {        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(); 
        
        int n = prerequisites.length;

        for(int i=0; i<V; i++)
            adj.add(new ArrayList<Integer>());
            
        for(int i=0; i<n; i++)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        int[] inDeg = new int[V];
        for(int i=0; i<V; i++)
            for(int val : adj.get(i))
                inDeg[val]++;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDeg.length; i++)
            if(inDeg[i] == 0)
                q.add(i);
        
        int cnt = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            cnt++;
            for(int neighbour : adj.get(node))
            {
                inDeg[neighbour]--;    
                if(inDeg[neighbour] == 0)   
                    q.add(neighbour);
            }
        }
        return cnt == V ? true : false;
    }
}
