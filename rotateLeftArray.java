import java.util.Arrays;

public class rotateLeftArray {
    //1st Approach
    // public static void main(String[] args) {
    //     int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
    //     int d = 2;
    //     rotateLeftArr(arr, d, arr.length);
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         System.out.print(arr[i]+" ");
    //     }
    // }
    // static void rotateLeftArr(int[] arr, int d, int n)
    // {
    //     int[] temp = new int[n];
    //     int k=0;

    //     for(int i=d;i<arr.length;i++)
    //     {
    //         temp[k] = arr[i];
    //         k++;
    //     }

    //     for(int i=0;i<=d-1;i++)
    //     {
    //         temp[k] = arr[i];
    //         k++;
    //     }

    //     for(int i=0;i<n;i++)
    //     {
    //         arr[i] = temp[i];
    //     }
    // }
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        int k = 7;
        rotateLeftArr(arr,k);
    }
    static void rotateLeftArr(int[] nums, int k)
    {
        int n = nums.length,x=0;
        int[] temp = new int[n];
        k = k % n;

        for(int i=0; i<n; i++)
        {
            if(i >= (n-k)){
                temp[x] = nums[Math.abs(n-i-k)];
                x++;
            }
            else{
                temp[x] = nums[k+i];
                x++;
            }
        }
        System.out.print(Arrays.toString(temp));
    }
}

