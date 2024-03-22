//Recursion Solution

class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(){}
  TreeNode(int val,TreeNode left,TreeNode right){
    this.val=val;
    this.left=left;
    this.right=right;
  }
}
List<Integer> res= new ArrayList<>();
void inorder(TreeNode root){
  if(root==null)
    return;
  inorder(root.left);
  res.add(root.val);
  inorder(root.right);
}

//Using stack

List<Integer> inorder(TreeNode root){
  if(root==null)
      return res;
  Stack<TreeNode> stk = new Stack<>();
  TreeNode curr=root;
  while(!stk.isEmpty()||curr!=null){
    if(curr!=null){
      stk.add(curr);
      curr=curr.left;
    }
    else{
      curr = stk.peek();
      res.add(curr.val);
      stk.pop();
      curr=curr.right;
    }
}
return res;
}
