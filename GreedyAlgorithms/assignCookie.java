package GreedyAlgorithms;

import java.util.Arrays;

public class assignCookie {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indx1 = 0, indx2 = 0;
        int len1 = g.length, len2 = s.length;
        int ans = 0;
        while(indx1 < len1 && indx2 < len2){
            if(s[indx2] >= g[indx1]){
                indx1++;
                indx2++;
                ans++;
            }
            else
                indx2++;
        }
        return ans;
    }
}
