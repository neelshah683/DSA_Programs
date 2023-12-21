package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    public static void main(String[] args) {
        int n=1, k=4;
        List<List<Integer>> list = new ArrayList<>();
        combineRecursion3(list, new ArrayList<Integer>(), n, k, 1);
        System.out.println(list);
    }
    public static void combineRecursion3(List<List<Integer>> list, ArrayList<Integer> temp, int n, int k, int index)
    {
        if(temp.size() == k && n==0)
            list.add(new ArrayList<>(temp));
        for(int i=index; i<=9; i++)
        {
            if(i>n)
                return;
            temp.add(i);
            combineRecursion3(list, temp, n-i, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
