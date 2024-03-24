void dfs(int node,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res){
  vis[node]=true;
  res.add(node);

  for(Integer itr : adj.get(node)){
    if(!vis[itr])
      dfs(itr,adj,res);
  }
  
}

ArrayList<Integer> DFSTraversal(int V, ArrayList<ArrayList<Integer>> adj){
  boolean[] vis = new boolean[V];
  ArrayList<Integer> res = new ArrayList<>();
  for(int i=0;i<V;i++){
    if(!vis[i]){
      dfs(i,adj,res);
    }
  }
  return res;
}
