//TC : O(n2)
 public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int zero=0;
            for(int j=i;j<n;j++){
                if(nums[j]==0)
                    zero++;
                if(zero<=k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }

TC : O(n+n)
 public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int l=0,r=0,zeros=0;
        while(r<n){
            if(nums[r]==0)
                zeros++;
            if(zeros<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            while(zeros>k){
                if(nums[l]==0)
                    zeros--;
                l++;
            }
            r++;
        }
        return maxLen;
    }



TC:O(n)
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int l=0,r=0,zeros=0;
        while(r<n){
            if(nums[r]==0)
                zeros++;
            if(zeros<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            else{
                if(nums[l]==0) 
                    zeros--;
                l++;
            }
            r++;
        }
        return maxLen;
    }
