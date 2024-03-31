boolean rootToLeaf(TreeNode root, List<Integer> res,int x){
  if(root==null)
      return false;
  res.add(root.val);
  if(root.val == x)
    return true;

  if(rootToLeaf(root.left,list,x) ||rootToLeaf(root.left,list,x)) 
      return true;

  res.remove(res.size()-1);
  return false;
}
