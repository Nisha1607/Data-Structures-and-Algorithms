
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].



Bruit force approach -
 public int[] twoSum(int[] nums, int target) {
        int sum=0;
        int ans[]={0,0};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                sum = nums[i] + nums[j];
                if(sum == target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
}

Complexities :
TC : O(n2)
SC : O(1)




approach 2 - One Pass hash
    public int[] twoSum(int[] nums, int target) {
        int ans[]={0,0};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
                ans[0]=i;
                ans[1]=map.get(target-nums[i]);
                break;
            }
        }
        return ans;
    }


Complexities :
TC : O(n)
SC : O(n)


approach 3 - One pass Hash

  public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
           if(map.containsKey(target-nums[i]) ){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }


Complexities :
TC : O(n)
SC : O(n)
