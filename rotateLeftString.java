public class rotateLeftString {
    
    public static void main(String[] args) {
        String s = "rcti";
        int d = 5;
        rotateLeftStr(s,d);
    }
    static void rotateLeftStr(String s, int k)
    {
        //1st Approach
        // System.out.print(s.substring(k) + s.substring(0,k));

        //2nd Approach
        int n = s.length(),x=0;
        char[] ch = new char[n];
        ch = s.toCharArray();

        k = k % n;
        for(int i=0; i<n;i++)
        {
            if(i < (n-k)){
                ch[x] = s.charAt(k+i);
                x++;
            }
            else{
                ch[x] = s.charAt(Math.abs(n-i-k));
                x++;
            }
        }
        System.out.print(String.valueOf(ch));
    }
}
