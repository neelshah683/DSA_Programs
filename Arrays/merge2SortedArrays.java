package Arrays;

import java.util.Arrays;

public class merge2SortedArrays {
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge1(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int pt1 = m-1, pt2 = n-1, i = nums1.length-1;
 
        while(pt2 >= 0)
        {
            if(pt1 >= 0 && nums1[pt1] > nums2[pt2])
                 nums1[i--] = nums1[pt1--];
             else
                 nums1[i--] = nums2[pt2--];
        }
     }
     public static void swap(int[] nums1, int[] nums2, int ind1, int ind2)
    {
        if(nums1[ind1] < nums2[ind2])
        {
            int temp = nums1[ind1];
            nums1[ind1] = nums2[ind2];
            nums2[ind2] = temp;
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1, right = 0;
        while(left >= 0 && right < n)
        {
            if(nums1[left] > nums2[right])
            {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            }
            else
                break;
        }
        int pt = m, x=0;
        while(pt < m + n)
            nums1[pt++] = nums2[x++];
        Arrays.sort(nums1);
    }
}
