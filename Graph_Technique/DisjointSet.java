package Graph_Technique;

import java.util.ArrayList;
import java.util.List;

//Union by Rank ------->
class IniConfiguration{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    IniConfiguration(int n)
    {
        for(int i=0; i<=n ;i++)
        {
            rank.add(0);
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
    public void unionByRank(int u, int v)
    {
        int pu = parent.get(u);
        int pv = parent.get(v);
        if(rank.get(pu) < rank.get(pv))
            parent.set(pu, pv);
        else if(rank.get(pu) > rank.get(pv))
            parent.set(pv, pu);
        else{
            parent.set(pu, pv);
            int val = rank.get(pv);
            rank.set(pv, val + 1);
        }
    }
}
//Union by Size
class IniConfiguration2{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    IniConfiguration2(int n)
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
    public void unionBySize(int u, int v)
    {
        int pu = parent.get(u);
        int pv = parent.get(v);
        if(pu == pv)
            return ;
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
    }
}
public class DisjointSet {
    public static void main(String[] args) {
        IniConfiguration2 in = new IniConfiguration2(7);
        in.unionBySize(1, 2);
        in.unionBySize(2, 3);
        in.unionBySize(4, 5);
        in.unionBySize(6, 7);
        in.unionBySize(5, 6);

        //checking whether 3 and 7 are connected components
        if(in.findUlParent(3) == in.findUlParent(7))
            System.out.println("Same:");
        else
            System.out.println("Not Same:");

        in.unionBySize(3, 7);

        if(in.findUlParent(3) == in.findUlParent(7))
            System.out.println("Same:");
        else
            System.out.println("Not Same:");

        System.out.println(in.size);
        System.out.println(in.parent);

    }

}
