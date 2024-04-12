Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

static int majorityElement(int a[], int size)
    {
        // your code here
       Map<Integer,Integer> mp = new HashMap<>();
       for (Integer i : a) {
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            }
            else {
                mp.put(i, 1);
            }
        }
        for (Integer num : mp.keySet())  
        { 
            Integer cnt = mp.get(num); 
             if(cnt>(size/2)) 
                return num;
        } 
        return -1;
    }


public int majorityElement(int[] nums) {
        int maxInd =0,cnt=1;
        for(int i=1;i<nums.length;i++){
            if(nums[maxInd]==nums[i])
                cnt++;
            else
                cnt--;
            if(cnt==0){
                cnt=1;
                maxInd=i;
            }
        }
        return nums[maxInd];
    }
