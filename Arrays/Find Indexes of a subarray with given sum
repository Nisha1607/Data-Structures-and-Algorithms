Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.


TC : O(N)
SC : O(1)

  static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int left = 0,right =0;
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(right<n){
            sum += arr[right];
            while(sum > s && left<right){
                sum = sum-arr[left];
                left++;
            }
            if(sum == s) {
                res.add(left+1);
                res.add(right+1);
                return res;
            }
            right++;
        }
        res.add(-1);
        return res;
    }
