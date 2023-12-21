import java.util.Random;

public class LinearSearchPrac {

    static void getInputRandom(int[] a, int n)
    {
        for(int i = 0; i < n; i++)
        {
            a[i] = i;
        }
    }

    static void linearSearh(int a[],int key)
    {
        double startTime = System.nanoTime();
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == key)
            {
                System.out.println("Element Found At " + i);
                System.out.println(System.nanoTime()-startTime);
                return;
            }
        }
        System.out.println("Element Not Found");
        System.out.println(System.nanoTime()-startTime);
    }
    public static void main(String[] args) {
        int n = 100;
        int a[] = new int[n];
        getInputRandom(a,  n);

        //Best Case
        linearSearh(a, a[0]);

        //Average Case
        linearSearh(a,a[a.length/2]);
        
        //Worst Case
        linearSearh(a,a[a.length-1]);
    }
}