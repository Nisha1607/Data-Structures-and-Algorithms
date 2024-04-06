// we calculate the indegrees of node in  graph store that in a array
// Take a queue for bfs traversal , add the nodes with indegrees 0
//traverse the and for the reduce the indegree of adjacent node and again add the nodes with indegree 0
// finally the result should contain all nodes, if all nodes not included there is a cycle

 public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
   int[] indegree = new int[V];
   for(int i=0;i<V;i++){
     for(Interator itr : adj.get(i)){
       indegree[itr]++;
     }
   }
   Queue<Integer> q = new LinkedList<>();
   for(int i=0;i<V;i++){
     if(indegree[i]==0)
       q.add(i);
   }
  int cnt=0;
  while(!q.isEmpty()){
    cnt++;
    Integer node = q.poll();
    for(Integer itr : adj.get(node)){
      indegree[itr]--;
      if(indegree[itr]==0)
          q.add(itr);
    }
  }
   if(cnt!=V) return true;
   return false;
 }
  
