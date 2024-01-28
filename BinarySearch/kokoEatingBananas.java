package BinarySearch;

public class kokoEatingBananas {
    
    public static void main(String[] args) {
        int[] piles= {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = maxNum(piles), res = 0;
        while(low <= high)
        {
            int mid = low + (high-low) / 2;
            int totalHrs = calcHrs(piles, mid);
            if(totalHrs <= h)
            {
                res = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return res;
    }
    public static int calcHrs(int[] piles, int k)
    {
        int ans = 0;
        for(int var: piles)
            ans += Math.ceil((double)var/(double)k);
        return ans;
    }
    public static int maxNum(int[] piles)
    {
        int maxi = Integer.MIN_VALUE;
        for(int var : piles)
            maxi = Math.max(var, maxi);
        return maxi;
    }
}
