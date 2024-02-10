import java.util.Arrays;

public class countPrimesLC {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(countPrimes(N));
    }
    //TC: O(N log(log N)) SC: O(1)
     public static int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] chkPrime = new boolean[n];
        Arrays.fill(chkPrime, true);
        chkPrime[0] = false;
        chkPrime[1] = false;
        int count = 0;
        for(int index1 = 2; index1 < n; index1++)
        {
            if(chkPrime[index1] == true)
            {
                count++;
                for(int index2 = 2 * index1; index2 < n; index2 += index1)
                    chkPrime[index2] = false;                
            }
        } 
        return count;     
    }
}
