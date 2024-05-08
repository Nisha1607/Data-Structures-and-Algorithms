// TC : O(n*n)
// SC: O(1)

class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int maxLen = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(arr[i]<=arr[j]){
                    maxLen = Math.max(maxLen,j-i);
                }
            }
        }
        return maxLen;
    }
}


2.
// TC : O(n)
// SC : O(n+n) = O(n)

class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int maxLen = 0;
        
        int[] leftMinSum = new int[n];
        int[] rightMaxSum = new int[n];
        
        leftMinSum[0]=arr[0];
        
        for(int i=1;i<n;i++){
            leftMinSum[i] = Math.min(leftMinSum[i-1],arr[i]);    
        }
        
        rightMaxSum[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightMaxSum[i] = Math.max(rightMaxSum[i+1],arr[i]);    
        }
        
        int i=0;
        int j=0;
        
        while(i<n&&j<n){
            if(leftMinSum[i]<=rightMaxSum[j]){
                maxLen = Math.max(maxLen,j-i);
                j++;
            }
            else
                i++;
        }
        
        return maxLen;
    }
}


3.
  // TC : O(n)
  // SC : O(n)

  

class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int maxLen = 0;
        
        int[] leftMinSum = new int[n];
        int[] rightMaxSum = new int[n];
        
        leftMinSum[0]=arr[0];
        
        for(int i=1;i<n;i++){
            leftMinSum[i] = Math.min(leftMinSum[i-1],arr[i]);    
        }
        
        rightMaxSum[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightMaxSum[i] = Math.max(rightMaxSum[i+1],arr[i]);    
        }
        
        int i=0;
        int j=0;
        
        while(i<n&&j<n){
            if(arr[i]<=rightMaxSum[j]){
                maxLen = Math.max(maxLen,j-i);
                j++;
            }
            else
                i++;
        }
        
        return maxLen;
    }
}




