package Arrays;

public class countReversePairs {
    
    public static void main(String[] args) {
        int[] arr = {40, 25, 19, 12, 9, 6, 2};
        int N = arr.length;
        System.out.println(mergeSort(arr, 0, N-1));
    }
    public static int mergeSort(int[] a, int s, int e)
    {
        int cnt = 0;
        if(s >= e)
        {
            return cnt;
        }
        int mid = s + (e-s) / 2;
        cnt += mergeSort(a, s, mid);
        cnt += mergeSort(a, mid+1, e);
        cnt += countPairs(a, s, mid, e);
        conquer(a, s, mid, e);
        return cnt;
    }
    public static int countPairs(int[] arr, int low, int mid, int high)
    {
        int ind1 = low;
        int ind2 = mid + 1;
        int cnt = 0;
        while(ind1 <= mid && ind2 <= high)
        {
            if(arr[ind1] > (2 * (long)arr[ind2]))
            {
                cnt += (mid - ind1 + 1);
                ind2++;
            }
            else
                ind1++;
        }
        return cnt;
    }
    public static void conquer(int[] a, int s, int mid, int e)
    {
        int [] merged = new int[e-s+1];
        int index1 = s;
        int index2 = mid + 1;
        int x = 0;

        while(index1 <= mid && index2<= e){
            if(a[index1] < a[index2])
            {
                merged[x] = a[index1];
                index1++;
                x++;
            }
            else{
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
    }
}
