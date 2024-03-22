//recursion

void preorder(TreeNode root){
  if(root==null)
    return;
  res.add(root.val);
  preorder(root.left);
  preorder(root.right);
}

//using stack

List<Integer> preorder(TreeNode root){
  ArrayList<Integer> res = new ArrayList<>();
  Stack<TreeNode> stk = new Stack<>();
  stk.add(root);
  while(!stk.isEmpty()){
    root = stk.peek();
    stk.remove();
    res.add(root.val);
    if(root.right!=null){
      stk.add(root.right);
    if(root.left!=null){
      stk.add(root.left);
  }
  return res;
}
