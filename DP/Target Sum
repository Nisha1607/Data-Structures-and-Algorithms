// recusrion
  int solve(int ind,int sum, int n, int target,int[] nums){
        if(ind == n){
            if(sum==target)
                return 1;
            
            else
                return 0;
        }
        int  plus = solve(ind+1,sum+nums[ind],n,target,nums);
        int  minus = solve(ind+1,sum-nums[ind],n,target,nums);
       return plus+minus;
    }    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(0,0,n,target,nums);
    }
