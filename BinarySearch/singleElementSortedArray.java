package BinarySearch;

public class singleElementSortedArray {
    
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int N = nums.length;
        System.out.println(search(nums, N));
    }
    public static int search(int A[], int N)
    {
        int low = 1, high = N-2;
        if(N == 1)
            return A[0];
        if(A[0] != A[1])
            return A[0];
        if(A[N-1] != A[N-2])
            return A[N-1];
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1])
                return A[mid];
            else if((mid % 2 == 1 && A[mid] == A[mid-1]) || (mid % 2 == 0 && A[mid] == A[mid+1]))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
