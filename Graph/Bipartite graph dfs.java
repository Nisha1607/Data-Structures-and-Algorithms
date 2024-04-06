   boolean dfs(int src,int[][] graph,int[] color){
       
        for(int adjNode : graph[src]){
            if(color[adjNode]==-1){
                color[adjNode] = 1-color[src];
               if(!dfs(adjNode,graph,color))  return false;
            }
            else if(color[src]==color[adjNode]){
                return false;
            }
        }
        return true;
    }
  
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        
        int[] color = new int[n];
        Arrays.fill(color,-1);


        for(int i=0;i<n;i++){
            
            if(color[i]==-1){
                 color[i]=0;
                if(!dfs(i,graph,color))
                   return false;
            }
        }
        return true;

    }
