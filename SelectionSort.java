import java.util.Arrays;

public class SelectionSort {
    
    public static void main(String[] args) {
        
        int[] arr = {-3, 1, -5, 4, -2};
        selectionSort(arr);
    }
    static void selectionSort(int[] a)
    {
        for(int i=0;i<a.length-1;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                if(a[j] < a[i])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
