boolean bfs(int src, int[][] graph, int[] color){
  Queue<Integer> q = new LinkedList<>();
  q.add(src);
  color[src]=0;
  while(!q.isEmpty()){
    int node = q.poll();
    for(int adjNode : graph[node]){
      if(color[adjNode]==-1){
        color[adjNode] = 1 - color[node];
        q.add(adjNode);
      }else if(color[adjNode]==color[node])
        return false;
    }
  }
  return true;
}

 public boolean isBipartite(int[][] graph) {
   int n = graph.length;
   int[] color = new int[n];
   Arrays.fill(color,-1);

   for(int i=0;i<n;i++){
     if(color[i]!=-1){
       if(!bfs(i,graph,color))
           return false;
     }
   }
   return true;
 }
