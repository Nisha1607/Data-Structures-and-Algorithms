//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class DisjointSet{
  List<Integer> parent = new ArrayList<>();
  List<Integer> rank = new ArrayList<>();
  List<Integer> size = new ArrayList<>();

  public DisjointSet(int n){
      for(int i=0;i<=n;i++){
          parent.add(i);
          rank.add(0);
          size.add(1);
      }
  }

  public int findUPar(int node){
    if(node == parent.get(node))
        return node;
    parent.set(node,findUPar(parent.get(node)));
    return parent.get(node);
  }

  public void unionByRank(int u,int v){
    int up_u = findUPar(u);
    int up_v = findUPar(v);
    if(rank.get(up_u) < rank.get(up_v))
      parent.set(up_u,up_v);
    else if(rank.get(up_v) < rank.get(up_u))
      parent.set(up_v, up_u);
    else{
      parent.set(up_u,up_v);
      rank.set(up_v,rank.get(up_v)+1);
    }
  }

   public void unionBySize(int u,int v){
    int up_u = findUPar(u);
    int up_v = findUPar(v);
    if(size.get(up_u) < rank.get(up_v)){
      parent.set(up_u,up_v);
      size.set(up_v,size.get(up_v)+size.get(up_u));
    }
    else{
      parent.set(up_v,up_u);
      rank.set(up_u,size.get(up_v)+size.get(up_u));
    }
  }
};


class Solution {
     static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int wt;
        Edge(int _u, int _v, int _wt){
            this.u = _u;
            this.v = _v;
            this.wt = _wt;
        }
        
        @Override
        public int compareTo(Edge b){
            return this.wt - b.wt;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        //ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<V;i++){
            for(int[] itr : adj.get(i)){
                int adjNode = itr[0];
                int cost = itr[1];
                edges.add(new Edge(i,adjNode,cost));
            }
        }
        
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        int minCost=0;
        for(Edge e : edges){
            int u = e.u;
            int v = e.v;
            int cost = e.wt;
            if(ds.findUPar(u)!=ds.findUPar(v)){
                minCost+=cost;
                ds.unionBySize(u,v);
            }
        }
        
        return minCost;
    }
}
