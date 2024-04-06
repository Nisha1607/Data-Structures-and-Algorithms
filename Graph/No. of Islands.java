void dfs(int src, ArrayList<ArrayList<Integer>> adj,boolean[] vis){
  vis[src] = true;
  for(Iterator itr : adj.get(src)){
    if(!vis[itr])
      dfs(itr,adj);
  }
}

int noOfislands(int[][] graphs){
  ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
  int n=graph.length;
  for(int i=0;i<n;i++){
      adj.add(new ArrayList<>());
      for(int j=0;j<n;j++){
        if(graphs[i]==1)
            adj.get(i).add(j);
      }
  }
  boolean[] vis = new boolean[n];
  int cnt=0;
  for(int i=0;i<n;i++)
  {
      if(vis[i]!=false){
        dfs(i,adj,vis);
        cnt++;
      }
  }
  return cnt;
}
  
