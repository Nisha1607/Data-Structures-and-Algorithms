	static int solve(int i,int j,int[] p,int[][] dp){
		int minVal = Integer.MAX_VALUE;
		if(i==j) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		for(int k=i;k<j;k++){
			int cost = p[i-1]*p[k]*p[j] + solve(i,k,p,dp) + solve(k+1,j,p,dp);
			minVal = Math.min(minVal,cost);
		}
		return dp[i][j] = minVal;
	}
	
	public static int mcm(int[] p){

		int N = p.length;
		int[][] dp = new int[N][N];
	    for(int[] rows : dp){
		 	 for(int i=0;i<rows.length;i++)
			  		rows[i]=-1;
		 }
		return solve(1,N-1,p,dp);

	}
