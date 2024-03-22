package Strings;
import java.util.ArrayList;

public class ZAlgo {
    
    public static void main(String[] args) {
        String s = "ababab", p ="aba";
        System.out.println(search(p,s));
    }
    public static ArrayList<Integer> search(String pat, String S)
    {
        ArrayList<Integer> res = new ArrayList<>();
        String str = pat + "#" + S;
        int len = str.length();
        int[] Z = new int[len];
        
        getZArr(str, Z);
        
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
