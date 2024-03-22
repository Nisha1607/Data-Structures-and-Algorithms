

List<List<Integer>> levelOrder(TreeNode res){
  List<List<Integer>> res = new ArrayList<>();
  
  if(root==null) return res;
  Queue<TreeNode> que = new LinkedList<>();
  que.push(root);
  while(!que.isEmpty()){
    int n = que.size();
    List<Integer> level = new ArrayList<>();
    for(int i=1;i<=n;i++){
      root = que.peek();
      que.poll();
      level.add(root.val);
      if(root.left!=null)
          que.add(root.left);
      if(root.right!=null)
          que.add(root.right);
    }
    res.add(level);
  }
  return res;
}
