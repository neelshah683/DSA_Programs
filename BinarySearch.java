import java.util.Random;

public class BinarySearch {
    
    public static void main(String[] args) {
        

        int n = 100;
        int arr[] = new int[n];       
        int target = 0;
        getInputRandom(arr,  n);
        double startTime = System.nanoTime();
        int ans = binarySearch(arr, 0, arr.length-1, target);

        System.out.println(System.nanoTime()-startTime);
        if( ans >= 0)
            System.out.println("Element found at position:"+(ans+1));
        else
            System.out.println("Element Not Found:");
    }
   public static void getInputRandom(int[] a, int n)
    {
        for(int i = 0; i < n; i++)
        {
            a[i] = i;
        }
    }

    public static int binarySearch(int[] a, int start, int end, int target)
    {
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(a[mid] == target)
            {
                return mid;
            }
            else if(a[mid] > target)
            {
                end = mid - 1;
            }
            else if(a[mid] < target)
            {
                start = mid + 1;
            }
        }        
        return -1;
    }
}
