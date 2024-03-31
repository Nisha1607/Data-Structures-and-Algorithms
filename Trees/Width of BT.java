class Pair{
  int id;
  TreeNode node;
  Pair(int id,TreeNode node){
    this.id=id;
    this.node=node;
  }
};

int width(TreeNode root){
    Queue<Pair> q = new LinkedList<>();
    q.add(root,0);
    while(!q.isEmpty()){
      int minId = q.peek().id;
      int n = q.size();
       int first = 0,last=0;
      for(int i=1;i<=n;i++){
         TreeNode curr = q.peek().node;
         int currId = q.peek().id-minId;
         if(i==1) first = currId;
          if(i==n) last = currId;
          if(curr.left!=null)
              q.add(new Pair<>(root.left,2*i+1));
        if(curr.right!=null)
              q.add(new Pair<>(root.right,2*i+2));
      }
      res=Math.max(res,last-first+1);
    }
}
                
