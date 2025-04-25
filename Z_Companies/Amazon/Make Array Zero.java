https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/?envType=problem-list-v2&envId=7p5x763

class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num>0)   
                set.add(num);
        }
        return set.size();
    }
}
