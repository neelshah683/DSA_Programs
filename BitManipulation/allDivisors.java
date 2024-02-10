import java.util.ArrayList;
import java.util.List;

public class allDivisors {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(allDivisors(N));
    }
    public static List<List<Integer>> allDivisors(int n)
    {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n+1; i++)  list.add(new ArrayList<Integer>());
        for(int index1 = 1; index1 <= n; index1++)
        {
            for(int index2 = index1; index2 <= n; index2 += index1)
            {
                list.get(index2).add(index1);
            }
        }         
        return list;
    }
}
