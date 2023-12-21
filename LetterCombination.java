import java.util.ArrayList;

public class LetterCombination {
    
    public static void main(String[] args) {
        
        String str = "23";
        ArrayList<String> result = new ArrayList<String>();
        result = letterCombine("", str);
        System.out.println(result);
        float f = 12.2f;
        double d = 12.2;
        System.out.println (("c"+str).getClass().getSimpleName());
        System.out.println(str.getClass().getSimpleName());
    }
    static ArrayList<String> letterCombine(String p, String up)
    {
        if(up.length() == 0)
        {
            ArrayList<String> al = new ArrayList<String>();
            al.add(p);
            return al;
        }

        int digit = Character.getNumericValue(up.charAt(0));

        ArrayList<String> ans = new ArrayList<String>();

        for(int i = (digit - 1) * 3; i < digit * 3; i++)
        {
            char ch = (char)('a' + i);

            ans.addAll(letterCombine(p + ch, up.substring(1)));
        }

        return ans;
    }
}

