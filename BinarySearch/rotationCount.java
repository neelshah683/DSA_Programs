package BinarySearch;

public class rotationCount {
    
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int n = arr.length;
        System.out.println(findKRotation(arr, n));
    }
    public static int findKRotation(int arr[], int n) {
        int low = 0, high = n-1, minNum = Integer.MAX_VALUE, ans = 0;;
        
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            
            if(arr[low] <= arr[mid])
            {
                if(arr[low] < minNum)
                {
                    minNum = arr[low];
                    ans = low;
                }
                low = mid + 1;
            }
            else
            {
                if(arr[mid] < minNum)
                {
                    minNum = arr[mid];
                    ans = mid;
                }
                high = mid - 1;
            }
            
        }
        return (arr[0] <= arr[n-1]) ? 0 : ans;
    }
}
