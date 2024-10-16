package Strings;

/**
 * longestHappyString
 */
public class longestHappyString {

    public static void main(String[] args) {
        int a = 1, b = 4, c = 5;
        System.out.println(longestDiverseString(a, b, c));
    }
    public static String longestDiverseString(int a, int b, int c) {
        int len = a + b + c;
        String res = "";

        //TC: O(N) | SC: O(1)
        for(int indx = 0; indx < len; indx++){
            int maxCount = Math.max(a,(Math.max(b,c)));
            char prevChar1 = res.isEmpty() ? 'z' : res.charAt(res.length()-1);
            char prevChar2 = res.isEmpty() || res.length() == 1 ? 'z' : res.charAt(res.length()-2);

            if(maxCount == a){
                 if((prevChar2 != 'a' && prevChar1 == 'a') || (prevChar2 == 'a' && prevChar1 != 'a') || (prevChar1 != 'a' && prevChar1 != 'a')){
                    res += 'a';
                    a -= 1;
                }
                else if(b > 0 && b >= c){
                    res += 'b';
                    b -= 1;
                }
                else if(c > 0 && c >= b){
                    res += 'c';
                    c-= 1;
                }
                else if(b == 0 && c == 0)   return res;
            }
            else if(maxCount == b){
                 if((prevChar2 != 'b' && prevChar1 == 'b') || (prevChar2 == 'b' && prevChar1 != 'b') || (prevChar1 != 'b' && prevChar1 != 'b')){
                    res += 'b';
                    b -= 1;
                }
                else if(a > 0 && a >= c){
                    res += 'a';
                    a -= 1;
                }
                else if(c > 0 && c >= a){
                    res += 'c';
                    c-= 1;
                }
                else if(a == 0 && c == 0)   return res;
            }
            else if(maxCount == c){
                if((prevChar2 != 'c' && prevChar1 == 'c') || (prevChar2 == 'c' && prevChar1 != 'c')|| (prevChar1 != 'c' && prevChar1 != 'c')){
                    res += 'c';
                    c -= 1;
                }
                else if(a > 0 && a >= b){
                    res += 'a';
                    a -= 1;
                }
                else if(b > 0 && b >= a){
                    res += 'b';
                    b-= 1;
                }
                else if(a == 0 && b == 0)   return res;
            }
        } 
        return res;  
    }
}