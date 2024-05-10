package BinarySearch;

public class kthsmallestElementSortedMatrix {
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low) / 2;
            int count = cntSmallEqual(matrix, mid);
            if(count >= k){
                ans = mid;
                high = mid - 1;
            }  
            else    
                low = mid + 1;
        }
        return ans;
    }
    public static int cntSmallEqual(int[][] matrix, int val){
        int n = matrix.length, cnt = 0;
        for(int indx = 0; indx < n; indx++)
            cnt += smallEqual(matrix[indx], val);
        return cnt;
    }
    public static int smallEqual(int[] arr, int val){
        int n = arr.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(arr[mid] <= val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
