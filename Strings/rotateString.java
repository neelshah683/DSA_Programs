package Strings;

public class rotateString {
    public static void main(String[] args) {
        String s1 = "bbbacddceeb";
        String s2 = "ceebbbbacdd";
        System.out.println(rotateString(s1, s2));
    }
    public static boolean rotateString(String s, String goal) {
        int len = s.length(), point2 = goal.indexOf(s.charAt(0));
        for(int point1 = 0; point1 < len; point1++)
        {
            if(s.charAt(point1) != goal.charAt(point2))
                 return false;
            if(point2 == len-1)
                point2 %= (len - 1);
            else
                point2++;
            //  point2 = (point2 == len-1) ? point2 % (len - 1) : point2++;
        }
        return true;
     }
}
