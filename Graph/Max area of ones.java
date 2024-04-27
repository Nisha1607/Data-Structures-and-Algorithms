 void dfs(int i,int j,int[][] grid,int[] cnt,boolean[][] visited){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||visited[i][j]||grid[i][j]==0) return;

        visited[i][j]=true;

         cnt[0]++;
     
        dfs(i+1,j,grid,cnt,visited);
        dfs(i-1,j,grid,cnt,visited);
        dfs(i,j+1,grid,cnt,visited);
        dfs(i,j-1,grid,cnt,visited);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       
        boolean[][] visited = new boolean[m][n];
        int[] cnt = new int[1];
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    cnt[0]=0;
                    dfs(i,j,grid,cnt,visited);
                    
                    maxArea = Math.max(maxArea,cnt[0]);
                }
            }
        }
        return maxArea;
    }
