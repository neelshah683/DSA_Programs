public class binarySearch_recursion {
    
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 55, 66, 78};
        int target =1, s = 0, e = arr.length -1;

        int ans = binarySearch(arr, target, s, e);
        System.out.println(ans);
    }
    static int binarySearch(int[] a, int target, int s, int e)
    {
        if(s > e)
            return -1;

        int mid = s + (e - s)/2;

        if(target == a[mid])
            return mid;
        else if(target < a[mid])
            return binarySearch(a, target, s, mid - 1);
        else
            return binarySearch(a, target, mid + 1, e);
    }
}
