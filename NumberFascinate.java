import java.util.Arrays;

public class NumberFascinate {
 
    public static void main(String[] args) {
        System.out.println(isFascinating(192));
    }
    public static boolean isFascinating(int n)
    {
        int n1 = 2*n, n2 = 3 * n, flag = 0;
        String s1 = String.valueOf(n1);
        String s3 = n +s1+ n2;
        char[] ch = s3.toCharArray();
       System.out.println(Arrays.toString(ch));
       Arrays.sort(ch);
         System.out.println(Arrays.toString(ch));
            for(int i=0; i<ch.length-1; i++)
            {
                if(ch[i]=='0')
                    return false;
                if(ch[i] == ch[i+1])
                    return false;
                if(ch[i]>='1' && ch[i]<='9')
                    flag = 1;
            
            }
            if(flag==1)
            {
                return true;
            }        
        return false;
    }
}
