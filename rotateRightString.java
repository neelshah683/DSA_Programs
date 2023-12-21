public class rotateRightString {
    
    public static void main(String[] args) {
        String s = "GeeksforGeeks";
        int d = 4;
        rotateRightStr(s,d);
    }
    static void rotateRightStr(String s1, int k)
    {
        //1st Approach
        // int n = s1.length();
        // char[] ch = new char[n];
        // ch = s1.toCharArray();
        // char x=0;
        // k = k % n;
        // for(int i=0;i<n;i++)
        // {
        //     if(i < k) {
        //         ch[x] = s1.charAt(n+i-k);   
        //         x++;
        //     }
        //     else{
        //         ch[x] = s1.charAt(i-k);
        //         x++;
        //     }
        // }
        // System.out.println(String.valueOf(ch));

        //2nd Approach
        System.out.print(s1.substring(s1.length()-k) + s1.substring(0, s1.length()-k));
    }
}
