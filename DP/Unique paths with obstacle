//recursion
// TC : O(2^(m*n))
// SC : O(m+n)

 int solve(int i,int j,int[][] obstacleGrid){
        if(i==0&&j==0) {
            if(obstacleGrid[i][j]!=1)
            return 1;
        }
        if(i<0||j<0) return 0;
        int left=0,up=0;
        if(obstacleGrid[i][j]!=1)
             left = solve(i,j-1,obstacleGrid);
        if(obstacleGrid[i][j]!=1)
             up = solve(i-1,j,obstacleGrid);
        return left + up;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return solve(m-1,n-1,obstacleGrid);
    }

//memoization
// TC : O(m*n)
// SC : O(m+n) + O(m*n)


int solve(int i,int j,int[][] obstacleGrid,int[][] dp){
        if(i==0&&j==0) {
            if(obstacleGrid[i][j]!=1)
                return 1;
            else
                return 0;
        }
        if(i<0||j<0) return 0;
        int left=0,up=0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(obstacleGrid[i][j]!=1)
             left = solve(i,j-1,obstacleGrid,dp);
        if(obstacleGrid[i][j]!=1)
             up = solve(i-1,j,obstacleGrid,dp);
        return dp[i][j]=left + up;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] vals : dp){
            Arrays.fill(vals,-1);
        }
        return solve(m-1,n-1,obstacleGrid,dp);
    }


//Tabulation
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
       
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                int left = 0,up = 0;
                if(i==0&&j==0&&obstacleGrid[i][j]!=1)
                    dp[i][j] = 1;
                else if(i==0&&j==0&&obstacleGrid[i][j]==1)
                    dp[i][j] = 0;
                else{
                     if(obstacleGrid[i][j]!=1&&j>0)
                        left = dp[i][j-1];
                      if(obstacleGrid[i][j]!=1&&i>0)
                        up = dp[i-1][j];
                     dp[i][j]=left + up;
                }

            }
        }
        return dp[m-1][n-1];
    }

