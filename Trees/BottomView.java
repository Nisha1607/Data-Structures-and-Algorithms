
class Pair{
  int level;
  Node node;
  Pair(Node node,int level){
    this.level=level;
    this.node=node;
  }
}

List<Integer> bottomView(TreeNode root){
  ArrayList<Integer> res = new ArrayList<>();
  if(root==null) return res;
  Queue<Pair> que = LinkedList<>();
  que.offer(root,new Pair(root,0));
  Map<Integer,Integer> map = new TreeMap<>();
  while(!que.isEmpty()){
    Pair p = que.poll();
    level = p.level;
    root = p.node;
    map.put(level,root.val);
    if(root.left!=null) que.offer(new Pair(root.left,level-1));
    if(root.right!=null) que.offer(new Pair(root.right,level+1));
  }
  for(Integer vals : map.values()){
    res.add(vals);
  }
  return res;
}
