import java.util.Arrays;

public class rotateRightArray {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        int k=2;
        rotate(arr,k);
    }
    static void rotate(int[] nums, int k) {
     int n = nums.length,x=0;
    int[] temp = new int[n];
    k = k % n;
    for(int i=0;i<n;i++)
    {
        if(i < k)
        {
            temp[x] = nums[n+i-k];
            x++;
        }
        else
        {
            temp[x] = nums[i-k];
            x++;
        }
    }
    System.out.print(Arrays.toString(temp));   
  }
}