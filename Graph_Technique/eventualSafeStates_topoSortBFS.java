package Graph_Technique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class eventualSafeStates_topoSortBFS {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
    
        Queue<Integer> q = new LinkedList<>();
        int[] inDeg = new int[V];
        List<List<Integer>> revAdj = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        
        //reverse all edges then do topoSort
        for(int i=0; i<V; i++)
            revAdj.add(new ArrayList<Integer>());
        
        for(int i=0; i<V; i++)
        {
            for(int val : adj.get(i))
            {
                revAdj.get(val).add(i);
                inDeg[i]++;
            }
        }
        for(int i=0; i<inDeg.length; i++)
            if(inDeg[i] == 0)
                q.add(i);
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            list.add(node);
            
            for(int neighbour : revAdj.get(node))
            {
                inDeg[neighbour]--;
                if(inDeg[neighbour] == 0)
                    q.add(neighbour);
            }
        }
        Collections.sort(list);
        return list;
    }
}
