 void dfs(int src,boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        for(Integer itr : adj.get(src)){
            if(!vis[itr])
                dfs(itr,vis,adj);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1)
                     adj.get(i).add(j);
            }
        }

        boolean[] vis = new boolean[n];

        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                cnt++;
            }
        }
        return cnt;
    }
