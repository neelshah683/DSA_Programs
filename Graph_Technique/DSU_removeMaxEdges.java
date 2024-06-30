package Graph_Technique;
import java.util.*;

 class DSU{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    DSU(int n)
    {
        for(int i=0; i<=n ;i++)
        {
            size.add(1);
            parent.add(i);
        }
    }
    public int findUlParent(int node)
    {
        if(node == parent.get(node))
            return node;
        int val = findUlParent(parent.get(node));
        parent.set(node, val);
        return parent.get(node);    
    }
    public boolean unionBySize(int u, int v)
    {
        int pu = findUlParent(u);
        int pv = findUlParent(v);
        if(pu == pv)
            return false;
        if(size.get(pu) < size.get(pv))
        {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        }
        else
        {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
        return true;
    }
}
public class DSU_removeMaxEdges {
    
    public static void main(String[] args) {
        int[][] edges = {
            {3, 1, 2},
            {3, 2, 3},
            {1, 1, 3},
            {1, 2, 4},
            {1, 1, 2},
            {2, 3, 4}
        };
        int n = 4;
        System.out.println(maxNumEdgesToRemove(n, edges));
    }
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU Alice = new DSU(n);
        DSU Bob = new DSU(n);

        int aliceEdges = 0, bobEdges = 0;
        int delEdges = 0;
        
        Arrays.sort(edges, (a,b) -> (b[0] - a[0]));

        for(int[] edge : edges){
            //Bob and Alice Both
            if(edge[0] == 3){
                if(Alice.unionBySize(edge[1], edge[2]) == true){
                    Bob.unionBySize(edge[1], edge[2]);
                    aliceEdges++;
                    bobEdges++;
                }
                else
                    delEdges++;
            }
            //Alice Only
            else if(edge[0] == 1){
                if(Alice.unionBySize(edge[1], edge[2]) == true)
                    aliceEdges++;
                else
                    delEdges++;
            }
            //Bob Only
            else{
                if(Bob.unionBySize(edge[1], edge[2]) == true)
                    bobEdges++;
                else
                    delEdges++;
            }
        }
        return (aliceEdges == n-1 && bobEdges == n-1) ? delEdges : -1;
    }
}
