import java.util.*;

public class Candies {
    
    public static void main(String[] args) {
        
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        kidsWithCandies(candies, extraCandies);

    }
    public static void kidsWithCandies(int[] candies, int extraCandies)
    {
        List<Boolean> list = new ArrayList<>(candies.length);
        int max = 0;

        for(int i=0; i<candies.length;i++)
        {
            max = Math.max(candies[i],max);
        }
        for(int i=0; i<candies.length;i++)
        {
            int sum = candies[i] + extraCandies;
            if(sum >= max)
                list.add(true);
            else
                list.add(false);
        }
        System.out.println(list);
    }
}
