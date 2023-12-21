package Trees;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val)
    {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
public class Solution {
    static int index = 0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstPreorder(preorder, Integer.MAX_VALUE);
    }
    public static TreeNode bstPreorder(int[] preorder, int upBound)
    {   
        if( index == preorder.length ||preorder[index] > upBound)
        return null;

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bstPreorder(preorder, root.val);
        root.right = bstPreorder(preorder, upBound);

        return root;
    }
    public static void main(String[] args) {
        int[] a = {8, 5, 1, 7, 10, 12};
        TreeNode node = bstFromPreorder(a);
        System.out.println(node.val);
    }
}
