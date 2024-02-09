public class cntTotalSetBits {
    public static void main(String[] args) {
        int N = 4;
        System.out.println(countSetBits1(N));
    }
    //Optimal One
    public static int countSetBits1(int n) {
        if(n == 0)
            return 0;
        int x = largestPower(n);
        int addRes1 = x * (1 << (x - 1));
        int addRes2 = (n - (1 << x) + 1);
        int ans = addRes1 + addRes2 + countSetBits(n - (1 << x));
        return ans;
    }
    
    public static int largestPower(int n)
    {
        int x = 0;
        while((1 << x) <= n)
            x++;
        return x-1;
    }

    //Brute One
    public static int countSetBits(int n) {
        int cntBits = 0;
        while(1 <= n)
        {
            int num = n;
            while(num > 0)
            {
                if((num & 1) == 1)
                    cntBits++;
                num = num >> 1;
            }
            n++;
        }
        return cntBits;
    }
}
