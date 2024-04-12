//Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
Input:
N = 5
Arr[] = {1,2,3,-2,5}
Output:
9
//Explanation:
//Max subarray sum is 9
//of elements (1, 2, 3, -2, 5) which 
//is a contiguous subarray.

  //TC: O(n*n)
  //SC:O(1)

 long maxSubarraySum(int arr[], int n){
        
        // Your code here
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
       
        for(int left=0;left<n;left++){
            sum=0;
           for(int right=left;right<n;right++){
               sum+=arr[right];
               if(sum>maxSum)
                    maxSum = Math.max(sum,maxSum);
           }
        }
        return maxSum;
        
    }

//TC:O(n)
long maxSubarraySum(int arr[], int n){
        
        // Your code here
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        int left = 0;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            if(sum>maxSum){
                maxSum = Math.max(maxSum,sum);
            }
           if(sum<0)
            sum =0;
        }
        return maxSum;
        
    }

  
