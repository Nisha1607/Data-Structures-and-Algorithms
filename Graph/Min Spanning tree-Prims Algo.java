//greedily calculates the cost of min spanning tree
// use PQ to store min dist node, start with Pair 0,0
// Iterrate through PA , and store the adjNode if not already visited in PQ
// if the ndoe is already visited continue

class Pair{
    int node;
    int cost;
    Pair(int n, int c){
        this.node =n;
        this.cost = c;
    }
}

static int spanningTree(int V, int E, int edges[][]){
  ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

  for(int i=0;i<V;i++){
    adj.get(new ArrayList<>());
  }

  for(int[] edge : edges){
    int u = edge[0];
    int v= edge[1];
    int wt =edge[2];
    adj.get(u).get(v).add(wt);
    adj.get(v).get(u).add(wt);
  }

  boolean vis[] = new boolean[V];
  PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.cost-y.cost);

  pq.add(new Pair(0,0));

  while(!q.isEmpty()){
    Pair p = q.poll();
    int node = p.node;
    int cost = p.cost;
    if(vis[node]) continue;
    vis[node]=true;
    minCost += cost;
    for(Pair adj : adj.get(node)){
      int adjNode = adj.node;
      int adjCost = adj.cost;
      if(!vis[adjNode]) 
          pq.add(new Pair(adjNode,adjCost));
    }
  }
  return minCost;
}
    
    
    
