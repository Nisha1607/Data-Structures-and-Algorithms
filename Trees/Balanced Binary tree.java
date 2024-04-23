//optimized TC: (n), SC :O(n)

int height(TreeNode root){
  if(root==null) return 0;
  int left = height(root.left);
  int right = height(root.right);
  if(left==-1 || right == -1) return -1;
  if(abs(left-right)>0) return -1;
  return 1 + Math.max(left,right);
}
