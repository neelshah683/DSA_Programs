package Arrays;

import java.util.ArrayList;
import java.util.List;

public class pascalTriangle {
    
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<= numRows; i++)
        {
            int res = 1;
            List<Integer> temp = new ArrayList<>();
            temp.add(res);
            for(int col = 1; col < i; col++)
            {
                res *= (i-col);
                res /= col;
                temp.add(res);
            }
            ans.add(temp);
        }
        return ans;
    }
}
