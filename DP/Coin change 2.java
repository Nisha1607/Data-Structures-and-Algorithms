  public int change(int amount, int[] coins) {
        int ans = solve(coins.length-1,coins,amount);
        return ans;
    }
       
    int solve(int ind,int[] coins,int amount){
        if(ind==0)
        {
            if(amount%coins[0]==0)
                return 1;
            else
                return 0;
        }
        int pick = 0;
        if(amount-coins[ind]>=0)
          pick = solve(ind,coins,amount-coins[ind]);
        int noPick = solve(ind-1,coins,amount);
        return pick+noPick;
    }
