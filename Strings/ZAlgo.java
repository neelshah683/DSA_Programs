package Strings;
import java.util.ArrayList;
import java.util.Arrays;

public class ZAlgo {
    
    //Z-Algorithm for pattern searching.
    public static void main(String[] args) {
        String s = "aaacecaa", p ="aacecaaa";
        System.out.println(search(p,s));
    }
    //The Z-algorithm computes the Z-array, which stores the length of the longest substring 
    //starting from each position that matches a prefix of the string. 
    //This can be used for pattern matching in linear time.

    //TC: O(N) SC: O(N)
    public static ArrayList<Integer> search(String pat, String S)
    {
        ArrayList<Integer> res = new ArrayList<>();
        String str = pat + "#" + S;
        int len = str.length();
        int[] Z = new int[len];
        
        getZArr(str, Z);
        System.out.println(Arrays.toString(Z));
        for(int indx = 0; indx < Z.length; indx++){
            if(Z[indx] == pat.length())
                res.add(indx-pat.length());
        }
        return res;
    }
    public static int[] getZArr(String str, int[] Z){
        int L = 0, R = 0;
        int n = str.length();
        for(int indx = 1; indx < n; indx++){
            
            if(indx > R){
                    L = R = indx;
                    
                    while(R < n && str.charAt(R-L) == str.charAt(R))
                        R++;
                    
                    Z[indx] = R - L;
                    R--;
            }
            else{
                int k = indx - L;
                
                if(Z[k] < R - indx + 1)
                    Z[indx] = Z[k];
                else{
                    L = indx;
                    while(R < n && str.charAt(R-L) == str.charAt(R))
                        R++;
                    
                    Z[indx] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }
}
