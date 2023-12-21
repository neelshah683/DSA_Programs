package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class letterCombination {
    
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String digits = "23";
        String[] charMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"} ;
        // if(digits.length() == 0)
        //     //return ans;
        backtrack(ans, charMap, digits, new StringBuilder(), 0);
        System.out.println(ans);
    }   
    public static void backtrack(List<String> ans, String[] charMap, String digits, StringBuilder sb, int index)
    {
        if(index==digits.length())
        {
            ans.add(sb.toString());   
            return;
        }
        
        int number = digits.charAt(index) - '0';
        String charLetter = charMap[number-2];

        for(int i=0; i<charLetter.length(); i++)
        {
            sb.append(charLetter.charAt(i));
            backtrack(ans, charMap, digits, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
