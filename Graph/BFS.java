ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj){
  List<Integer> res = new ArrayList<>();
  Queue<Integer> q = new LinkedList<>();
  boolean[] vis = new boolean[V];
  q.add(0);
  vis[0]=true;
  while(!q.isEmpty()){
    Integer node =q.poll();
    res.add(node);
    for(Integer itr : adj.get(node)){
      if(!vis[itr]){
        vis[itr]=true;
        q.push(itr);
      }
    }
  }
  return ers;
}
