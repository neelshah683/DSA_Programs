package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;

public class sumDistances {
    
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1},
            {0, 2},
            {2, 3},
            {2, 4},
            {2, 5}
        };
        int n = 6;
        System.out.println(Arrays.toString(sumOfDistancesInTree(n, edges)));
    }
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int indx = 0; indx < n; indx++)
            adj.add(new ArrayList<Integer>());
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] res = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);

        dfs(adj, res, count, 0, -1);
        dfs2(adj, res, count, 0, -1);

        return res;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] res, int[] count, int node, int parent){
        for(int neighbour: adj.get(node)){
            if(neighbour != parent){
                dfs(adj, res, count, neighbour, node);
                count[node] += count[neighbour];
                res[node] += res[neighbour] + count[neighbour];
            }
        }
    }
    public static void dfs2(ArrayList<ArrayList<Integer>> adj, int[] res, int[] count, int node, int parent){
        for(int neighbour: adj.get(node)){
            if(neighbour != parent){
                res[neighbour] = res[node] - count[neighbour] + (count.length - count[neighbour]);
                dfs2(adj, res, count, neighbour, node);
            }
        }
    }
}
