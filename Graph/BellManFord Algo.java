// Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertices from the source vertex S.
//works for only directed graphs, and used to detect negative cycle as well
//1.initialize dist array to inifinity for all vertex
// relax all the nodes V-1 times, like if(dist[v] > dist[u] + wt) then dist[v]=dist[u]+wt;
// if after V-1 iterations also dist array is chamging them there is negative cycle youu can check for that as well

static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

  int[] dist = new int[V];
  Arrays.fill(dist,(int)(1e9);

  dist[S] = 0;
  for(int i=0;i<V-1;i++){
    int u = edge[i][0];
    int v = edge[i][1];
    int wt = edge[i][2];
    if(dist[u]!=(int)(1e9) && dist[v]> dist[u]+wt)
      dist[v]=dist[u]+wt;
  }

   for(int i=0;i<V-1;i++){
    int u = edge[i][0];
    int v = edge[i][1];
    int wt = edge[i][2];
    if(dist[u]!=(int)(1e9) && dist[v]= dist[u]+wt)
      return -1;
  }
  return dist;
}
  
  
