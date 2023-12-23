package Graph_Technique;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class PairK {
    int st, first, second;
    PairK(int st, int first, int second)
    {
        this.st = st;
        this.first = first;
        this.second = second;
    }
}
class Tuple {
    int first, second;
    Tuple(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
public class cheapFlights_withinKstops {
    
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {
            {0,1,100},
            {1,2,100},
            {2,0,100},
            {1,3,600},
            {2,3,200}
        };
        System.out.println(CheapestFLight(n, flights, src, dst, k));
    }
    public static int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        
        int m = flights.length;
        Queue<PairK> q = new LinkedList<>();

        ArrayList<ArrayList<Tuple>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Tuple>());
        for(int i=0; i<m; i++)
            adj.get(flights[i][0]).add(new Tuple(flights[i][1], flights[i][2]));
        
        q.add(new PairK(-1, src, 0));
        
        int[] dist = new int[n];
        for(int i=0; i<dist.length; i++)
            dist[i] = (int)(1e9);
        dist[src] = 0;
        
        while(!q.isEmpty())
        {
          int stops = q.peek().st;
          int node = q.peek().first;
          int cost = q.peek().second;
          q.remove();
          
          if(stops == k)
            continue;
                
          for(int i=0; i<adj.get(node).size(); i++)
          {
              int nodeVal = adj.get(node).get(i).first;
              int dst2 = adj.get(node).get(i).second;
              
              if(cost + dst2 < dist[nodeVal] && stops <= k)
              {
                  dist[nodeVal] = cost + dst2;
                  q.add(new PairK(stops + 1, nodeVal, dist[nodeVal]));
              }
          }
        }
        if(dist[dst] == (int)(1e9))
            return -1;
        return dist[dst];
    }
}
