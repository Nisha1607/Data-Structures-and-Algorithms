//TC : O(n*n)

   public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==goal)
                    cnt++; 
            }
        }
        return cnt;
    }
