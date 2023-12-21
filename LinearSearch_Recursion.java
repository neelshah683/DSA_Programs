import java.util.ArrayList;

public class LinearSearch_Recursion {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        int target = 1;
        
        // System.out.println(findAllIndex(arr, 0, target, new ArrayList<Integer>()));

        System.out.println(findAllIndex2(arr, 0, target));

    }

    static int linearSearch(int[] a, int index, int target) {
        if (a[index] == target)
            return index + 1;

        if (index == a.length - 1)
            return -1;

        return linearSearch(a, index + 1, target);
    }
    
    static ArrayList<Integer> findAllIndex(int[] a, int index, int target, ArrayList<Integer> list) {

        if (a[index] == target)
            list.add(index+1);

        if (index == a.length - 1)
            return list;

        return findAllIndex(a, index + 1, target, list);
    }

    static ArrayList<Integer> findAllIndex2(int[] a, int index, int target) {

        ArrayList<Integer> list = new ArrayList<>();
        if (a[index] == target)
            list.add(index+1);

        if (index == a.length - 1)
            return list;

        ArrayList<Integer> ans = findAllIndex2(a, index + 1, target);

        list.addAll(ans);

        return list;
    }
}
