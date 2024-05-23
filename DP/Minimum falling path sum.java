//recursion
//TC : O(3^n)
//SC : O(n)

 int solve(int i,int j,int m,int n,int[][] matrix){
        if(j<0||j>=n) return (int)(1e9);
      
        if(i==0) return matrix[0][j];
        
        int left = matrix[i][j] + solve(i-1,j-1,m,n,matrix);
        int up = matrix[i][j] + solve(i-1,j,m,n,matrix);
        int diagonal = matrix[i][j] + solve(i-1,j+1,m,n,matrix);
        
        return Math.min(left,Math.min(up,diagonal));
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int minVal = Integer.MAX_VALUE;
         for (int j = n-1; j >= 0; j--) {
            int ans = solve(m-1, j, m, n,matrix);
            minVal = Math.min(minVal, ans);
        }
        return minVal;
    }


//Memoization
//TC : O(m*n)
//SC : O(n) + O(m*n)

 int solve(int i,int j,int m,int n,int[][] matrix,int[][] dp){
        if(j<0||j>=n) return (int)(1e9);
      
        if(i==0) return matrix[0][j];
        
        if(dp[i][j]!=-1) return dp[i][j];

        int left = matrix[i][j] + solve(i-1,j-1,m,n,matrix,dp);
        int up = matrix[i][j] + solve(i-1,j,m,n,matrix,dp);
        int diagonal = matrix[i][j] + solve(i-1,j+1,m,n,matrix,dp);

        return dp[i][j] = Math.min(left,Math.min(up,diagonal));
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int minVal = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int[] rows : dp)
            Arrays.fill(rows,-1);
         for (int j = n-1; j >= 0; j--) {
            int ans = solve(m-1, j, m, n,matrix,dp);
            minVal = Math.min(minVal, ans);
        }
        return minVal;
    }


//Tabulation
  public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int minVal = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int j=0;j<m;j++)
            dp[0][j] = matrix[0][j];
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int left = matrix[i][j];
                if(j>0) 
                    left+= dp[i-1][j-1];
                else 
                    left+= (int)(1e9);
                int up = matrix[i][j] +  dp[i-1][j];
                int diagonal = matrix[i][j];
                if(j<n-1)
                   diagonal +=  dp[i-1][j+1];
                else
                   diagonal += (int)(1e9);
                dp[i][j] = Math.min(left,Math.min(up,diagonal));
            }
        }
        for(int j=0;j<n;j++){
            int  ans = dp[m-1][j];
             minVal = Math.min(minVal, ans);
        }
        return minVal;
    }

//Space optimized
 public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int minVal = Integer.MAX_VALUE;
        int[] dp = new int[n];
        for(int j=0;j<m;j++)
            dp[j] = matrix[0][j];
        for(int i=1;i<m;i++){
            int[] tmp = new int[n];
            for(int j=0;j<n;j++){
                int left = matrix[i][j];
                if(j>0) 
                    left+= dp[j-1];
                else 
                    left+= (int)(1e9);
                int up = matrix[i][j] +  dp[j];
                int diagonal = matrix[i][j];
                if(j<n-1)
                   diagonal +=  dp[j+1];
                else
                   diagonal += (int)(1e9);
                tmp[j] = Math.min(left,Math.min(up,diagonal));
            }
            dp = tmp;
        }
        for(int j=0;j<n;j++){
            int  ans = dp[j];
             minVal = Math.min(minVal, ans);
        }
        return minVal;
    }
