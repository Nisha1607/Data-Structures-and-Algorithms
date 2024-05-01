https://leetcode.com/problems/count-number-of-nice-subarrays/description/

//TC :O(n*n)
 public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int nice=0;
        int cnt=0;
        
        for(int i=0;i<n;i++){
            cnt=0;
            for(int j=i;j<n;j++){
                if(nums[j]%2!=0) cnt++;
                if(cnt==k) {
                    nice++;
                }
            }
        }
        return nice;
    }


//TC :O(n)
  public int numberOfSubarrays(int[] nums, int k) {
           int n = nums.length;
        int cnt=0;
        int l=0,r=0;
        int sum=0;
        int temp=0;
        while(r<n){
          sum+=nums[r]%2;
          if(nums[r]%2==1)
            temp=0;
          if(sum>k){
            sum-=nums[l]%2;
            l++;
          }
          while(sum==k && l<=r){
            sum-=nums[l]%2;
            temp++;
            l++;
          }
          cnt+=temp;
          r++;
        }
        return cnt;
    }
