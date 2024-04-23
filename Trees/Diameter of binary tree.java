
int height(TreeNode root){
  if(root==null) return 0;
  int left = height(root.left);
  int right = height(root.right);
  diameter = Math.max(diameter,left+right);
  return 1+Math.max(left,right);
}
