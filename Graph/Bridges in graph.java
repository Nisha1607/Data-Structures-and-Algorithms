class Solution {
    int timer=1;
    void dfs(int src,int par,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int[] low,
                int[] ins,List<List<Integer>> ans){
        vis[src]=true;
        low[src]=ins[src]=timer++;
        for(Integer itr : adj.get(src)){
            if(itr==par) continue;
            if(!vis[itr]){
                dfs(itr,src,adj,vis,low,ins,ans);
                low[src]=Math.min(low[itr],low[src]);
                if(low[itr]>ins[src]){
                    ans.add(Arrays.asList(itr,src));
                }
            }
            else
            low[src]=Math.min(low[itr],low[src]);

        }

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge : connections){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        boolean[] vis = new boolean[n];
        int[] low = new int[n];
        int[] ins = new int[n];
        dfs(0,-1,adj,vis,low,ins,ans);
        return ans;
    }
}
