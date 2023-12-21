import java.util.Arrays;

public class QuickSort {
    
    public static void main(String[] args) {
        
        int [] arr = {10, 30, 40, 50, 70, 90, 80};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] a, int low, int high)
    {
        if(low < high)
        {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot-1);
            quickSort(a, pivot+1, high);
        }
    }
    static int partition(int[] a, int low, int high)
    {
        int pivot = a[high];
        int i = low - 1;

        for(int j=low; j<high; j++)
        {
            if(a[j] < pivot)
            {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        int temp = a[i];
        a[i] = pivot;
        pivot = temp;

        return i;
    }
}
