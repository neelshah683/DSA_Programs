package Arrays;

import java.util.ArrayList;
import java.util.List;

public class stringCalcTDD_KATA {
    
    public static void main(String[] args) {
        String word = "1,-2,-3";

        String delimiter = ",|\n";
        if(word.startsWith("//")){
            int delimiterIndex = word.indexOf("\n");
            delimiter = word.substring(2, delimiterIndex);
            if(delimiter.startsWith("[") && delimiter.endsWith("]"))
                delimiter = delimiter.substring(1, delimiter.length()-1).replace("][", "|");
            
            word = word.substring(delimiterIndex+1);
        }

        String[] words = word.split("\\"+delimiter);
        try{
            System.out.println(calc(words));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    
    }
    public static int calc(String[] word) throws Exception{
        List<Integer> negative = new ArrayList<>();
        int res = 0;

        if(word.length == 0)
            return 0;

        for(String nums : word){
            int num = Integer.parseInt(nums);
            if(num < 0)
                negative.add(num);
            else if(num <= 1000)  
                res += num;
        }

        if(!negative.isEmpty())
            throw new Exception("Negatives not allowed:"+negative);

        return res;
    }
}
