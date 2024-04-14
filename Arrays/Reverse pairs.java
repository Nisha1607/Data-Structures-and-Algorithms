//Given an integer array nums, return the number of reverse pairs in the array.

//A reverse pair is a pair (i, j) where:

//0 <= i < j < nums.length and
//nums[i] > 2 * nums[j].

//TC: O(n*n)

  public int reversePairs(int[] nums) {
        int n = nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int x = nums[i];
            for(int j=i+1;j<n;j++){
                if(x > nums[j]<<1)
                    cnt++;
            }
        }
        return cnt;
    }
