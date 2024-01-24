package Arrays;

public class countInversions {
    
    public static void main(String[] args) {
        long[] arr = {3, 2, 4, 0, 1};
        System.out.println(inversionCount(arr, 5));
    }
    static long inversionCount(long arr[], long N)
    {
        long ans = mergeSort(arr, 0, (int)N-1);
        return ans;
    }
    static long mergeSort(long[] a, int s, int e)
    {
        long cnt = 0;
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
    static long conquer(long[] a, int s, int mid, int e)
    {
        long [] merged = new long[e-s+1];
        int index1 = s;
        int index2 = (mid + 1);
        int x = 0;
        long cnt = 0;
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
