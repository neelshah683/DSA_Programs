import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permutationSequence {
    
    public static void main(String[] args) {
        int n=3, k=1, i=1;
        String s = "";
        while(i<=n)
        {
            s+=i;
            i++;
        }
        ArrayList<String> list = new ArrayList<>(permuteSeq("",s)) ;
        Collections.sort(list);
        System.out.println(list.get(k-1));

    }
    public static List<String> permuteSeq(String p, String up) 
    {
        if(up.isEmpty())
        {
            List<String> list = new ArrayList<>();
            list.add(p);           
            return list;
        }

        List<String> list = new ArrayList<>();

        for(int i=0; i<=p.length(); i++)
        {
            String f = p.substring(0, i);
            String l = p.substring(i, p.length());

            list.addAll(permuteSeq(f + up.charAt(0) + l, up.substring(1)));
        }
        return list;
    }
}
