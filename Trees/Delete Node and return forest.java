/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode dfs(TreeNode node,List<TreeNode> res,Set<Integer> set){
        if(node==null) return null;
        node.left = dfs(node.left,res,set);
        node.right = dfs(node.right,res,set);
        if(set.contains(node.val)){
            if(node.left!=null) res.add(node.left);
            if(node.right!=null) res.add(node.right);
            return null;
        }
        return node;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList();
        Set<Integer> set = new HashSet();
        for(int i:to_delete) set.add(i);
        root = dfs(root,res,set);
        if(root!=null) res.add(root);
        return res;
    }
}
