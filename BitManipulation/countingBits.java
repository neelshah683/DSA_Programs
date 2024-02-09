import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countingBits {
    public static void main(String[] args) {
        int N = 5;
        System.out.println(Arrays.toString(countBits(N)));
    }
    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int index = 0; index <= n; index++)
        {
            ans[index] = ans[index >> 1] + (index & 1);  
        }
        return ans;
    }
    public static int[] countBits2(int n) {
        List<Integer> res = new ArrayList<>();
            for(int index = 0; index <= n; index++)
            {
                int num = index;
                int cntBits = 0;
                while(num > 0){
                    cntBits += num & 1;
                    num >>= 1;
                }
                res.add(cntBits);
            }
            int len = res.size();
            int[] ans = new int[len];
            for(int i=0; i<len; i++)
                    ans[i] = res.get(i);            
            return ans;
    }
}
