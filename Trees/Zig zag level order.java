

void ZigZagTraversal(TreeNode root){
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    List<List<Integer>> res = new ArrayList<>();
    boolean leftToRight = false;
    q.add(root);
    while(!q.isEmpty()){
        List<Integer> subRes = new ArrayList<>();
        int qSize = q.size();
        for(int i=1;i<=qSize;i++){
            TreeNode curr = q.poll();
            subRes.add(curr.val);
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
        if(leftToRight)
            Collections.reverse(subRes);
        res.add(subRes);
        leftToRight != leftToRight;
  }
  return res;
}
