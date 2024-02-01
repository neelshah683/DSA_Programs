
package BinarySearch;

/**
 * medianTwoSortedArrays
 */
public class medianTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 15};
        int[] nums2 = {1, 3, 4, 7, 10, 12};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int left = (n1 + n2 + 1) / 2;
        int chk = n1 + n2;
        int low = 0, high = n1;
        while(low <= high)
        {
            int mid1 = low + (high-low) / 2;
            int mid2 = left - mid1;
            int l1 = (int)-1e9, l2 = (int)-1e9, r1 = (int)1e9, r2 = (int)1e9;
            if(mid1-1 >= 0) l1 = nums1[mid1-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];
            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            if(l1 <= r2 && l2 <= r1)
            {
                if(chk % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / (double)2;
            }
            else if(l2 > r1)
                low = mid1 + 1;
            else
                high = mid1 - 1;
        }
        return 0;
    }
}