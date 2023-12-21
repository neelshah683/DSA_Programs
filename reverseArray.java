public class reverseArray{

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        revArr(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    static void revArr(int[] arr, int start, int end)
    {
        int temp;
        for(int i=start,j=end; i<j; i++,j--)
        {
            temp = arr[i]; 
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}