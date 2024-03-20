package Strings;

import java.util.ArrayList;
import java.util.List;

public class findBeautifulIndices {
    
    public static void main(String[] args) {
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String pat1 = "my";
        String pat2 = "squirrel";
        int k = 15;

        System.out.println(beautifulIndices(s, pat1, pat2, k));
    }
    public static void computeKMP(String s, String pattern, List<Integer> strIndices){
        //Computing LPS -> Longest Prefix String

        //TC: O(M + N) SC: O(M + N)
        String str = pattern + "#" + s;

        int len = str.length();
        int[] lpsArr = new int[len];

        for(int indx = 1; indx <len; indx++){
            int prevIndx = lpsArr[indx - 1];
            
            while(prevIndx > 0 && str.charAt(indx) != str.charAt(prevIndx))
                prevIndx = lpsArr[prevIndx - 1];

            lpsArr[indx] = prevIndx + (str.charAt(indx) == str.charAt(prevIndx) ? 1 : 0);
        }

        int len2 = lpsArr.length;
        for(int indx = 0; indx < len2; indx++){
            int ele = lpsArr[indx];
            if(ele == pattern.length()){
                int ind = indx - (2 * pattern.length());
                if(ind >= 0)
                    strIndices.add(ind);
            }
        }
    }
    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {    

        List<Integer> finalRes = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        computeKMP(s, a, list1);
        computeKMP(s, b, list2);

        int p1 = 0, p2 = 0;
        while(p1 < list1.size() && p2 < list2.size()){
            if(Math.abs(list1.get(p1) - list2.get(p2)) <= k)
                finalRes.add(list1.get(p1++));
            else if(list2.get(p2) - list1.get(p1) > k) 
                p1++;
            else
                p2++;
        }
        return finalRes;
    }
}
