package Strings;

import java.util.Arrays;

public class rotateString {
    public static void main(String[] args) {
        String s1 = "bbbacddceeb";
        String s2 = "ceebbbbacdd";
        System.out.println(rotateString1(s1, s2));
    }
    //1st Approach
    public static boolean rotateString1(String s, String goal)
    {
        if(s.length() != goal.length()) return false;
        return (s + s).contains(goal) ? true : false;
    }  
    //2nd Approach | Intuitive 
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int len = s.length();
        for(int i=0; i<len; i++)
        {
            if(chkRotation(s, goal, i))
                 return true;
        }
        return false;      
     }
     public static boolean chkRotation(String s1, String s2, int rotationCount)
     {
         int len = s1.length();
         for(int i=0; i<len; i++)
         {
             if(s1.charAt(i) != s2.charAt((i + rotationCount) % len))
                 return false;
         }
         return true;
     }
}
