//https://leetcode.com/problems/zero-array-transformation-i/description/

soln2 - https://leetcode.com/problems/zero-array-transformation-i/solutions/6530947/optimized-o-n-m-java-solution-difference-array-beginner-friendly/


soln1 -
  class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = queries.length;
        for(int i=0;i<n;i++){
            int idx1 = queries[i][0];
            int idx2 = queries[i][1];
            for(int j=idx1;j<=idx2;j++){
                nums[j]--;
            }
        }
         for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return false;
         }
         return true;
    }
}


soln2 - 
  class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for(int[] q : queries){
            int li=q[0],ri=q[1];
            diff[li]--;
            diff[ri+1]++;
        }
        int currentDecrement = 0;
         for(int i=0;i<nums.length;i++){
            currentDecrement+=diff[i];
            if(nums[i]+currentDecrement>0) return false;
         }
         return true;
    }
}
