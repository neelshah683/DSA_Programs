public class reverseString {
    
    public static void main(String[] args) {
        String str = "blueprint";
        reverseStr(str);
    }
    static void reverseStr(String s)
    {
        // 1st Approach
        // char[] ch = s.toCharArray();
        // char temp;

        // for(int i=0,j=ch.length-1;i<j;i++,j--)
        // {
        //     temp = ch[i];
        //     ch[i] = ch[j];
        //     ch[j] = temp;
        // }
        // String s1 = new String(ch);
        // System.out.println(s1);

        //2nd Approach
        StringBuffer sb = new StringBuffer();
        for(int i=s.length()-1; i >= 0; i--)
        {
            sb.append(s.charAt(i));
        }
        System.out.print(sb.toString());
    }
}
