 boolean isPossible(int mid, int[] nums,int k){
        int cnt=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }
            else{
                cnt++;
                sum=nums[i];
            }
        }
        if(cnt<=k) return true;
        return false;
    }
    public int splitArray(int[] nums, int k) {
        int sum= Arrays.stream(nums).sum();
        int max=Arrays.stream(nums).max().getAsInt();
        int l=max,r=sum;
        int ans=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(isPossible(mid,nums,k)){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
