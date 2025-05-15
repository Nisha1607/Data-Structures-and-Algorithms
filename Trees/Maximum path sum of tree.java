
int maxPathSum(TreeNode root,int sum){
  if(root==null) return 0;
  int left = maxPathSum(root.left);
  int right = maxPathSum(root.right);
  sum = Math.max(sum, root.val + left + right);
  return root.val + Math.max(left,right);
}
