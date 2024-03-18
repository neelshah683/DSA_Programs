package Strings;

public class repeatedStringMatch {
    
    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }
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
}
