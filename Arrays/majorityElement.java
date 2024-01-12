package Arrays;

public class majorityElement {

    //TC: O(N) SC: O(1) [Using Moor's Voting Algorithm]
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int elmnt = nums[0], cnt = 0;
        for(int i=0; i<n; i++)
        {
            if(cnt == 0 && i!=0)
                elmnt = nums[i];
            if(nums[i] == elmnt)
                cnt++;
            else
                cnt--;
        }
        int cnt2=0;
        for(int var : nums)
            if(elmnt == var)
                cnt2++;

        return (cnt2 > (n/2)) ? elmnt : -1;
    }
}
