//recursion

int solve(int n, int k, int []height,int minCost){
    if(n==0) return 0;
       
    for(int i=1;i<=k && n - i >= 0;i++){
       int left =  solve(n-i,k,height,minCost)+Math.abs(height[n]-height[n-i]);
       minCost = Math.min(left,minCost);
     }
     return minCost;
 }


int minimizeCost(int n, int k, int []height){
  int minCost = Integer.MAX_VALUE;
  return solve(n-1,k,height,minCost);
}


//memoization

int solve(int n, int k, int []height,int minCost,int[] dp){
    if(n==0) return 0;
    if(dp[n]!=-1) return dp[n];
    for(int i=1;i<=k && n - i >= 0;i++){
       int left =  dp[n-i]+Math.abs(height[n]-height[n-i]);
       minCost = Math.min(left,minCost);
     }
     return dp[n]=minCost;
 }


int minimizeCost(int n, int k, int []height){
  int[] dp = new int[n];
  int minCost = Integer.MAX_VALUE;
  return solve(n-1,k,height,minCost);
}

//tabulation 

int solve(int n, int k, int []height,int minCost,int[] dp){
    dp[0]=0;
         for(int j=1;j<n;j++){
             minCost = Integer.MAX_VALUE;
            for(int i=1;i<=k && j - i >= 0;i++){
                 int left =  dp[j-i]+Math.abs(height[j]-height[j-i]);
                minCost = Math.min(left,minCost);
            }
           dp[j]=minCost;
     }
     return dp[n-1];
 }


int minimizeCost(int n, int k, int []height){
  int[] dp = new int[n];
  int minCost = Integer.MAX_VALUE;
  return solve(n,k,height,minCost);
}
