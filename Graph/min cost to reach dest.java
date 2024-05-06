https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/description/


class Solution {
   class Edge{
    int node;
    int cost;
    int time;
    Edge(int node,int time,int cost){
        this.node=node;
        this.time=time;
        this.cost=cost;
    }
   }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        ArrayList<Edge>[] adj = new ArrayList[n+1];
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];
            adj[u].add(new Edge(v,t,passingFees[v]));
            adj[v].add(new Edge(u,t,passingFees[u]));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->(a.cost-b.cost));

        pq.add(new Edge(0,0,passingFees[0]));

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            Edge current = pq.poll();
            int node = current.node;
            int time = current.time;
            int cost = current.cost;

            if(time > maxTime || time >= dist[node])
                continue;

            if(node == n-1)
                return cost;

            dist[node]=time;
            for(Edge itr : adj[node]){
                int adjNode = itr.node;
                int adjCost = itr.cost + cost;
                int adjTime = itr.time + time;

                if(adjTime<=maxTime)
                    pq.add(new Edge(adjNode,adjTime,adjCost));
            }

        }
        return -1;

    }
}
