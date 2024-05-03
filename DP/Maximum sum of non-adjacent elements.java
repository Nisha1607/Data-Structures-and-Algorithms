//recursion
//TC: O(2^n) SC : O(n)
 int solve(int ind, int[] nums){
        if(ind==0) return nums[ind];
        if(ind<0) return 0;
        int pick = nums[ind]+solve(ind-2,nums);
        int notPick = solve(ind-1,nums);
        return Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        return solve(nums.length-1,nums);
    }

//memoization
//TC: O(n) SC : O(n) +O(n)
 int solve(int ind, int[] nums){
        if(ind==0) return 0;
        if(ind<0) return 0;
        if(dp[ind])!=-1) return dp[ind];
        int pick = nums[ind-1]+solve(ind-2,nums);
        int notPick = solve(ind-1,nums);
        dp[ind] =  Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        return solve(nums.length,nums,dp);
    }

//Tabulation
//TC: O(n) SC : O(n) 
 
  int solve(int ind, int[] nums,int[] dp){
       dp[0]=nums[0];
       int pick=0;
        for(int i=1;i<ind;i++){
            pick=nums[i];
            if(i>1)
               pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] =  Math.max(pick,notPick);
        }
       return dp[ind-1];
       
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums.length,nums,dp);
    }

   
//Spcae Optimization

//TC: O(n) SC : O(n) 
 
    public int rob(int[] nums) {
        int n = nums.length;
        int prev2=0;
        int prev=nums[0];
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1){
                pick+=prev2;
            }
            int notPick = prev;
            int curr=Math.max(pick,notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
