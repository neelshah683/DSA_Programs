import java.util.ArrayList;

public class subsequenceString {
    
    public static void main(String[] args) {
        
        String str = "abc";
        System.out.println(subseqStrr("",str));
    }

    //Approach 1: Pass ArrayList as a parameter
    // static ArrayList<String> subseqStr(String str1, String str2, ArrayList<String> al)
    // {
    //     if(str2.isEmpty())
    //     {
    //         al.add(str1);
    //         return al;
    //     }

    //     subseqStr(str1 + str2.charAt(0), str2.substring(1),al);
    //     return subseqStr(str1, str2.substring(1), al); 
    // }

    //Approach 2: Use ArrayList inside recursion call
    static ArrayList<String> subseqStrr(String  str1, String str2)
    {
        if(str2.isEmpty())
        {
            ArrayList<String> al = new ArrayList<>();
            al.add(str1);
            return al;
        }

        ArrayList<String> left = subseqStrr(str1 + str2.charAt(0), str2.substring(1));
        ArrayList<String> right = subseqStrr(str1, str2.substring(1));

        left.addAll(right);

        return left;
    }
    
}
