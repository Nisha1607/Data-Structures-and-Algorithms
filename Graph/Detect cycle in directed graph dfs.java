// visit each node and while visiting each node keep track of 2 arrays, vis and dfsVis, both will be marked as true during the first visit of node
// but as soon as we start backtracking then we we mark thedfsVis node false and while doing so when we found adj node's is true in both the arrays then
// there exists a cycle

boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsVis){
  vis[src]=true;
  dfsVis[src]=true;
  for(Iterator itr : adj.get(src)){
    if(!vis[itr]){
      if(dfs(itr,adj,vis,dfsVis))
        return true;
    }
    else if(vis[itr]&&dfsVis[itr])
      return true;
  }
  dfsVis[src]=false;
  return false;
}
 
 public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[V];
    boolean[] dfsVis = new boolean[V];
     for(int i=0;i<V;i++){
       if(!vis[i])
         dfs(i,adj,vis,dfsVis);
     }
  }
