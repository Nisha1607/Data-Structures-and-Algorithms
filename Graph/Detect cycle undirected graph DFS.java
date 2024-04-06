// we have to just keep tract of parent 
//during dfs visit of node if it is already visited and it is not a parent then there exist a cycle, that's it!!!

boolean dfs(int src, ArrayList<ArrayList<Integer>> adj,int par){
  vis[src]=true;

  for(Iterator itr: adj.get(src)){
    if(!vis[itr]){
      if(dfs(itr,adj,src))
        return true;
    }    
    else(itr!=par)
      return true;
  }
  return false;
}
  

public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[V];
    int par = -1;
    for(int i=0;i<V;i++){
      if(!vis[i]){
         if(dfs(i,adj,par))
           return true;
      }
    }
  return false;
}
  
