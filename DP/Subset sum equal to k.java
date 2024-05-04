//recursion
//TC :O(2^n)
//SC : O(n)

    static boolean solve(int ind,int target,int[] arr){
        if(target == 0) return true;
        if(ind==0) return (arr[ind] == target);
         boolean pick=false;
        if(target>=arr[ind])
            pick =  solve(ind-1,target-arr[ind],arr);
        boolean notPick = solve(ind-1,target,arr);
        return pick||notPick;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        return solve(n-1,k,arr);
    }


//memoization
// TC : O(n*target)
//SC : O(n*target)+O(n)
static boolean solve(int ind,int target,int[] arr,int[][] dp){
        if(target == 0) return true;
        if(ind==0) return (arr[ind] == target);
        if(dp[ind][target]!=-1) return dp[ind][target] == 0 ? false : true;
         boolean pick=false;
        if(target>=arr[ind])
            pick =  solve(ind-1,target-arr[ind],arr,dp);
        boolean notPick = solve(ind-1,target,arr,dp);
        dp[ind][target] = notPick || pick ? 1 : 0;
        return  pick||notPick;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return solve(n-1,k,arr,dp);
    }



//tabulation
//TC : O(n*target)
//SC : O(n*target)


 public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }
        for(int ind=1;ind<n;ind++){
            for(int target = 1;target<=k;target++){
                boolean pick = false;
                if(target>=arr[ind])
                    pick = dp[ind-1][target-arr[ind]];
                boolean  notPick = dp[ind-1][target];
                dp[ind][target] = pick | notPick;
            }
        }
        return dp[n-1][k];
    }



//Space optimzation
// TC : O(n*target)
//SC : O(2*target)

      // Write your code here.
        boolean[] prev = new boolean[k+1];
   
        prev[0] = true;
        
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }
        for(int ind=1;ind<n;ind++){
            boolean curr[] = new boolean[k + 1];
            
            curr[0] = true;
            for(int target = 1;target<=k;target++){
                boolean pick = false;
                if(target>=arr[ind])
                    pick =prev[target-arr[ind]];
                boolean  notPick = prev[target];
                curr[target] = pick | notPick;
            }
            prev=curr;
        }
        return prev[k];
    }
