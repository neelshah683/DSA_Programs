package BinarySearch;

import java.util.Arrays;

public class mangneticForceBalls {
    
    public static void main(String[] args) {
        int[] position = {22, 57, 74, 79};
        System.out.println(maxDistance(position, 4));
    }
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int maxi = Arrays.stream(position).max().getAsInt();
        int low = 0, high = maxi;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(chkDistance(mid, position, m) == true)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
    public static boolean chkDistance(int dist, int[] position, int m){
        int cnt = 1;
        int chkDistance = position[0] + dist;

        for(int var : position){
            if(var >= chkDistance){
                cnt++;
                chkDistance = var + dist;

                if(cnt == m)    return true;
            }
            
        }
        return false;
    }
}
