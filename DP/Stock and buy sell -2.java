//recursion
int solve(int ind,boolean canBuy,int n,int[] prices){
        if(ind == n)
            return 0;
        int profit = 0;
        if(canBuy){
             profit =  Math.max(-prices[ind] + solve(ind+1,false,n,prices),solve(ind+1,true,n,prices));
        }
        else{
            profit =  Math.max(prices[ind]+solve(ind+1,true,n,prices),solve(ind+1,false,n,prices));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return solve(0,true,n,prices);
    }

//memoization
 int solve(int ind,int canBuy,int n,int[] prices,int[][] dp){
        if(ind == n)
            return 0;
        int profit = 0;
        if(dp[ind][canBuy]!=-1)
            return dp[ind][canBuy];
        if(canBuy==1){
             profit =  Math.max(-prices[ind] + solve(ind+1,0,n,prices,dp),solve(ind+1,1,n,prices,dp));
        }
        else{
            profit =  Math.max(prices[ind]+solve(ind+1,1,n,prices,dp),solve(ind+1,0,n,prices,dp));
        }
        return dp[ind][canBuy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return solve(0,1,n,prices,dp);
    }
