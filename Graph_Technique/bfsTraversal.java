package Graph_Technique;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsTraversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            bfs.add(node);
            
            for(int neighbour : adj.get(node))
            {
                if(vis[neighbour] == false)
                {
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return bfs;
    }
}
