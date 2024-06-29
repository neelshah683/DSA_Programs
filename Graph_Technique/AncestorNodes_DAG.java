package Graph_Technique;

import java.util.ArrayList;
import java.util.List;

public class AncestorNodes_DAG {
    
    public static void main(String[] args) {
        int[][] edges = {
            {0,3},
            {0,4},
            {1, 3},
            {2, 4},
            {2, 7},
            {3, 5},
            {3, 6},
            {3,7},
            {4, 6}
        };
        int n = 8;
        System.out.println(getAncestors(n, edges));
    }
     public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int idx = 0; idx < n; idx++){
            adj.add(new ArrayList<>());
            res.add(new ArrayList<>());
        }
        
        for(int idx = 0; idx < edges.length; idx++)
            adj.get(edges[idx][0]).add(edges[idx][1]);
        
        for(int idx = 0; idx < n; idx++)
            dfs(idx, idx, adj, res);
        
        return res;
    }
    public static void dfs(int node, int anc, List<List<Integer>> adj, List<List<Integer>> res){

        for(int child : adj.get(node)){
            List<Integer> curr = res.get(child);
            if(curr.isEmpty() || curr.get(curr.size()-1) != anc){
                res.get(child).add(anc);
                dfs(child, anc, adj, res);
            }
        }
    }
}
