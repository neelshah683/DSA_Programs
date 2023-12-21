package DynamicProgramming;

import java.util.Arrays;

public class regularExpMatch2 {
    
    public static void main(String[] args) {
        String s = "mis*is*p*.", p = "mississippi";
        int len1 = s.length(), len2 = p.length();
        int[][] dp = new int[len1][len2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(strMatch(len1-1, s, len2-1, p));
    }
    public static boolean strMatch(int index1, String s1, int index2, String s2)
    {
        if(index1 < 0 && index2 < 0)
            return true;
        if(index1 < 0 && index2 >= 0)
            return false;
        if(index1 >= 0 && index2 < 0)
        {
            if(s1.charAt(index1)=='*')
                return strMatch(index1-2, s1, index2, s2);
            else
                return false;
        }

        if(s1.charAt(index1)=='*')
        {   
            boolean res = false;
            if(s1.charAt(index1-1)==s2.charAt(index2) || s1.charAt(index1-1)=='.')
                res = strMatch(index1, s1, index2-1, s2);
                
            return res || strMatch(index1-2, s1, index2, s2);
        }
        if(s1.charAt(index1)==s2.charAt(index2) || s1.charAt(index1)=='.')
            return strMatch(index1-1, s1, index2-1, s2);

        return false;
    }
}

