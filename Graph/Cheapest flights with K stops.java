class Solution {
  class Pair{
    int node;
    int cost;
    Pair(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
  }

class Tuple{
    int stops;
    int node;
    int cost;
    Tuple(int stops,int node,int cost){
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
  }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();

        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int) 1e9;
        }

        dist[src]=0;
        // stops, node, cost
        q.add(new Tuple(0,src,0));

        while(!q.isEmpty()){
            Tuple it = q.poll();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;
            if(stops>k) break;
            for(Pair iter : adj.get(node)){
                int adjNode = iter.node;
                int adjCost= iter.cost;
                if(dist[adjNode] > adjCost + cost  && stops <= k ){
                    dist[adjNode] = adjCost+cost;
                    q.add(new Tuple(stops+1,adjNode,dist[adjNode]));
                }
            }
        }

        if(dist[dst]==(int)1e9) return -1;
        else return dist[dst];
    }
}
