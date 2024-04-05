//recursion
int solve(int ind,int n, int[] prices, int canBuy,int cap){
        if(ind==n||cap==0)
            return 0;
        int profit=0;
        if(canBuy==1){
            profit = Math.max(-prices[ind]+solve(ind+1,n,prices,0,cap),solve(ind+1,n,prices,1,cap));
        }
        else {
            profit = Math.max(prices[ind]+solve(ind+1,n,prices,1,cap-1),solve(ind+1,n,prices,0,cap));
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        return solve(0,n,prices,1,2);
    }

//memoization
 int solve(int ind,int n, int[] prices, int canBuy,int cap,int[][][] dp){
        if(ind==n||cap==0)
            return 0;
        int profit=0;
        if( dp[ind][canBuy][cap] != -1) return  dp[ind][canBuy][cap];
        if(canBuy==1){
            profit = Math.max(-prices[ind]+solve(ind+1,n,prices,0,cap,dp),solve(ind+1,n,prices,1,cap,dp));
        }
        else {
            profit = Math.max(prices[ind]+solve(ind+1,n,prices,1,cap-1,dp),solve(ind+1,n,prices,0,cap,dp));
        }
        return dp[ind][canBuy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] rows : dp){
            for(int[] row : rows)
                Arrays.fill(row,-1);
        }
        return solve(0,n,prices,1,2,dp);
    }
