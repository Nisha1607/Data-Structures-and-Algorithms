
// recursion
void postorder(TreeNode root){
  if(root==null)
    return;
  postorder(root.left);
  postorder(root.right);
  res.add(root.val);
}
