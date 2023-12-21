import java.util.*;

public class sample{
    static int bal = 5000;

    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);

        int wd = sc.nextInt();

        try{
                withdraw(wd);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    static void withdraw(int amount) throws Exception
    {
        if(bal - amount < 1000)
            throw new Exception("Exception neel");
    }
}