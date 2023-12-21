package DynamicProgramming;

public class bestTime_buySellStock {
    
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 0, 6, 4};

        int min = arr[0], cost = 0, maxi = 0;
        for(int i=1; i<arr.length; i++)
        {
            cost = arr[i] - min;
            maxi = Math.max(maxi, cost);
            min = Math.min(arr[i], min);
        }
        System.out.println(maxi);
    }
   
}
