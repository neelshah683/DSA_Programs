package Strings;

import java.sql.Time;
import java.util.ArrayList;

public class KMPAlgo {
    
    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pattern = "geek";  
        System.out.println(search(pattern, txt)); 
    }
    //KMP (Knuth-Morris-Pratt) Algorithm for pattern searching. 
    //It constructs a concatenated string pat + "#" + txt and then computes the LPS (Longest Prefix Suffix) array
    // to find all occurrences of the pattern pat in the text txt.

    //TC: O(N + M) SC: O(N + M)
    public static ArrayList<Integer> search(String pat, String txt)
    {
        
        String str = pat + "#" + txt;

        int len = str.length();
        int[] lpsArr = new int[len];

        for(int indx = 1; indx <len; indx++){
            int prevIndx = lpsArr[indx - 1];
            
            while(prevIndx > 0 && str.charAt(indx) != str.charAt(prevIndx))
                prevIndx = lpsArr[prevIndx - 1];

            lpsArr[indx] = prevIndx + (str.charAt(indx) == str.charAt(prevIndx) ? 1 : 0);
        }

        int len2 = lpsArr.length;
        ArrayList<Integer> strIndices = new ArrayList<>();
        for(int indx = 0; indx < len2; indx++){
            int ele = lpsArr[indx];
            if(ele == pat.length()){
                int ind = indx - (2 * pat.length());
                if(ind >= 0)
                    strIndices.add(ind+1);
            }
        }
        return strIndices;
    }
}
