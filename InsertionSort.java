import java.util.Arrays;

public class InsertionSort {
 
    public static void main(String[] args) {
        
        int[] arr = {-3, 1, -5, 4, -2};
        insertionSort(arr);
    }
    static void insertionSort(int[] a)
    {
        for(int i=0;i<a.length-1;i++)
        {
            for(int j=i+1;j>0;j--)
            {
                if(a[j] < a[j-1])
                {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
