// TC : O(n*m*4)
// SC : O(n*m)

//dfs
 void dfs(int i,int j,int[][] grid,boolean[][] visited){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1||grid[i][j]==0||visited[i][j]==true) return;
        
        grid[i][j]=0;
        visited[i][j]=true;
        dfs(i-1,j,grid,visited);
        dfs(i,j-1,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i+1,j,grid,visited);
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int m = grid.length;
        int n = grid[0].length;
    
        int cnt=0;
        
        boolean[][] visited = new boolean[m][n];
        
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               
               if(grid[i][j]==1 && !visited[i][j] &&(i==0 || j==0||i==m-1||j==n-1)){
                    dfs(i,j,grid,visited);
               }
                   
           }
       }
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j]==1) cnt++;
           }
       }
       
       return cnt;
    }


//bfs
 int numberOfEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int cnt=0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               
               if(grid[i][j]==1 &&(i==0 || j==0||i==m-1||j==n-1)){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
               }
                   
           }
       }
       
       int[] dx = {0,0,1,-1};
       int[] dy = {1,-1,0,0};
       
       while(!q.isEmpty()){
           int[] data = q.remove();
           int row = data[0];
           int col = data[1];
           for(int i=0;i<4;i++){
               int x = row+dx[i];
               int y = col+dy[i];
               if(x>=0 && y>=0 &&x<m && y<n && !visited[x][y] && grid[x][y]==1){
                   q.add(new int[]{x,y});
                   visited[x][y] = true;
               }
               
           }
       }
       
       for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(grid[i][j]==1 && !visited[i][j]) cnt++;
           }
       }
       
       return cnt;
    }
