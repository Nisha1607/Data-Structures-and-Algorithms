PS - https://www.codingninjas.com/studio/problems/frog-jump_3621012?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

//recursion
//TC : O(2^n), SC: O(n)
int solve(int ind,int[] heights){
      if(ind==0) return 0;
      int oneStep = solve(ind-1,heights)+ Math.abs(heights[ind]-heights[ind-1]);
      int twoStep = Integer.MAX_VALUE;
      if(ind>1){
             twoStep = solve(ind-2,heights) + Math.abs(heights[ind]-heights[ind-2]);
       }
       return Math.min(oneStep,twoStep);
}

int frogJump(int n,int[] heights){
  return solve(n-1,heights)
}

//Memoization
//TC : O(n), SC: O(n)+O(n) auxillary calls of stack
int solve(int ind,int[] dp,int[] heights){
      if(ind==0) return 0;
      if(dp[ind]!=-1) return dp[ind];
      int oneStep = solve(ind-1,dp,heights)+ Math.abs(heights[ind]-heights[ind-1]);
      int twoStep = Integer.MAX_VALUE;
      if(ind>1){
             twoStep = solve(ind-2,dp,heights) + Math.abs(heights[ind]-heights[ind-2]);
       }
       return dp[ind]=Math.min(oneStep,twoStep);
}

int frogJump(int n,int[] heights){
  int[] dp = new int[n];
  Arrays.fill(dp,-1);
  return solve(n-1,dp,heights);
}

//Tabulation
//TC : O(n), SC: O(n)
int solve(int n,int[] dp,int[] heights){
      dp[0]=0;
      for(int i=1;i<n;i++){
         int oneStep = dp[i-1]+ Math.abs(heights[i]-heights[i-1]);
         int twoStep = Integer.MAX_VALUE;
         if(i>1){
             twoStep = dp[i-2]+ Math.abs(heights[i]-heights[i-2]);
         }
          dp[i] = Math.min(oneStep,twoStep);
      }
       return dp[n-1];
}

int frogJump(int n,int[] heights){
  int[] dp = new int[n];
  Arrays.fill(dp,-1);
  return solve(n,dp,heights);
}
