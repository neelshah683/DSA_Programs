package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class PairSP{
    int weight;
    int n;
    PairSP(int n, int weight){
        this.weight = weight;
        this.n = n;
    }
}
public class modifyGraphEdgeWeights_SP {
    
    public static final int INF = (int)2e9;

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
            {4, 1, -1},
            {2, 0, -1},
            {0, 3, -1},
            {4, 3, -1}
        };
        int src = 0, dest = 1, target = 5;
        System.out.println(Arrays.deepToString(modifiedGraphEdges(n, edges, src, dest, target)));
    }
    //TC: O(E * E * LogV) | SC: O(V + E)
    public static int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {

        int currDistance = shortestPath(n, edges, source, destination);

        if(currDistance < target)
            return new int[][] {};
        
        boolean matched = (currDistance == target);

        for(int[] edge : edges){
            if(edge[2] == -1){
                edge[2] = (matched == true) ? INF : 1;

                if(matched != true){
                    int newDistance = shortestPath(n, edges, source, destination);
                    if(newDistance <= target){
                        edge[2] += target - newDistance;
                        matched = true;
                    }
                }
            }
        }
        if(matched != true)
            return new int[][] {};

        return edges;
    }
    public static int shortestPath(int V, int[][] edges, int src, int dest){

        ArrayList<ArrayList<PairSP>> adj = new ArrayList<>();
        for(int indx = 0; indx < V; indx++)
            adj.add(new ArrayList<PairSP>());
        
        int m = edges.length;
        for(int indx = 0; indx < m; indx++){
            int u = edges[indx][0];
            int v = edges[indx][1];
            int wt = edges[indx][2];
            if(wt == -1)
                continue;
            adj.get(u).add(new PairSP(v, wt));
            adj.get(v).add(new PairSP(u, wt));
        }
        
        PriorityQueue<PairSP> pq = new PriorityQueue<PairSP>((a,b) -> (a.weight-b.weight));
        pq.add(new PairSP(src, 0));

        int[] minDist = new int[V];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[src] = 0;

        while(!pq.isEmpty()){
            int node = pq.peek().n;
            int w = pq.peek().weight;
            pq.poll();

            for(int indx = 0; indx < adj.get(node).size(); indx++){
                int chdNode = adj.get(node).get(indx).n;
                int val = adj.get(node).get(indx).weight;

                if(val + w < minDist[chdNode]){
                    minDist[chdNode] = val + w;
                    pq.add(new PairSP(chdNode, minDist[chdNode]));
                }
            }
        }
        return minDist[dest];
    }
}
