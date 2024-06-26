// recursion
// TC : O(2^n)
// SC : O(n)

   static int solve(int ind,int[] weight,int[] value,int maxWeight){
        if(ind==0) {
            if(weight[0] <= maxWeight)
                return value[ind];
            else    
                return 0;
        }
        int pick =0;
        if(maxWeight-weight[ind]>=0)
            pick = value[ind] + solve(ind-1,weight,value,maxWeight-weight[ind]);
        int noPick = solve(ind-1,weight,value,maxWeight);
        return Math.max(pick, noPick);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            return solve(n-1,weight,value,maxWeight);
    }



// memoization
// TC : O(maxWeight*n)
// SC : O(n) +  O(maxWeight*n)
   static int solve(int ind,int[] weight,int[] value,int maxWeight,int[][] dp){
        
        if(ind==0) {
            if(weight[0] <= maxWeight)
                return value[ind];
            else    
                return 0;
        }
        if(dp[ind][maxWeight]!=-1) return dp[ind][maxWeight];
        int pick =0;
        if(maxWeight-weight[ind]>=0)
            pick = value[ind] + solve(ind-1,weight,value,maxWeight-weight[ind],dp);
        int noPick = solve(ind-1,weight,value,maxWeight,dp);
        return dp[ind][maxWeight]=Math.max(pick, noPick);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

            int[][] dp = new int[n][maxWeight+1];
            for(int[] rows : dp){
                Arrays.fill(rows,-1);
            }
            return solve(n-1,weight,value,maxWeight,dp);

    }


// Tabulation
// TC : O(maxWeight*n)
// SC : O(maxWeight*n)

   static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[][] dp = new int[n][maxWeight+1];
        for(int i=wt[0];i<=maxWeight;i++)
              dp[0][i]=value[0];

        for(int ind=1;ind<n;ind++){
          for(int cap = 0;cap<=maxWeigjt;cap++){
                int pick =0;
                if(cap-weight[ind]>=0)
                  pick = val[ind] + dp[i-1][cap-weight[ind];
                int noPick = dp[i-1][cap];
                dp[ind][cap] = Math.max(pick,noPick);
          }
        }
        return dp[n-1][maxWeight];
    }


//Space optimized
// TC : O(maxWeight*n)
// SC : O(maxWeight)
static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
   
            int[] dp = new int[maxWeight+1];
            for(int i=weight[0];i<=maxWeight;i++)
                dp[i] = value[0];
            
            for(int ind=1;ind<n;ind++){
                for(int cap = maxWeight;cap >=0 ;cap--){
                     int pick = 0;
                    if(cap-weight[ind]>=0)
                        pick = value[ind] + dp[cap-weight[ind]];
                    int noPick = dp[cap];
                    dp[cap]=Math.max(pick, noPick);
                }
            }
            return dp[maxWeight];
    }
