  int solve(int ind, int[] nums){
        if(ind==0) return 0;
        if(ind<0) return 0;
        int pick = nums[ind-1]+solve(ind-2,nums);
        int notPick = solve(ind-1,nums);
        return Math.max(pick,notPick);
    }
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
         return solve(n,arr);
    }


//memo
 int solve(int ind, int[] nums,int[] dp){
        if(ind<0) return 0;
        
        if(ind==0) return nums[0];
        
        if(dp[ind]!=-1) return dp[ind];
        int pick =  nums[ind]+solve(ind-2,nums,dp);
        int notPick =  solve(ind-1,nums,dp);
        return dp[ind] =  Math.max(pick,notPick);
    }
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        int[] dp = new int[n+1];
         Arrays.fill(dp,-1);
         return solve(n-1,arr,dp);
    }



//Tabu
public int FindMaxSum(int arr[], int n)
    {
       int[] dp = new int[n]; 
  
        // Initialize the dp[0] and dp[1] 
        dp[0] = arr[0]; 
        dp[1] = Math.max(arr[0], arr[1]); 
         int pick=0,notPick=0;
       
         
         for(int i=2;i<n;i++){
            pick =  arr[i]+dp[i-2];
            notPick =  dp[i-1];
            dp[i] =  Math.max(pick,notPick);
         }
         return dp[n-1];
    }
