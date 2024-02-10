import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class countPrimes {
    public static void main(String[] args) {
        int n = 44;
        System.out.println(countPrimes1(n));
    }
    //TC: N Log(Log N) -----> Optimal Approach
    public static List< Integer > countPrimes1(int n) {
        List<Integer> list = new ArrayList<>();

        boolean[] chkPrime = new boolean[n];
        Arrays.fill(chkPrime, true);
        chkPrime[0] = false;
        chkPrime[1] = false;

        for(int index1 = 2; index1 < n; index1++)
        {
            if(chkPrime[index1] == true)
            {
                if((n % index1)==0)
                    list.add(index1);
                for(int index2 = 2 * index1; index2 < n; index2 += index1)
                    chkPrime[index2] = false;                
            }
        } 
        return list;  
    }
    public static List<Integer> countPrimes2(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=n; i++)
        {
            while((n % i) == 0){
                if(!list.contains(i)) list.add(i);
                n = n / i;
            }
        }
        return list;
    }
}
