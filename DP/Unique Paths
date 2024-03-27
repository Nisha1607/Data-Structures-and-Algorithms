//recursion
//TC : O(2^(m*n))
//SC : O(m-1 + n-1)

int solve(int i,int j){
        if(i==0&&j==0) return 1;
        if(i<0||j<0) return 0;
        int left = solve(i,j-1);
        int up = solve(i-1,j);
        return left+up;
}


public int uniquePaths(int m, int n) {
       return solve(m-1,n-1);
}


//memoization
//TC : O((m*n))
//SC : O(m-1 + n-1) + O(m*n)
int solve(int i,int j,int[][] dp){
        if(i==0&&j==0) return 1;
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int left = solve(i,j-1);
        int up = solve(i-1,j);
        return dp[i][j] = left+up;
}


public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];
        for(int[] val : dp)
            Arrays.fill(val,-1);
       return solve(m-1,n-1,dp);
}

//Tabulation
//TC : O((m*n))
//SC : O(m*n)


public int uniquePaths(int m, int n) {
      int[][] dp = new int[m][n];
       
        for(int i=0;i<m;i++){
            int left=0,right=0;
            for(int j=0;j<n;j++){
                if(i==0&&j==0) 
                    dp[i][j] = 1;
                else {
                    if(j>0)
                        left = dp[i][j-1];
                    if(i>0)
                        right = dp[i-1][j];
                    dp[i][j] = left + right;
                }
            }
        }
        return dp[m-1][n-1];
}
