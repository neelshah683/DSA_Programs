package DynamicProgramming.BitMasking;

import java.util.*;

public class selectCellsMaxScore {
    
    public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1, 2, 3));
        grid.add(Arrays.asList(4, 3, 2));
        grid.add(Arrays.asList(1, 1, 1));
        
        int n = grid.size();
        int m =  grid.get(0).size();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int indx = 0; indx < n; indx++){
            for(int indx2 = 0; indx2 < m; indx2++){
                map.computeIfAbsent(grid.get(indx).get(indx2), x -> new ArrayList<>()).add(indx);
            }
        }

        int[][] dp = new int[101][1<<10];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        System.out.println(maxPathScore(map, dp, 1, 0));
    }
    public static int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m =  grid.get(0).size();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int indx = 0; indx < n; indx++){
            for(int indx2 = 0; indx2 < m; indx2++){
                map.computeIfAbsent(grid.get(indx).get(indx2), x -> new ArrayList<>()).add(indx);
            }
        }

        int[][] dp = new int[101][1<<10];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return maxPathScore(map, dp, 1, 0);
    }
    public static int maxPathScore(Map<Integer, List<Integer>> map, int[][] dp, int val, int mask){
        if(val == 101)  return 0;
        if(dp[val][mask] != -1) return dp[val][mask];

        int ans = 0;
        for(int rowNo : map.getOrDefault(val, new ArrayList<Integer>())){
            if((mask & (1<<rowNo)) == 0)
                ans = Math.max(ans, val + maxPathScore(map, dp, val + 1, mask | (1<<rowNo)));
        }
        ans = Math.max(ans, maxPathScore(map, dp, val + 1, mask));

        return dp[val][mask] = ans;
    }
}
