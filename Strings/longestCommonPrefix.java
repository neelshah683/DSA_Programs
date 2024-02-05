package Strings;

import java.util.Arrays;

public class longestCommonPrefix {
    
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1(str));

    }
    //1st Approach : Optimized
     public static String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        String res = "";
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int len = Math.min(s1.length(), s2.length());
        int index = 0;
        while(index < len)
        {
            if(s1.charAt(index) == s2.charAt(index))
            {
                res += s1.charAt(index);
                index++;
            }
            else
                break;
        }
        return res.isEmpty() ? "" : res;
    }
    //2nd Appraoch : Brute Force Solution.
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length, minCharsEqual = Integer.MAX_VALUE;
        String res = "";
        for(int i=0; i<n-1; i++)
        {
            String s1 = strs[i];
            String s2 = strs[i+1];
            int charEqual = chkStr(s1, s2);
            if(charEqual == 0)
                return "";
            minCharsEqual = Math.min(minCharsEqual, charEqual);
        }
        return strs[0].substring(0, minCharsEqual);
    }
    public static int chkStr(String s1, String s2)
    {
        int len = Math.min(s1.length(), s2.length()), index = 0, cnt = 0;
        while(index < len)
        {
            if(s1.charAt(index) == s2.charAt(index))
                cnt++;
            else
                break;
            index++;
        }
        return cnt;
    }
}
