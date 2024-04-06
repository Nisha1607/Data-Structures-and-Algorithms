//Logic is u should come before v when u->v
// apply dfs and while backtracking keep the nodes in stack and print the stack
//intution is we go the depth in dfs so that would be the end node so if store that in stock it wil popped out at the last 

void dfs(int src, ArrayList<ArrayList<Integer>> adj,boolean[] vis){
  vis[src]=true;
  for(Integer itr : adj.get(src)){
    if(!vis[itr])
      dfs(itr,adj,vis);
  }
  stk.push(src);
}

 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
   boolean[] vis = new int[V];
   Stack<Integer> stk = new Stack<>();
   for(int i=0;i<V;i++){
     if(!vis[i]){
       dfs(i,adj,stk);
   }
     int[] res = new res[V];
     int i=0;
     while(!stk.isEmpty()){
       res[i++]=stk.pop();
     }
     return res;
}
       
