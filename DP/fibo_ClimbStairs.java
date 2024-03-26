//recursion

int climbStairs(int n){
  if(n==0||n==1) retrun 1;
  return climbStairs(n-1)+climbStairs(n-2);
}

//memoization
int solve(int n,int[] dp){
  if(n==0||n==1) return 1;
  if(dp[n]!=-1) return dp[n];
  dp[n] = solve(n-1,dp) + solve(n-2,dp);
  return dp[n];
}

int climbStairs(int n){
  int dp[] = new dp[n+1];
  Arrays.fill(dp,-1);
  solve(n,dp);
}

//Tabulation
int solve(int n,int[] dp){
  dp[o]=1;
  dp[1]=1;
  for(int i=2;i<n;i++){
    dp[i]=dp[i-1]+dp[i-2];
  }
  return dp[n];
}

int climbStairs(int n){
  int dp[] = new dp[n+1];
  Arrays.fill(dp,-1);
  solve(n,dp);
}

//spce optimized tabulation
int solve(int n,int[] dp){
  int prev=1;
  int prevOfprev=1;
  int curr;
  for(int i=1;i<n;i++){
    curr=prev+prevOfPrev;
    prevOfprev = prev;
    prev=curr;
  }
  return prev;
}

int climbStairs(int n){
  solve(n);
}
