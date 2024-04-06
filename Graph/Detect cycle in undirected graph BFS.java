//same as dfs, like we check if the node is already visited but it is not parent of cuu node then cycle exists, pass initial par to be -1
class Pair{
  int node;
  int par;

  Pair(int node,int par){
    this.node=node;
    this.par=par
    }
}

 public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
   boolean[] vis = new boolean[V];
   Queue<Pair> q = new LinkedList<>();
   q.add(new Pair(0,-1));
   vis[0]=true;
   while(!q.isEmpty()){
        Pair p = q.peek();
        int src = p.node;
        int par = p.par;
        q.poll();
     for(Integer itr : adj.get(src)){
       if(!vis[itr]){
          vis[itr] = true;
          q.add(new Pair(itr,src));
       }
       else if(itr!=par){
         return true;
       }
     }
   }
   return false;
 }
