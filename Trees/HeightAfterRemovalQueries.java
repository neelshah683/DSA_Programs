package Trees;

public class HeightAfterRemovalQueries {
    
    int[] height = new int[(int) 1e5 + 1];
    int[] level = new int[(int) 1e5 + 1];
    int[] levelMaxHeight = new int[(int) 1e5 + 1];
    int[] levelSMaxHeight = new int[(int) 1e5 + 1];

    //TC: O(N) | SC: O(N)
    public int maxDepth(TreeNode root, int currLevel) {
        if (root == null)
            return 0;

        level[root.val] = currLevel;

        int left = maxDepth(root.left, currLevel + 1);
        int right = maxDepth(root.right, currLevel + 1);

        height[root.val] = 1 + Math.max(left, right);

        if (levelMaxHeight[currLevel] < height[root.val]) {
            levelSMaxHeight[currLevel] = levelMaxHeight[currLevel];
            levelMaxHeight[currLevel] = height[root.val];
        } 
        else if (levelSMaxHeight[currLevel] < height[root.val])
            levelSMaxHeight[currLevel] = height[root.val];

        return height[root.val];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int m = queries.length;
        int[] res = new int[m];

        maxDepth(root, 0);

        //TC: O(M) | SC: O(1)
        for(int indx = 0; indx < m; indx++){
            int nodeLevel = level[queries[indx]];
            int nodeMaxHeight = levelMaxHeight[nodeLevel];

            if(levelMaxHeight[nodeLevel] == height[queries[indx]])
                nodeMaxHeight = levelSMaxHeight[nodeLevel];
            
            res[indx] = nodeLevel + nodeMaxHeight - 1;
        }

        //OVERALL TC: O(N + M) | SC: O(N)
        return res;
    }
    public static void main(String[] args) {
        
    }
}
