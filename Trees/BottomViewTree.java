class TreeNode{
  int val;
  TreeNode root;
  TreeNode(root,val){
    this.val=val;
    this.root=root;
  }
}

class Pair{
  int level;
  TreeNode node;
  Pair(int level,TreeNode node){
    this.level=level;
    this.node=node;
  }
}

public ArrayList <Integer> bottomView(Node root)
    {
         ArrayList<Integer> res = new ArrayList<>();
          if(root==null){
            return res;
          }
          Queue<Pair> que = new LinkedList<>();
          Map<Integer,Integer> map = new TreeMap<>();
          que.add(new Pair(root,0));
          int level=0;
          while(!que.isEmpty()){
            Pair p = que.poll();
            level = p.level;
            root = p.node;
            map.put(level,root.data);
            if(root.left!=null){
              que.add(new Pair(root.left,level-1));
            }
             if(root.right!=null){
              que.add(new Pair(root.right,level+1));
            }
          }
          map.forEach((key,val)->{res.add(val);});
          return res;
    }
