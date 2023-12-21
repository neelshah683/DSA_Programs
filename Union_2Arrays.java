import java.util.*;

public class Union_2Arrays {
    
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};
        int ans = unionArrays(arr1, arr2);
        System.out.println("Set Size = "+ans);
    }
    static int unionArrays(int[] a, int[] a2)
    {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<a.length; i++)
            set.add(a[i]);

        for(int j=0; j<a2.length; j++)
            set.add(a2[j]);
    
        return set.size();
    }
}
