package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair_Dij
{
    int first, second;
    Pair_Dij(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
public class shortestPath_Dijkstra {
    public static void main(String[] args) {
        int V = 5, S = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        //constructing min-heap
      PriorityQueue<Pair_Dij> pq = new PriorityQueue<Pair_Dij>((x,y) -> x.first - y.first);
      pq.add(new Pair_Dij(0, S));
       
       int[] dist = new int[V];
       Arrays.fill(dist, (int)1e9);
       dist[S] = 0;
       
       while(!pq.isEmpty())
       {
           int distance = pq.peek().first;
           int node = pq.peek().second;
           pq.remove();
           
           for(int i=0; i<adj.get(node).size(); i++)
           {
               int n = adj.get(node).get(i).get(0);
               int val = adj.get(node).get(i).get(1);
               
               if(distance + val < dist[n])
               {
                   dist[n] = distance + val;
                   pq.add(new Pair_Dij(dist[n] ,n));
               }
           }
       }
       return dist;
    }
}
