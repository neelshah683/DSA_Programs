package BinarySearch;

public class findNthRootofM {
    
    public static void main(String[] args) {
        int n = 2, m = 9;
        System.out.println(NthRoot(n,m));
    }
    public static int calc(int mid, int n, int m)
    {
        long ans = 1;
        for(int i=1; i<=n; i++)
        {
            ans *= mid;
            if(ans > m)
                return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
    public static int NthRoot(int n, int m)
    {
       int low = 1, high = m;
       while(low <= high)
       {
           int mid = low + (high-low) / 2;
           int ans = calc(mid, n, m);
           if(ans == 1)
                return mid;
            else if(ans == 2)
                high = mid - 1;
            else
                low = mid + 1;
       }
       return -1;
    }
}
