//TC : O(N*N)
//SC : O(N)

class Solution {
    int dfs(int src,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        int cnt=1;

        for(Integer itr : adj.get(src)){
            if(!vis[itr]){
                cnt+=dfs(itr,vis,adj);
            }
        }
        return cnt;
    }

    boolean isInRange(int[] a,int[] b){
        if(Math.pow(a[0]-b[0],2)+Math.pow(a[1]-b[1],2) <= Math.pow(a[2],2))
            return true;
        return false;
    }
    public int maximumDetonation(int[][] bombs) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = bombs.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                
                int[] bomb1 = bombs[i];
                int[] bomb2 = bombs[j];

                if(isInRange(bomb1,bomb2)){
                    adj.get(i).add(j);
                }
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            boolean[] vis = new boolean[n];
            max = Math.max(max,dfs(i,vis,adj));
        }

        return max;

    }
}
