//recursion

  int solve(int i,int j,int[][] grid){
        if(i==0&&j==0) return grid[0][0];
        if(i<0||j<0) return (int) (1e9); 

        int left = grid[i][j] + solve(i,j-1,grid);
      
        int  up =  grid[i][j] + solve(i-1,j,grid);
        return Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
       
        int m=grid.length;
        int n=grid[0].length;
        
        return solve(m-1,n-1,grid);
    }


//memoization
   int solve(int i,int j,int[][] grid,int[][] dp){
        if(i==0&&j==0) return grid[0][0];
        if(i<0||j<0) return (int) (1e9); 
        if(dp[i][j]!=-1) return dp[i][j];

        int left = grid[i][j] + solve(i,j-1,grid,dp);
      
        int  up =  grid[i][j] + solve(i-1,j,grid,dp);
        return dp[i][j] = Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
       
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return solve(m-1,n-1,grid,dp);
    }



//Tabulation
 public int minPathSum(int[][] grid) {
       
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                if(i==0&&j==0) dp[i][j]=grid[i][j];
                else{
                    int left = grid[i][j];
                    int up =  grid[i][j];
                    if(j>0)
                       left += dp[i][j-1];
                    else
                        left += (int) (1e9);
                    if(i>0)
                       up += dp[i-1][j];
                     else
                        up += (int) (1e9);
                    dp[i][j] = Math.min(left,up);
                }
            }
        }
        return dp[m-1][n-1];
    }
