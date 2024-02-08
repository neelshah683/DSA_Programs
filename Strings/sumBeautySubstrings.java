package Strings;

public class sumBeautySubstrings {
    public static void main(String[] args) {
        String s= "aabcb";
        System.out.println(beautySum(s));
    }
    //TC: O(N^2) + O(2N)
    public static int beautySum(String s) {
        int len = s.length();
        int ans = 0;
       for(int index = 0; index < len; index++)
       {
           int[] freq = new int[26];
           for(int index2 = index; index2 < len; index2++)
           {
               freq[s.charAt(index2)-'a']++;
               ans += chkBeauty(freq);
           }
       }
       return ans;
    }
       public static int chkBeauty(int[] freq)
       {
           int max = getMax(freq);
           int min = getMin(freq);
           return max - min;
       }
       public static int getMax(int[] freq)
       {
           int max = Integer.MIN_VALUE;
           for(int var : freq)
                if(var != 0)
                    max = Math.max(max, var);
            return max;
       }
       public static int getMin(int[] freq)
       {
           int min = Integer.MAX_VALUE;
           for(int var : freq)
                if(var != 0)
                    min = Math.min(min, var);
            return min;
       }
}
