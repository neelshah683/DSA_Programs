import java.util.ArrayList;

public class PermutationStr {
    
    public static void main(String[] args) {
        
        String str = "";
        String str2 = "abc";
        int k = 3;
        String s = "";
        for(int i=1; i<=3 ; i++)
        {
            s+=i;
        }
        System.out.println(s);
        ArrayList<String> res = permutation(str, str2);
        System.out.println(res.get(k-1));
    }
    // p = process, up = unprocess
    // static void permutation(String p, String up)
    // {
    //     if(up.length()==0)
    //     {
    //         System.out.println(p);  
    //         return ;
    //     }
        
    //     for(int i=0; i<=p.length(); i++)
    //     {
    //         String f = p.substring(0, i);
    //         String s = p.substring(i, p.length());

    //         permutation(f + up.charAt(0) + s, up.substring(1));
    //     }
    // }

    static ArrayList<String> permutation(String p, String up)
    {
        if(up.length()==0)
        {
            ArrayList<String> al = new ArrayList<String>();
            al.add(p);
            return al;
        }

        ArrayList<String> ans = new ArrayList<String>();

        for(int i=0; i<=p.length(); i++)
        {

            String f = p.substring(0, i);
            String s = p.substring(i, p.length());

            ans.addAll(permutation(f + up.charAt(0) + s, up.substring(1)));
        }
        return ans;
    }
}
