//recursion

public int maxDepth(TreeNode root) {
  if(root==null) return 0;
  int left = 1+ maxDepth(root.left);
  int right = 1+ maxDepth(root.right);
  return Math.max(left,right);
}


//level order
 public int maxDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null) return 0;
        que.add(root);
        int depth = 0;
        while(!que.isEmpty()){
            int n = que.size();
            for(int i=1;i<=n;i++){
                root = que.poll();
                if(root.left!=null)
                    que.add(root.left);
                if(root.right!=null)
                    que.add(root.right);
            }
            depth++;
        }
        return depth;
    }
