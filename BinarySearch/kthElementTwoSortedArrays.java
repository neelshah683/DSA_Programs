package BinarySearch;

public class kthElementTwoSortedArrays {
    
    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 3, 4};
        int k = 2;
        System.out.println(kthElement(nums1, nums2, 2, 3, k));    
    }
    public static int kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        int n1 = n;
        int n2 = m;
        if(n1 > n2) return kthElement(arr2, arr1, n2, n1, k);
        int left = k;
        int chk = n1 + n2;
        int low = Math.max(0, k-n2), high = Math.min(k, n1);
        while(low <= high)
        {
            int mid1 = low + (high-low) / 2;
            int mid2 = left - mid1;
            int l1 = (int)-1e9, l2 = (int)-1e9, r1 = (int)1e9, r2 = (int)1e9;
            if(mid1-1 >= 0) l1 = arr1[mid1-1];
            if(mid2-1 >= 0) l2 = arr2[mid2-1];
            if(mid1 < n1) r1 = arr1[mid1];
            if(mid2 < n2) r2 = arr2[mid2];
            if(l1 <= r2 && l2 <= r1)
                return Math.max(l1, l2);
            else if(l2 > r1)
                low = mid1 + 1;
            else
                high = mid1 - 1;
        }
        return 0;
    }
}
