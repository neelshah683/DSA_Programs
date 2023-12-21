import java.util.*;

public class Intersection_2Arrays {

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 2, 1, 4 };
        int[] arr2 = { 2, 2, 4 };
        int[] res = intersectArrays(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }

    static int[] intersectArrays(int[] a1, int[] a2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < a1.length; i++)
            set1.add(a1[i]);

        for (int j = 0; j < a2.length; j++) {
            if (set1.contains(a2[j])) {
                set2.add(a2[j]);
            }
        }
        int[] result = new int[set2.size()];
        int x = 0;

        for (Integer i : set2) {
            result[x] = i;
            x++;
        }

        return result;
    }
}
