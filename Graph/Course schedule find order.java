//dfs
//TC : O(V+E)
//SC : O(V)
  boolean dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean[] dfsVis,boolean[] vis,Stack<Integer> stk){
        vis[src]=true;
        dfsVis[src]=true;

        for(Integer itr : adj.get(src)){
            if(!vis[itr]){
                if(dfs(itr,adj,dfsVis,vis,stk))
                    return true;
            }
            else if(dfsVis[itr])
                return true;
        }

        stk.push(src);
        dfsVis[src]=false;
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList());
        }

        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] dfsVis = new boolean[numCourses];
        Stack<Integer> stk = new Stack<>();

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,adj,dfsVis,vis,stk))
                    return new int[]{};
            }     
        }
        int[] res = new int[numCourses];
        int k=0;
        while(!stk.isEmpty()){
            res[k++]=stk.pop();
        }
        return res; 
    }


//bfs
//TC : O(V+E)
//SC : O(V)

 
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> edge : prerequisites){
            adj.get(edge.get(1)).add(edge.get(0));
        }
        
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(Integer itr : adj.get(i))
                indegree[itr]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        int[] topo = new int[n];
        int k=0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo[k++]=node;
            for(Integer itr : adj.get(node)){
                indegree[itr]--;
                if(indegree[itr]==0)
                    q.add(itr);
            }
        }
        
        if(k==n)
            return topo;
        return new int[]{};
    }
