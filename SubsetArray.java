import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetArray {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3};
        List<List<Integer>> result = subsetArr(arr);
            System.out.print(result);

        System.out.println("\nOPTIONAL--> ");
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(l1);
    }

    static List<List<Integer>> subsetArr(int[] a) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<Integer>());

        for(int n : a)
        {
            int size = outer.size();
            for(int i=0; i<size; i++)
            {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(n);
                outer.add(inner);
            }
        }
        return outer;
    }
}
