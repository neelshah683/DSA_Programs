public class SortedArray {
    
    public static void main(String[] args) {
        
        int[] arr = {2, 3, 4, 5, 6, 7, 8};

        boolean ans = sortedArr(arr, 0);
        System.out.println(ans);
    }
    static boolean sortedArr(int[] a, int index)
    {
        if(index == a.length - 1)
            return true;

        return a[index] < a[index+1] && sortedArr(a, index+1);
    }
}
