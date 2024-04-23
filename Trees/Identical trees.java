boolean isIdentical(TreeNode p,TreeNode q){
  if(p==null && q== null) return true;
  if(p==null || q== null) return false;
  if(p.val!=q.val) return false;
  return isIdentical(p.left,q.left) && isIdenical(p.right,q.right);
}
