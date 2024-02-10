import java.util.Arrays;

public class leastPrimeFactor {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(Arrays.toString(leastPrimeFactor(N)));
    }
    public static int[] leastPrimeFactor(int n)
    {
        int[] res = new int[n+1];
        Arrays.fill(res, (int)1e9);

        res[0] = 0;
        res[1] = 1;
    
        boolean[] chkPrime = new boolean[n+1];
        Arrays.fill(chkPrime, true);
        chkPrime[0] = false;
        chkPrime[1] = false;

        for(int index1 = 2; index1 <= n; index1++)
        {
            if(chkPrime[index1] == true)
            {
                for(int index2 = index1; index2 <= n; index2 += index1)
                {
                    chkPrime[index2] = false;  
                    //for calculating least prime factor              
                    res[index2] = Math.min(res[index2], index1);

                    //for calculating largest prime factor
                    // res[index2] = Math.max(res[index2], index1);
                }
            }
        } 
        return res; 
    }
}
