package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class dfsTraversal {

    int index = -1;
    static class Pair{
        int num;
        Node node;
        Pair(Node node, int num)
        {
            this.node = node;
            this.num = num;
        }
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Record{
        Node node;
        int vertical;
        int level;
        Record(Node node, int row, int col)
        {
            this.node = node;
            this.vertical = row;
            this.level = col;
        } 
    }
    public Node buildTree(int[] nodes)
    {
        index++;
        if(nodes[index] == -1)
            return null;
        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        
        return newNode;
    }
    public static void preOrder(Node root)
    {
        if(root == null)
            return ;
        
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    } 

    public static void inOrder(Node root)
    {
        if(root == null)
            return ;
        
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    
    public static void postOrder(Node root)
    {
        if(root == null)
            return ;
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");

    }

    public static void levelOrder(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> subList = new ArrayList<>();

            for(int i=0; i<size; i++)
            {
                if(q.peek().left!=null)
                    q.add(q.peek().left);
                if(q.peek().right!=null)
                        q.add(q.peek().right); 

                subList.add(q.poll().data);
            }  
            list.add(subList);      
        }
        System.out.println(list);
    }
    public static void zigZagOrder(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        q.add(root);
        int flag = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            
            for(int i=0; i<size; i++)
            {
                if(q.peek().left!=null)
                    q.add(q.peek().left);
                if(q.peek().right!=null)
                        q.add(q.peek().right); 

                subList.add(q.poll().data);
            }  
            if(flag==1)
            {
                list.add(subList);
                flag=0;
            }
            else
            { 
                Collections.reverse(subList);   
                list.add(subList);
                flag=1;
            }    
    
        }
        System.out.println(list);
    }
    public static void preInPost(Node root)
    {
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();

        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root, 1));

        while(!st.isEmpty())
        {
            Pair it = st.pop();

            if(it.num==1)
            {
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left != null)
                    st.push(new Pair(it.node.left, 1));
            }
            else if(it.num == 2)
            {
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right!= null)
                    st.push(new Pair(it.node.right, 1));
            }
            else if(it.num==3)
                post.add(it.node.data);
        }
        System.out.println("PreOrder--> "+pre);
        System.out.println("PostOrder--> "+post);
        System.out.println("InOrder--> "+in);

    }
    public static int maxDepth(Node root)
    {
        if(root==null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);

    }
    public static int checkBalancedTree(Node root)
    {
        if(root==null)
        return 0;
    
        int left = checkBalancedTree(root.left);
        int right = checkBalancedTree(root.right);

        if(left == -1 || right == -1)
            return -1;
        if(Math.abs(left-right)<=1)
            return 1 + Math.max(left, right);
        return -1;   
    }
    static int maxi = 0;
    public static int diameterTree(Node root)
    {
        if(root == null)
            return 0;
        
        int left = diameterTree(root.left);
        int right = diameterTree(root.right);
        maxi = Math.max(maxi, left + right);
        return 1 + Math.max(left, right);
    }
    public static int diameter(Node root)
    {
        diameterTree(root);
        return maxi;
    }
    public static List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        String path = "";
        helper(root, ans, path);
        return ans;
    }
    public static void helper(Node root, List<String> ans, String path){
        if(root == null)    return;

        if(root.left == null && root.right == null){
            path = path + root.data;
            ans.add(path);
            return;
        }
        else
            path = path + root.data + "->";
        
        helper(root.left, ans, path);
        helper(root.right, ans, path);
    }
    static int maxi2 = Integer.MIN_VALUE;
    public static int maxPathSum(Node root)
    {
        if(root == null)
        return 0;
    int left = Math.max(maxPathSum(root.left), 0);
    int right = Math.max(maxPathSum(root.right), 0);
    
    maxi2 = Math.max(maxi2, root.data + left + right);
    return root.data + Math.max(left, right); 
    }
    public static int maxPathSum2(Node root)
    {
        maxPathSum(root);
        return maxi2;
    }
    public static boolean hasPathSum(Node root, int targetSum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && targetSum == root.data)
            return true;
        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);    
    }
    public static boolean isLeaf(Node root)
    {
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
    public static void leftBoundary(Node root, ArrayList<Integer> list)
    {
        Node curr = root;
        while(curr != null)
        {
            if(isLeaf(curr)==false)
                list.add(curr.data);
            if(curr.left != null)
                curr = curr.left;
            else
                curr =  curr.right;    
        }
    }
    public static void addLeaves(Node root, ArrayList<Integer> list)
    {
        if(isLeaf(root))
        {
            list.add(root.data);
            return ;
        }
        if(root.left != null)
            addLeaves(root.left, list);
        if(root.right != null)
            addLeaves(root.right, list);
    }
    public static void rightBoundary(Node root, ArrayList<Integer> list)
    {
        Node curr = root;
        Stack<Integer> st = new Stack<>();
        while(curr != null)
        {
            if(isLeaf(curr)==false)
                st.push(curr.data);
            if(curr.right!=null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        while(!st.isEmpty())
            list.add(st.pop());
    }
    public static ArrayList<Integer> printBoundary(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        if(isLeaf(root) == true)
        {
            list.add(root.data);
            return list;
        }
        list.add(root.data);
        leftBoundary(root.left, list);
        addLeaves(root, list);
        rightBoundary(root.right, list);
        return list;
    }
     public static List<List<Integer>> verticalTraversal(Node root) 
     {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Record> q = new LinkedList<>();
        q.add(new Record(root, 0, 0));

        while(!q.isEmpty())
        {
            Record pair = q.poll();
            Node node = pair.node;
            int x = pair.vertical;
            int y = pair.level;

            if(!map.containsKey(x))
                // map.put(x, new TreeMap<>());
            if(!map.get(x).containsKey(y))
                // map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).add(node.data);

            if(node.left != null)
                q.add(new Record(node.left, x-1, y+1));
            if(node.right != null)
                q.add(new Record(node.right, x+1, y+1));                    
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> sp : map.values())
        {
            // list.add(new ArrayList<>());
            for(PriorityQueue<Integer> values : sp.values())
            {
                while(!values.isEmpty())
                    list.get(list.size()-1).add(values.poll());
            }
        }
        return list;
    }
    public static List<Integer> topView(Node root)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();   
        q.add(new Pair(root, 0));

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            Node node = p.node;
            int x = p.num;

            if(!map.containsKey(x))
                map.put(x, node.data);

            if(node.left!=null)
                q.add(new Pair(node.left, x-1));
            
            if(node.right!=null)
                q.add(new Pair(node.right, x+1));
                  
        }
        List<Integer> list = new ArrayList<>();
        for(int val : map.values())
            list.add(val); 
        return list;        
    }
    public static List<Integer> bottomView(Node root)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();   
        q.add(new Pair(root, 0));

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            Node node = p.node;
            int x = p.num;

            if(!map.containsKey(x))
                map.put(x, node.data);
            else
                map.put(x, node.data);    

            if(node.left!=null)
                q.add(new Pair(node.left, x-1));
            
            if(node.right!=null)
                q.add(new Pair(node.right, x+1));
                  
        }
        List<Integer> list = new ArrayList<>();
        for(int val : map.values())
            list.add(val); 
        return list;    
    }   
     public static List<Integer> rightSideView(Node root)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();   
        q.add(new Pair(root, 0));

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            Node node = p.node;
            int x = p.num;

            if(!map.containsKey(x))
                map.put(x, node.data);
            else
                map.put(x, node.data);    

            if(node.left!=null)
                q.add(new Pair(node.left, x+1));
            
            if(node.right!=null)
                q.add(new Pair(node.right, x+1));
                  
        }
        List<Integer> list = new ArrayList<>();
        for(int val : map.values())
            list.add(val); 
        return list;    
    } 
    public static Node lowCommonAncestor(Node root, Node p, Node q)
    {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;

        Node left = lowCommonAncestor(root.left, p, q);
        Node right = lowCommonAncestor(root.right, p, q);

        if(left == p && right == q || left == q && right == p)
            return root;
        else if(left == null && right == null)
            return null;
        else if(left == null)
            return right;
        else
            return left;  
    }
    public static int maxWidth(Node root)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int ans = 0;
        while(!q.isEmpty())
        {
            int size = q.size();

            int first = 0, last = 0;
            for(int i=0; i<size; i++)
            {
                Pair p = q.poll();
                Node node = p.node;
                int x = p.num;
                
                int curIndex = 0;
                if(x!=0)
                    curIndex = x-1;

                if(i==0)
                    first = curIndex;
                if(i==size-1)
                    last = curIndex;

                if(node.left!=null)
                    q.add(new Pair(node.left, (2*curIndex)+1));
                if(node.right!=null)
                    q.add(new Pair(node.right, (2*curIndex)+2));    
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
    public static void childSumProperty(Node root)
    {
        if(root == null)
            return;
        int child = 0;
        if(root.left!=null)
            child += root.left.data;
        if(root.right!=null)
            child += root.right.data;
        
        if(child >= root.data)
            root.data = child;
        else
            if(root.left!=null)
                root.left.data = root.data;
            if(root.right!=null)
                root.right.data = root.data;
        
        childSumProperty(root.left);
        childSumProperty(root.right);

        int tot = 0;
        if(root.left != null)
            tot += root.left.data;
        if(root.right != null)
            tot += root.right.data;
        if(root.left!=null || root.right!=null)    
            root.data = tot;
    }
    
    public static Node makeParents(Node root, HashMap<Node, Node> map, Node target)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(target.data == node.data)
                target = node;
            if(node.left!=null)
            {
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right!=null)
            {
                map.put(node.right, node);
                q.add(node.right);
            }
        }
        return target;
    }
    public static List<Integer> distanceK(Node root, Node target, int k) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        Node target2 = makeParents(root, parentMap, target);
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Boolean> visitedMap = new HashMap<>();
        q.add(target2);
        visitedMap.put(target2, true);

        int currLevel = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            if(currLevel == k)
                break;
            else
                currLevel++;
            
            for(int i=0; i<size; i++)
            {
                Node node = q.poll();
                if(node.left!=null && visitedMap.get(node.left)==null)
                {
                    q.add(node.left);
                    visitedMap.put(node.left, true);
                }
                 if(node.right!=null && visitedMap.get(node.right)==null)
                {
                    q.add(node.right);
                    visitedMap.put(node.right, true);
                }
                 if(parentMap.get(node)!=null && visitedMap.get(parentMap.get(node))==null)
                {
                    q.add(parentMap.get(node));
                    visitedMap.put(parentMap.get(node), true);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty())
        {
            Node node = q.poll();
            list.add(node.data);
        }
        return list;
    }
    //Approach 1: BURN-TREE-USING BFS TRAVERSAL
    
    /*START*/
    public static Node makeParents2(Node root, HashMap<Node, Node> map, int start)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node res = new Node(-1);
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.data == start)
                res = node;
            if(node.left!=null)
            {
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right!=null)
            {
                map.put(node.right, node);
                q.add(node.right);
            }
        }
        return res;
    }
    public static int burnTree(Node root, int start)
    {
        HashMap<Node, Node> parentMap = new HashMap<>();
        Node target = makeParents2(root, parentMap, start);
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Boolean> visitedMap = new HashMap<>();
        q.add(target);
        visitedMap.put(target, true);

        int currLevel = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            currLevel++;
            
            for(int i=0; i<size; i++)
            {
                Node node = q.poll();
                if(node.left!=null && visitedMap.get(node.left)==null)
                {
                    q.add(node.left);
                    visitedMap.put(node.left, true);
                }
                 if(node.right!=null && visitedMap.get(node.right)==null)
                {
                    q.add(node.right);
                    visitedMap.put(node.right, true);
                }
                 if(parentMap.get(node)!=null && visitedMap.get(parentMap.get(node))==null)
                {
                    q.add(parentMap.get(node));
                    visitedMap.put(parentMap.get(node), true);
                }
            }
        }
        return currLevel-1;
    }
    /*END Approach 1: */

    //APPROACH 2: BURN-TREE-USING DFS TRAVERSAL

    /*START*/
    public static Node makeParents3(Node root, HashMap<Node, Node> map, int start)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node res = new Node(-1);
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.data == start)
                res = node;
            if(node.left!=null)
            {
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right!=null)
            {
                map.put(node.right, node);
                q.add(node.right);
            }
        }
        return res;
    }
    public static int helper(Node root, int start)
    {
        HashMap<Node, Node> parentMap = new HashMap<>();
        HashMap<Node, Boolean> visitedMap = new HashMap<>();
        Node target = makeParents3(root, parentMap, start);
        int ans = heightTreeTarget(target, parentMap, visitedMap);
        return ans - 1;
    }
    public static int heightTreeTarget(Node root, HashMap<Node, Node> parentMap, HashMap<Node, Boolean> visitedMap)
    {
        if(root == null)
            return 0;
        
        visitedMap.put(root, true);

        int left = 0, right = 0, parent = 0;
        if(root.left!=null && visitedMap.get(root.left)==null)
            left = heightTreeTarget(root.left, parentMap, visitedMap);

        if(root.right!=null && visitedMap.get(root.right)==null)
            right = heightTreeTarget(root.right, parentMap, visitedMap);

        if(parentMap.get(root)!=null && visitedMap.get(parentMap.get(root))==null)
            parent = heightTreeTarget(parentMap.get(root), parentMap, visitedMap);  

        return Math.max(left, Math.max(right, parent)) + 1;

    }
    /*END*/

    public static int countNodes(Node root)
    {
        if(root == null)
            return 0;
        int left = leftHeightCompleteTree(root);
        int right = rightHeightCompleteTree(root);

        if(left == right)
            return ((2<<(left))-1);
          
        return 1 + countNodes(root.left) + countNodes(root.right);    
    }
    public static int leftHeightCompleteTree(Node root)
    {
        int count = 0;
        while(root!=null)
        {
            count++;
            root = root.left;
        }
        return count;
    }
    public static int rightHeightCompleteTree(Node root)
    {
        int count = 0;
        while(root!=null)
        {
            count++;
            root = root.right;
        }
        return count;
    }
    public static void morrisTraversalInorder(Node root)
    {
        Node curr = root;
        while(curr!=null)
        {
            if(curr.left == null)
            {
                System.out.print(curr.data+" -> ");
                curr = curr.right;
            }
            else
            {
                Node prev = curr.left;
                while(prev.right!=null && prev.right != curr)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = curr;
                    curr = curr.left;   
                }
                if(prev.right == curr)
                {
                    prev.right = null;
                    System.out.print(curr.data+" -> ");
                    curr = curr.right;
                }
            }
        }
        
    }
    public static void morrisTraversalPreorder(Node root)
    {
        Node curr = root;
        while(curr!=null)
        {
            if(curr.left == null)
            {
                System.out.print(curr.data+" -> ");
                curr = curr.right;
            }
            else
            {
                Node prev = curr.left;
                while(prev.right!=null && prev.right != curr)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = curr;
                    System.out.print(curr.data+" -> ");
                    curr = curr.left;   
                }
                if(prev.right == curr)
                {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        
    }
    //flatten Binary Tree into LinkedList
    public static void flatten(Node root) {
        Node curr = root;
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                Node prev = curr.left;
                while(prev.right!=null)
                    prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    //LARGE BST IN BINARY TREE
    // class NodeValue{
    //     public int maxNode, minNode, maxSize;
    //     NodeValue(int maxNode, int minNode, int maxSize){
    //         this.maxNode = maxNode;
    //         this.minNode = minNode;
    //         this.maxSize = maxSize;
    //     }
    // }
    
    // class Solution{
        
    //     static NodeValue largeBST(Node root)
    //     {
    //         if(root == null)
    //             return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            
    //         NodeValue left = largeBST(root.left);
    //         NodeValue right = largeBST(root.right);
            
    //         if(left.maxNode < root.data && root.data < right.minNode)
    //         {
    //             return new NodeValue(Math.max(root.data, right.maxNode), 
    //                                 Math.min(root.data, left.minNode),
    //                                 left.maxSize + right.maxSize + 1);
    //         }
            
    //         return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
    //     }
    //     // Return the size of the largest sub-tree which is also a BST
    //     static int largestBst(Node root)
    //     {
    //         return largeBST(root).maxSize;
    //     }
        
    // }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, -1, -1, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1};

        dfsTraversal bt = new dfsTraversal();
        Node root = bt.buildTree(nodes);

        System.out.println("Pre-Order Traversal:");
        preOrder(root);

        System.out.println("\nIn-Order Traversal:");
        inOrder(root);

        System.out.println("\nPost-Order Traversal:");
        postOrder(root);

        System.out.println("\nLevel-Order Traversal:");
        levelOrder(root);

        System.out.println("\n ZigZag-Order Traversal:");
        zigZagOrder(root);

        System.out.println("\nAll Traversal in One Program:");
        preInPost(root);

        System.out.println("Max Depth = " +maxDepth(root));

        System.out.println(checkBalancedTree(root)!=-1);

        System.out.println("Diameter = "+diameter(root));

        System.out.println("Root-to-Node Path: "+binaryTreePaths(root));

        System.out.println("maxPathSum = "+maxPathSum2(root));

        System.out.println(hasPathSum(root, 13));

        System.out.println("Boundary Traversal: "+printBoundary(root));
        
        System.out.println("Top-View: "+topView(root));

        System.out.println("Bottom-View: "+bottomView(root));

        System.out.println("Right-View: "+rightSideView(root));

        System.out.println("Max-Width: "+maxWidth(root));

        Node target = new Node(5);
        System.out.println("Print Nodes Distance K: "+distanceK(root, target, 1));

        System.out.println("Burn-Tree: "+burnTree(root, 5));

        System.out.println("Burn-Tree2: "+helper(root, 5));

        System.out.println("Count-Nodes: "+countNodes(root));

        System.out.print("Morris Inorder Traversal: ");
        morrisTraversalInorder(root);

        System.out.println();
        System.out.print("Morris Preorder Traversal: ");
        morrisTraversalPreorder(root);
    }
}
