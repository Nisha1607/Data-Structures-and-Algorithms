 public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int n =nums.length;
        int start = 0;
        int end = n-1;
        int mid;
        int lower = -1;
        int upper = -1;
    
        while(start<=end){
            mid = (start+end)/2;
            if(nums[mid]==target){
                lower = mid;
                upper = mid;
                while(lower>0 && nums[lower-1]==target){
                    lower--;
                }
                while(upper<nums.length-1 && nums[upper+1]==target){
                    upper++;
                }
                break;
            }
              
            else if(nums[mid]<target)
                start = mid+1;
            else
                end = mid-1;
           
        }
        ans[0]=lower;
        ans[1]=upper;
        return ans;
    }
