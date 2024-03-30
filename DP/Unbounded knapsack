public class Solution {
    static int solve(int ind,int target,int[] profit, int[] weight){
        if(ind==0){
                return ((int) (target / weight[0])) *profit[0];
        }
        int take =0;
        if(target-weight[ind]>=0)
        take = profit[ind] + solve(ind,target-weight[ind],profit,weight);
        int noTake = solve(ind-1,target,profit,weight);
        return Math.max(take, noTake);

    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        return solve(n-1,w,profit,weight);
    }
}
