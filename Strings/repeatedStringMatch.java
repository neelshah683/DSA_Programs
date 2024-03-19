package Strings;

public class repeatedStringMatch {
    static long mod = ((long)1e9 + 7);

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch1(a, b));
    }
    //Brute Force Solution
    public static int repeatedStringMatch(String a, String b) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < b.length()){
            sb.append(a);
            cnt++;
        }
        if(sb.toString().contains(b))   return cnt;
        if(sb.append(a).toString().contains(b)) return ++cnt;
        return -1;
    }
    //Optimized Solution : TC: O(N * M) | SC : O(1)
    public static int repeatedStringMatch1(String a, String b) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < b.length()){
            sb.append(a);
            cnt++;
        }
        if(rabinKarpAlgo(sb.toString(), b))  return cnt;
        sb.append(a);
        if(rabinKarpAlgo(sb.toString(), b)) return ++cnt;
        return -1;
    }
     public static long hashValue(String needle, long radix, long len){
        long ans = 0, factor = 1;
        for(long indx = len - 1; indx >= 0; indx--){
            ans += ((needle.charAt((int)indx) - 'a') * factor) % mod;
            factor = (factor * radix) % mod;
        }
        return ans % mod;
    }
    public static boolean rabinKarpAlgo(String hayStack, String needle) {
        long n = hayStack.length(), m = needle.length();
        if(n < m) return false;

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
                    if(j == m - 1) return true;
                }
            }
        }
        return false;
    }
}
