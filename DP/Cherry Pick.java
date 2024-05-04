//Recursion
//TC : (3^n * 3^n)
//SC : O(n)


	static int solve(int i,int j1,int j2,int m,int n, int[][] grid){
		if(j1<0||j1>=n||j2<0||j2>=n) return (int)(-1e9);
		if(i==m-1){
			if(j1==j2) return grid[i][j1];
			else{
				return grid[i][j1]+grid[i][j2];
			}
		}
		int maxValue= (int)(-1e9);
		for(int d1 = -1 ; d1<=1; d1++){
			for(int d2 = -1 ; d2<=1;d2++){
				int value = 0;
				if(j1==j2) {
					value =grid[i][j1];
				}
				else{
					value = grid[i][j1]+ grid[i][j2];
				}
				value +=  solve(i+1,j1+d1,j2+d2,m,n,grid);
				maxValue = Math.max(maxValue,value);
			}
		}
		return maxValue;
	}
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		 return solve(0,0,c-1,r,c,grid);
	}

//Memoization
//TC: O(m*n*n*9)
//SC : O(m*n*n) + O(n)

	static int solve(int i,int j1,int j2,int m,int n, int[][] grid,int[][][] dp){
		if(j1<0||j1>=n||j2<0||j2>=n) return (int)(-1e9);
		if(i==m-1){
			if(j1==j2) return grid[i][j1];
			else{
				return grid[i][j1]+grid[i][j2];
			}
		}
		if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
		int maxValue= (int)(-1e9);
		for(int d1 = -1 ; d1<=1; d1++){
			for(int d2 = -1 ; d2<=1;d2++){
				int value = 0;
				if(j1==j2) {
					value =grid[i][j1];
				}
				else{
					value = grid[i][j1]+ grid[i][j2];
				}
				value +=  solve(i+1,j1+d1,j2+d2,m,n,grid,dp);
				maxValue = Math.max(maxValue,value);
			}
		}
		return dp[i][j1][j2] = maxValue;
	}
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[r][c][c];
		for (int row1[][] : dp) {
      		for (int row2[] : row1) {
        		Arrays.fill(row2, -1);
    	  }
    	}
		 return solve(0,0,c-1,r,c,grid,dp);
	}


//Tabulation
//TC: O(m*n*n*9)
//SC : O(m*n*n) 
public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[r][c][c];
		for(int j1=0;j1<c;j1++){
			for(int j2=0;j2<c;j2++){
				if(j1==j2)
					dp[r-1][j1][j2] = grid[r-1][j1];
				else
					dp[r-1][j1][j2] = grid[r-1][j1]+grid[r-1][j2];
			}
			
		}
			
		for(int i=r-2;i>=0;i--){
			for(int j1=0;j1<c;j1++){
					for(int j2=0;j2<c;j2++){
						int maxValue= (int)(-1e9);
						for(int d1 = -1 ; d1<=1; d1++){
							for(int d2 = -1 ; d2<=1;d2++){
								int value = 0;
								if(j1==j2) {
									value =grid[i][j1];
								}
								else{
									value = grid[i][j1]+ grid[i][j2];
								}
								if(j1+d1>=0&&j1+d1<=c-1&&j2+d2>=0&&j2+d2<=c-1)
									value +=  dp[i+1][j1+d1][j2+d2];
								else
									value+=(int)(-1e9);
								maxValue = Math.max(maxValue,value);
							}
					}
					dp[i][j1][j2]=maxValue;
				}
			}
		}
		 return dp[0][0][c-1];
	}
