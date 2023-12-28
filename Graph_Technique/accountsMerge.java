package Graph_Technique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int pu = findUlParent(u);
        int pv = findUlParent(v);
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
public class accountsMerge {
    
    public static void main(String[] args) {
        int N = 4;
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<String>(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John","johnsmith@mail.com","john00@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("Mary","mary@mail.com")));
        accounts.add(new ArrayList<String>(Arrays.asList("John","johnnybravo@mail.com")));

        List<List<String>> ans = accountsMerge(accounts);
        System.out.println(ans);
    }
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int n = accounts.size();
    IniConfiguration2 in = new IniConfiguration2(n);

    for(int i=0; i<n; i++)
    {
        for(int j=1; j<accounts.get(i).size(); j++)
        {
            String word = accounts.get(i).get(j);
            if(map.containsKey(word))
                in.unionBySize(map.get(word), i);
            else
                map.put(word, i);
        }
    }
    List<List<String>> list = new ArrayList<>();
    for(int i=0; i<n; i++)
        list.add(new ArrayList<String>());
        
    for(Map.Entry<String, Integer> e : map.entrySet())
    {
      String word = e.getKey();
      int node = in.findUlParent(e.getValue());
      list.get(node).add(word);
    }
    
    List<List<String>> ans = new ArrayList<>();
    List<String> connector = new ArrayList<>();

    for(int i=0; i<n; i++)
    {
            if(list.get(i).size() == 0)
                continue;
            Collections.sort(list.get(i));
            List<String> temp = new ArrayList<>();
            String name = accounts.get(i).get(0);
            temp.add(name);
            for(String email : list.get(i))
                temp.add(email);
            connector = temp;
        ans.add(connector);
    }
    return ans;
  }
}
