import java.util.ArrayList;
import java.util.List;

public class samplePrime {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(countPrimeNo(N));
    }
    public static List<Integer> countPrimeNo(int n)
    {
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<= n; i++)
        {
            int flag = 1;
           for(int j=2; j<=i/2; j++)
           {
                if((i % j) == 0){
                    flag = 0;
                    break;
                }
           } 
           if(flag == 1) 
                list.add(i);
        }
        return list;
    }
}
