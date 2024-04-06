//we have to reverse the edgees between 2 SCC so that SCC1 is not reachable from SCC2
// topo sort the graph
//store the result in stk
// 1. apply dfs store res in stk
// 2. reverse the graph by transposing the matrix
// 3. apply rev_dfs from elements in stk

void dfs(int src, ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> stk){
  vis[src] = true;
  for(Integer it : adj.get(src)){
    if(!vis[it])
      dfs(it,adj,vis);
  }
  stk.push(src);
}

void revdfs(int src, ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[src]=true;
        for(Integer it : adj.get(src)){
            if(!vis[it]){
                revdfs(it,adj,vis);
            }
        }
    }

 public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
  {
        boolean[] vis = new boolean[V];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<V;i++){
          if(!vis[i])
              dfs(i,adj,vis,stk);
        }

         ArrayList<ArrayList<Integer>> trans = new ArrayList<>();

       for(int i=0;i<V;i++)
         trans.add(new ArrayList<>());

       for(int i=0;i<V;i++)
       {
           vis[i] = false;
           for(Integer itr : adj.get(i)){
             trans.get(itr).add(i);
           }
       }

   int cnt=0;

       while(!stk.isEmpty()){
         int node = stk.pop();
         if(!vis[node]){
              cnt++;
             revdfs(node,trans,vis);
         }
       }

   return cnt;
 }


    
