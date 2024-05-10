//TC : baselength * 3^(toppings.lngth)


class Solution {
    int min = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[] result=new int[1];
        
        for(int base : baseCosts){
            dfs(toppingCosts,0,base,target,result);
        }

        return result[0];
    }

    void dfs(int[] toppingCosts,int i,int cost,int target,int[] res){
        if(i==toppingCosts.length){
            if(Math.abs(target-cost)<min || (Math.abs(target-cost)==min && cost < res[0])){
                res[0]=cost;
                min = Math.abs(target-cost);
            }
            return;
        }

        dfs(toppingCosts,i+1,cost,target,res);
        dfs(toppingCosts,i+1,cost+toppingCosts[i],target,res);
        dfs(toppingCosts,i+1,cost+toppingCosts[i]*2,target,res);
    }
}
