
int maxPathSum(TreeNode root,int sum){
  if(root==null) return 0;
  int left = maxPathSum(root.left);
  int right = maxPathSum(root.right);
  sum = Math.max(sum, root.val + left + val + root.val);
  return root.val + Math.max(left,right);
}
