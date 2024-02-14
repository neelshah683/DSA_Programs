package Stack_Queues;

public class trappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(height));
    }
    //OPTIMAL SOLUTION -> TC: O(N) SC: O(1)
    public static int trap1(int[] height) {
        int len = height.length;
        int leftMax = -1, rightMax  = -1;
        int left = 0, right = len-1;
        int res = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax) leftMax = height[left];
                else    res += (leftMax - height[left]);
                left++;
            }
            else {
                if(height[right] >= rightMax) rightMax = height[right];
                else    res += (rightMax - height[right]);
                right--;
            }
        }
        return res;
    }
    //TC: O(N) -> Prefix - Suffix Approach SC: O(N)
    public static int trap(int[] height) {
        int[] prefix = calcPrefix(height);
        int[] suffix = calcSuffix(height);
        int len = height.length, cntTrap = 0;
        for(int index = 0; index < len; index++){
            cntTrap += (Math.min(prefix[index], suffix[index]) - height[index]);
        }
        return cntTrap;
    }
    public static int[] calcPrefix(int[] height)
    {
        int len = height.length;
        int[] prefix = new int[len];
        prefix[0] = height[0];
        for(int index = 1; index < len; index++)
            prefix[index] = Math.max(prefix[index-1], height[index]);
        return prefix;
    }
    public static int[] calcSuffix(int[] height)
    {
        int len = height.length;
        int[] suffix = new int[len];
        suffix[len-1] = height[len-1];
        for(int index = len-2; index >= 0; index--)
            suffix[index] = Math.max(suffix[index+1], height[index]);
        return suffix;
    }
}
