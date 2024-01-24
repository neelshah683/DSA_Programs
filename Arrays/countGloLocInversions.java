package Arrays;

public class countGloLocInversions {
    
    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        System.out.println(isIdealPermutation1(nums));
    }
    //Most Optimal One | TC: O(N-2) | SC: O(1)
    public static boolean isIdealPermutation1(int[] nums) {
        int n = nums.length, maxi = 0;
        for(int i=0; i<n-2; i++)
        {
            maxi = Math.max(maxi, nums[i]);
            if(maxi > nums[i+2])
                return false;
        }
        return true;
    }
    //Optimal One | TC: O(N + NLogN) | SC: O(N)
    public static boolean isIdealPermutation(int[] nums) {
        int n = nums.length, locInv = 0;
        for(int i=0; i<n-1; i++)
            if(nums[i] > nums[i+1])
                locInv++;
        int gloInv = mergeSort(nums, 0, n-1);
        return (locInv == gloInv) ? true : false;
    }
    static int mergeSort(int[] a, int s, int e)
    {
        int cnt = 0;
        if(s >= e)
        {
            return cnt;
        }
        int mid = (s + e)/ 2;
        cnt += mergeSort(a, s, mid);
        cnt += mergeSort(a, mid+1, e);
        cnt += conquer(a, s, mid, e);
        return cnt;
    }
    static int conquer(int[] a, int s, int mid, int e)
    {
        int [] merged = new int[e-s+1];
        int index1 = s;
        int index2 = (mid + 1);
        int x = 0;
        int cnt = 0;
        while(index1 <= mid && index2<= e){
            if(a[index1] <= a[index2])
            {
                merged[x] = a[index1];
                index1++;
                x++;
            }
            else{
                cnt += (mid-index1+1);
                merged[x] = a[index2];
                index2++;
                x++;
            }
        }
        while(index1<=mid){
            merged[x] = a[index1];
            index1++;
            x++;
        }
        while(index2<=e){
            merged[x] = a[index2];
            index2++;
            x++;
        }

        for(int i=0,j=s;i<merged.length;i++,j++)
        {
            a[j] = merged[i];
        }
        return cnt;
    }
}
