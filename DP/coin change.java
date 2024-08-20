//recursion
// TC : exponential
// SC : O(target)

  int solve(int ind,int[] coins,int amount){
        if(ind==0)
        {
            if(amount%coins[0]==0)
                return amount/coins[0];
            else
                return (int)(1e9);
        }
        int pick = Integer.MAX_VALUE;
        if(amount-coins[ind]>=0)
          pick = 1+solve(ind,coins,amount-coins[ind]);
        int noPick = solve(ind-1,coins,amount);
        return Math.min(pick,noPick);
    }

    public int coinChange(int[] coins, int amount) {
       
        int ans = solve(coins.length-1,coins,amount);
        if(ans>=(int)(1e9))
            return -1;
        return ans;
    }


//recursion
// TC : O(n*target)
// SC : O(target)

 int solve(int ind,int[] coins,int amount,int[][] dp){
        if(ind==0)
        {
            if(amount%coins[0]==0)
                return amount/coins[0];
            else
                return (int)(1e9);
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int pick = Integer.MAX_VALUE;
        if(amount-coins[ind]>=0)
          pick = 1+solve(ind,coins,amount-coins[ind],dp);
        int noPick = solve(ind-1,coins,amount,dp);
        return dp[ind][amount] = Math.min(pick,noPick);
    }

    public int coinChange(int[] coins, int amount) {
       
        int[][] dp = new int[coins.length][amount+1];
        for(int[] rows : dp)
            Arrays.fill(rows,-1);

        int ans = solve(coins.length-1,coins,amount,dp);

        if(ans>=(int)(1e9))
            return -1;
        return ans;
    }

//Tabulation
 public int coinChange(int[] coins, int amount) {
       
        int[][] dp = new int[coins.length][amount+1];
       
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)
                 dp[0][i] = i/coins[0];
            else
                dp[0][i] = (int)(1e9);
        }
           
        for(int ind=1;ind<coins.length;ind++){
            for(int amt = 0;amt<=amount;amt++){
                  int pick = Integer.MAX_VALUE;
             if(amt-coins[ind]>=0)
                pick = 1+dp[ind][amt-coins[ind]];
              int noPick = dp[ind-1][amt];
             dp[ind][amt] = Math.min(pick,noPick);
            }
        }
        int ans = dp[coins.length-1][amount];
        if(ans>=(int)1e9)
            return -1;
        return ans;
    }
