package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair3{
    int node, parent;
    Pair3(int x, int y)
    {
        this.node = x;
        this.parent = y;
    }
}
public class detectCycleUndirected_BFS {
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj.add(new ArrayList<Integer>(Arrays.asList(1)));
        adj.add(new ArrayList<Integer>(Arrays.asList(0, 2, 4)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        adj.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        adj.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        System.out.println(adj);
        System.out.println("Is It a Cycle? "+isCycle(V, adj));

    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!vis[i])
                if(checkCycle(i, vis, adj))
                    return true;
        }
        return false;
    }
    public static boolean checkCycle(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj)
    {
          Queue<Pair3> q = new LinkedList<>();
          vis[i] = true;
          q.add(new Pair3(i, -1));
          
          while(!q.isEmpty())
          {
              int chNode = q.peek().node;
              int paNode = q.peek().parent;
              q.remove();
              
              for(int neighbour : adj.get(chNode))
              {
                  if(!vis[neighbour])
                  {
                      vis[neighbour] = true;
                      q.add(new Pair3(neighbour, chNode));
                  }
                  else if(paNode != neighbour)
                    return true;
              }
          }
          return false;
    }
}
