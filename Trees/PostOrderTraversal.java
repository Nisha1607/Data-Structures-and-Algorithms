Class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val,TreeNode left, TreeNode right){
    this.val=val;
    this.left=left;
    this.right=right;
  }
};
  
// recursion
void postorder(TreeNode root){
  if(root==null)
    return;
  postorder(root.left);
  postorder(root.right);
  res.add(root.val);
}


//Using stack
 public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        Stack<TreeNode> stk= new Stack<>();
        if(root==null)
            return res;
        stk.add(root);
        while(!stk.isEmpty()){
            root=stk.peek();
            stk.pop();
            res.add(root.val);
             if(root.left!=null)
                stk.push(root.left);
             if(root.right!=null)
                stk.push(root.right);
            
        }
        Collections.reverse(res);
        return res;
    }
