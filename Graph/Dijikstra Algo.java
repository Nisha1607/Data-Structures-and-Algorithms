//does not work for negative edges , return a list of integers denoting shortest distance between each node and Source vertex S.
// 1. create dist array for each node initialized
// 2. Use priority queue to store min (dist,node) pair
// 3. go to each node and check if dist + adjWight < dist[adjNode] then do dist[adjNode] = dist + adjWeight and
// 4. add new pair of dist,node to pq , which would be dist[adjNode],adjNode
// 5. return dist array

class Pair{
  int dist;
  int node;
  Pair(dist,node){
    this.dist=dist;
    this.node=node;
  }
}

 static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
   int[] dist = new int[V];
   Arrays.fill(dist,(int)(1e9));
   dist[S] = 0;
   
   PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
   pq.add(new Pair(0,S));

   while(!pq.isEmpty()){
     Pair p = pq.poll();
     int dist = p.dist;
     int node = p.node;

     for(int i=0;i<adj.get(node);i++){
       int adjNode = adj.get(node).get(i).get(0);
        int adjWeight = adj.get(node).get(i).get(1);
       if(dist+edgeWeight<dist[adjNode])
       {
         dist[adjNode] = dist+edgeWeight;
         pq.add(new Pair(dist[adjNode],adjNode);
       }
     }
   }
   return dist;
 }

   
