 public int maxProfit(int[] prices) {
        int profit=0;
        int minVal = prices[0];
        for(int i=1;i<prices.length;i++){
            int cost = prices[i]-minVal;
            minVal=Math.min(minVal,prices[i]);
            profit = Math.max(profit,cost);
        }
        return profit;
    }
