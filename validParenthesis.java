public class validParenthesis {
    
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }
    public static boolean isValid(String s) {

    char[] ch = s.toCharArray();

    for(int i=0; i<ch.length-1;)
        {
            for(int j=i+1; j<ch.length; j++)
            {
                if(ch[i] == '(')
                {
                    if(ch[j] == '[' || ch[j] ==  '{')
                        continue;
                    if(ch[j] == ')' && ch[j]!=']' && ch[j]!='}')
                    {
                        i++;
                        break;
                    }
                    else
                        return false;
                }
                if(ch[i] == '[')
                {
                    if(ch[j] == '(' || ch[j] ==  '{')
                        continue;
                    if(ch[j] == ']' && ch[j]!='}' && ch[j]!=')')
                    {
                        i++;
                        break;
                    }
                    else
                        return false;
                }
                if(ch[i] == '{')
                {
                    if(ch[j] == '(' || ch[j] ==  '[')
                        continue;
                    if(ch[j] == '}' && ch[j]!=')' && ch[j]!=']')
                    {
                        i++;
                        break;
                    }
                    else
                        return false;
                }
                i++;
            }
        }
        return true;      
    }
}
