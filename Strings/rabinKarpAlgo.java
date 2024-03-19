package Strings;
public class rabinKarpAlgo {
    
    static long mod = (long) Math.pow(10, 9) + 7;
    public static void main(String[] args) {
        String a = "abcdabcdabcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }
    public static long hashValue(String needle, long radix, long len){
        long ans = 0, factor = 1;
        for(long indx = len - 1; indx >= 0; indx--){
            ans += ((needle.charAt((int)indx) - 'a') * factor) % mod;
            factor = (factor * radix) % mod;
        }
        return ans % mod;
    }
    public static int repeatedStringMatch(String hayStack, String needle) {
        long n = hayStack.length(), m = needle.length();
        if(n < m) return -1;

        long radix = 26, maxWeight = 1;
        for(long index = 1; index <= m; index++)
            maxWeight = (maxWeight * radix) % mod;

        long hashNeedle = hashValue(needle, radix, m), hashHay = 0;

        for(long indx = 0; indx <= n-m; indx++){
            if(indx == 0)
                hashHay = hashValue(hayStack, radix, m);
            else{
                hashHay = ((hashHay * radix) % mod -((hayStack.charAt((int)indx-1) - 'a') * maxWeight) % mod
                + (hayStack.charAt((int)(indx + m - 1))- 'a') + mod) % mod;
            }

            if(hashHay == hashNeedle){
                for(long j = 0; j < m; j++){
                    if(needle.charAt((int)j) != hayStack.charAt((int)(j + indx))) 
                        break;
                    if(j == m - 1) return (int)indx;
                }
            }
        }
        return -1;
    }
}
